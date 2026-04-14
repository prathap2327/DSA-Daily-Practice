# Day 36 — AVL Trees: Self-Balancing Binary Search Trees

> **DSA Partner Challenge** | Week 6

---

## 📌 Topic of the Day

**AVL Trees — the self-balancing BST that guarantees O(log n) for all operations.**

---

## 🎥 Resource

[AVL Trees Tutorial — Self Balancing BST](https://youtu.be/CVA85JuJEn0?si=sAjgOPezH2xdnH9I) — Kunal Kushwaha

---

## 🧠 Part 1 — Why AVL Trees?

A regular BST degenerates into a linked list with sorted input:

```
Insert 1, 2, 3, 4, 5 →   1
                           \
                            2       Height = n-1 = 4
                             \      All ops become O(n)!
                              3
                               \
                                4
                                 \
                                  5
```

AVL trees maintain **balance factor ∈ {-1, 0, +1}** at every node → guaranteed O(log n).

| Operation | BST worst | AVL guaranteed |
|-----------|-----------|----------------|
| Search | O(n) | O(log n) |
| Insert | O(n) | O(log n) |
| Delete | O(n) | O(log n) |

---

## 🧠 Part 2 — Balance Factor

```
BF(node) = height(left subtree) - height(right subtree)

BF = -1  → left-heavy  (valid)
BF =  0  → balanced    (valid)
BF = +1  → right-heavy (valid)
|BF| > 1 → UNBALANCED  → rotate!
```

```java
int height(Node n) { return n==null ? -1 : n.height; }
int getBalance(Node n) { return n==null ? 0 : height(n.left)-height(n.right); }
```

> Store `height` in each node (updated after each insert) — avoids O(n) recomputation.

---

## 🧠 Part 3 — Node Structure

```java
class Node {
    int data, height;
    Node left, right;
    Node(int d){ data=d; height=0; left=null; right=null; }
}
```

---

## 🧠 Part 4 — The 4 Rotations

### LL Case — Right Rotate
> bf > 1 AND newNode < node.left.data

```
Before:       After rightRotate(z):
    z [2]            y
   /                / \
  y [1]            x   z
 /
x
```
```java
Node rightRotate(Node z) {
    Node y=z.left; Node T3=y.right;
    y.right=z; z.left=T3;
    z.height=1+Math.max(height(z.left),height(z.right));
    y.height=1+Math.max(height(y.left),height(y.right));
    return y;  // y is new root
}
```

### RR Case — Left Rotate
> bf < -1 AND newNode > node.right.data

```
Before:     After leftRotate(z):
z [-2]            y
 \               / \
  y [-1]        z   x
   \
    x
```
```java
Node leftRotate(Node z) {
    Node y=z.right; Node T2=y.left;
    y.left=z; z.right=T2;
    z.height=1+Math.max(height(z.left),height(z.right));
    y.height=1+Math.max(height(y.left),height(y.right));
    return y;
}
```

### LR Case — Left then Right Rotate
> bf > 1 AND newNode > node.left.data

```java
node.left = leftRotate(node.left);   // Step 1
return rightRotate(node);            // Step 2
```

### RL Case — Right then Left Rotate
> bf < -1 AND newNode < node.right.data

```java
node.right = rightRotate(node.right); // Step 1
return leftRotate(node);              // Step 2
```

---

## 🧠 Part 5 — Complete AVL Insert

```java
Node insert(Node node, int data) {
    // Step 1: Normal BST insert
    if(node==null) return new Node(data);
    if(data<node.data)      node.left =insert(node.left, data);
    else if(data>node.data) node.right=insert(node.right,data);
    else return node;  // duplicate

    // Step 2: Update height
    node.height=1+Math.max(height(node.left),height(node.right));

    // Step 3: Check balance and fix
    int bf=getBalance(node);
    if(bf>1  && data<node.left.data)   return rightRotate(node);       // LL
    if(bf<-1 && data>node.right.data)  return leftRotate(node);        // RR
    if(bf>1  && data>node.left.data){                                   // LR
        node.left=leftRotate(node.left); return rightRotate(node);
    }
    if(bf<-1 && data<node.right.data){                                  // RL
        node.right=rightRotate(node.right); return leftRotate(node);
    }
    return node;
}
```

**Insert 1, 2, 3 trace:**
```
Insert 1: root=1
Insert 2: root=1 → right=2
Insert 3: root=1, bf=-2 → RR case → leftRotate(1)
Result:  2
        / \
       1   3   ← balanced!
```

---

## 🧠 Part 6 — AVL vs BST vs Red-Black

| Feature | BST | AVL | Red-Black |
|---------|-----|-----|-----------|
| Height | O(n) worst | O(log n) strict | O(log n) approx |
| Balance condition | None | bf ∈ {-1,0,1} | Color rules |
| Rotations per op | 0 | ≤2 | ≤2 |
| More balanced? | No | YES (stricter) | Less strict |
| Best for | — | Read-heavy | Write-heavy |
| Used in | — | Databases, memory maps | Linux kernel, Java TreeMap |

---

## 💻 Practice Problems — 3 Questions

---

### Q1. Balance a Binary Search Tree — [LC #1382](https://leetcode.com/problems/balance-a-binary-search-tree/) `Medium`

Inorder traversal gives sorted array → build height-balanced BST by always picking the middle element as root.

```java
List<Integer> vals=new ArrayList<>();
public TreeNode balanceBST(TreeNode root) {
    inorder(root);
    return build(0, vals.size()-1);
}
void inorder(TreeNode n){ if(n==null)return; inorder(n.left); vals.add(n.val); inorder(n.right); }
TreeNode build(int lo, int hi){
    if(lo>hi) return null;
    int mid=(lo+hi)/2;
    TreeNode node=new TreeNode(vals.get(mid));
    node.left=build(lo,mid-1); node.right=build(mid+1,hi);
    return node;
}
```

```python
def balanceBST(self, root):
    vals=[]
    def inorder(n):
        if not n: return
        inorder(n.left); vals.append(n.val); inorder(n.right)
    def build(lo,hi):
        if lo>hi: return None
        mid=(lo+hi)//2
        node=TreeNode(vals[mid])
        node.left=build(lo,mid-1); node.right=build(mid+1,hi)
        return node
    inorder(root); return build(0,len(vals)-1)
```

---

### Q2. Balanced Binary Tree (Check) — [LC #110](https://leetcode.com/problems/balanced-binary-tree/) `Easy`

Single O(n) DFS: return `-1` as sentinel when subtree is unbalanced to short-circuit.

```java
public boolean isBalanced(TreeNode root){ return check(root)!=-1; }
int check(TreeNode n){
    if(n==null) return 0;
    int L=check(n.left);   if(L==-1) return -1;
    int R=check(n.right);  if(R==-1) return -1;
    if(Math.abs(L-R)>1) return -1;
    return 1+Math.max(L,R);
}
```

```python
def isBalanced(self, root):
    def check(n):
        if not n: return 0
        L=check(n.left);   
        if L==-1: return -1
        R=check(n.right);  
        if R==-1: return -1
        if abs(L-R)>1: return -1
        return 1+max(L,R)
    return check(root)!=-1
```

> Using -1 as sentinel avoids O(n²) two-pass approach.

---

### Q3. Convert Sorted Array to BST (Height-Balanced) — [LC #108](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/) `Easy`

Always pick the middle element as root. The same `build()` logic as Q1.

```java
public TreeNode sortedArrayToBST(int[] nums){ return build(nums,0,nums.length-1); }
TreeNode build(int[] a, int lo, int hi){
    if(lo>hi) return null;
    int mid=(lo+hi)/2;
    TreeNode n=new TreeNode(a[mid]);
    n.left=build(a,lo,mid-1); n.right=build(a,mid+1,hi);
    return n;
}
```

**Trace: [-10,-3,0,5,9]**
```
mid=2 → root=0
  left:  [-10,-3] → mid=0 → root=-10, right=-3
  right: [5,9]    → mid=3 → root=5,   right=9
Result:      0
           /   \
        -10     5
           \     \
           -3     9   ← height-balanced BST!
```

---

## ✅ Checklist Before You Sleep

- [ ] I know WHY AVL trees exist — BST degenerates to O(n) without rebalancing
- [ ] BF = height(left) - height(right). Valid: {-1, 0, 1}
- [ ] 4 rotation cases: LL (rightRotate), RR (leftRotate), LR (left then right), RL (right then left)
- [ ] Identify rotation case from BF AND direction of new node
- [ ] Traced insert 1,2,3 — the RR leftRotate example
- [ ] Solved all 3 problems

---

## 💬 Community

The 4 rotations look scary at first but once you trace through 2-3 examples manually they click. Draw them on paper — which rotation clicked for you first?

**Solved all 3? Drop a 🔥 in the community.**

---

*Next up → Day 37: Segment Trees — Range Queries*
