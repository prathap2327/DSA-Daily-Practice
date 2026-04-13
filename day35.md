# Day 35 — Binary Trees: Fundamentals & Traversals

> **DSA Partner Challenge** | Week 5

---

## 📌 Topic of the Day

**Binary Trees from scratch — TreeNode, BFS, DFS (Inorder · Preorder · Postorder)**

---

## 🎥 Resource

[Binary Trees Complete Tutorial](https://youtu.be/4s1Tcvm00pA?si=wisdvohnVNMbU6Ya) — Kunal Kushwaha

---

## 🧠 Part 1 — Binary Tree Basics

A Binary Tree is a non-linear hierarchical structure where each node has **at most two children**: left and right.

| Term | Definition |
|------|-----------|
| Root | Top-most node, no parent |
| Leaf | Node with no children |
| Height | Longest path from node to a leaf. Leaf height = 0. |
| Depth | Distance from root. Root depth = 0. |
| Full BT | Every node has 0 or 2 children |
| Complete BT | All levels full except last; last filled left to right |
| Perfect BT | All internals have 2 children; all leaves at same level |
| Balanced BT | Height diff between left/right subtrees ≤ 1 at every node |

**Example tree (used throughout):**
```
         1        ← root (level 0)
       /   \
      2     3     ← level 1
     / \   / \
    4   5 6   7   ← level 2 (all leaves)
```

---

## 🧠 Part 2 — TreeNode Structure

```java
class TreeNode {
    int val; TreeNode left, right;
    TreeNode(int val){ this.val=val; left=null; right=null; }
}
```

```python
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val=val; self.left=left; self.right=right
```

```cpp
struct TreeNode {
    int val; TreeNode *left, *right;
    TreeNode(int v):val(v),left(nullptr),right(nullptr){}
};
```

---

## 🧠 Part 3 — DFS Traversals

| Traversal | Order | Output | Use |
|-----------|-------|--------|-----|
| Inorder | L→N→R | 4 2 5 1 6 3 7 | BST sorted order |
| Preorder | N→L→R | 1 2 4 5 3 6 7 | Clone/serialise |
| Postorder | L→R→N | 4 5 2 6 7 3 1 | Delete tree |

**Memory trick:** IN = node IN middle. PRE = node before. POST = node after.

### Inorder (L→N→R)
```java
// Recursive
void inorder(TreeNode n, List<Integer> res){
    if(n==null) return;
    inorder(n.left,res);    // L
    res.add(n.val);          // N
    inorder(n.right,res);   // R
}

// Iterative (explicit stack)
TreeNode curr=root;
while(curr!=null||!stack.isEmpty()){
    while(curr!=null){ stack.push(curr); curr=curr.left; }
    curr=stack.pop(); res.add(curr.val); curr=curr.right;
}
```

### Preorder (N→L→R) — Iterative
```java
stack.push(root);
while(!stack.isEmpty()){
    TreeNode n=stack.pop(); res.add(n.val);
    if(n.right!=null) stack.push(n.right);  // right first
    if(n.left!=null)  stack.push(n.left);   // left pops first
}
```

### Postorder (L→R→N)
```java
void postorder(TreeNode n, List<Integer> res){
    if(n==null) return;
    postorder(n.left,res); postorder(n.right,res);
    res.add(n.val);   // N last
}
```

> **BST inorder = sorted ascending output** — the most important BST property.

---

## 🧠 Part 4 — BFS / Level Order Traversal

Queue-based. Visit all nodes level by level, left to right.

```java
Queue<TreeNode> q=new LinkedList<>(); q.offer(root);
while(!q.isEmpty()){
    int size=q.size();            // snapshot: nodes at THIS level
    List<Integer> level=new ArrayList<>();
    for(int i=0;i<size;i++){
        TreeNode n=q.poll(); level.add(n.val);
        if(n.left!=null)  q.offer(n.left);
        if(n.right!=null) q.offer(n.right);
    }
    res.add(level);
}
```

```python
from collections import deque
res, q = [], deque([root])
while q:
    level=[]
    for _ in range(len(q)):  # snapshot size!
        n=q.popleft(); level.append(n.val)
        if n.left:  q.append(n.left)
        if n.right: q.append(n.right)
    res.append(level)
```

> **Snapshot `size=q.size()` before the loop** — without this, nodes from the next level corrupt the current level's list.

---

## 💻 Practice Problems — 5 Problems

---

### Q1. Binary Tree Inorder Traversal — [LC #94](https://leetcode.com/problems/binary-tree-inorder-traversal/) `Easy`

```python
def inorderTraversal(self, root):
    res=[]; stack=[]; curr=root
    while curr or stack:
        while curr: stack.append(curr); curr=curr.left
        curr=stack.pop(); res.append(curr.val); curr=curr.right
    return res
```

---

### Q2. Binary Tree Level Order Traversal — [LC #102](https://leetcode.com/problems/binary-tree-level-order-traversal/) `Medium`

```java
Queue<TreeNode> q=new LinkedList<>(); q.offer(root);
while(!q.isEmpty()){
    int sz=q.size(); List<Integer> lvl=new ArrayList<>();
    for(int i=0;i<sz;i++){
        TreeNode n=q.poll(); lvl.add(n.val);
        if(n.left!=null) q.offer(n.left);
        if(n.right!=null) q.offer(n.right);
    }
    res.add(lvl);
}
```

---

### Q3. Maximum Depth of Binary Tree — [LC #104](https://leetcode.com/problems/maximum-depth-of-binary-tree/) `Easy`

```java
public int maxDepth(TreeNode root){
    if(root==null) return 0;
    return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
}
```
```python
def maxDepth(self, root):
    if not root: return 0
    return 1+max(self.maxDepth(root.left), self.maxDepth(root.right))
```

---

### Q4. Invert Binary Tree — [LC #226](https://leetcode.com/problems/invert-binary-tree/) `Easy`

```java
public TreeNode invertTree(TreeNode root){
    if(root==null) return null;
    TreeNode tmp=root.left; root.left=root.right; root.right=tmp;
    invertTree(root.left); invertTree(root.right);
    return root;
}
```
```python
def invertTree(self, root):
    if not root: return None
    root.left, root.right = root.right, root.left
    self.invertTree(root.left); self.invertTree(root.right)
    return root
```

---

### Q5. Symmetric Tree — [LC #101](https://leetcode.com/problems/symmetric-tree/) `Easy`

```java
boolean mirror(TreeNode l, TreeNode r){
    if(l==null&&r==null) return true;
    if(l==null||r==null) return false;
    return l.val==r.val
        && mirror(l.left,  r.right)   // outer pair
        && mirror(l.right, r.left);   // inner pair
}
```
```python
def mirror(l, r):
    if not l and not r: return True
    if not l or not r:  return False
    return l.val==r.val and mirror(l.left,r.right) and mirror(l.right,r.left)
return mirror(root.left, root.right)
```

> Mirror uses **cross pairs**: outer (l.left vs r.right) and inner (l.right vs r.left).

---

## 📊 Quick Reference

| Traversal | Order | Output | Data Structure | Key Use |
|-----------|-------|--------|---------------|---------|
| Inorder | L→N→R | 4 2 5 1 6 3 7 | Stack | BST sorted |
| Preorder | N→L→R | 1 2 4 5 3 6 7 | Stack | Clone tree |
| Postorder | L→R→N | 4 5 2 6 7 3 1 | Stack | Delete tree |
| Level Order | level by level | [1][2,3][4,5,6,7] | Queue | BFS/width |

---

## ✅ Checklist Before You Sleep

- [ ] Tree terminology: root, leaf, height, depth, level, balanced
- [ ] All 3 DFS traversals — recursive from memory
- [ ] Inorder iterative — explicit stack
- [ ] BST inorder = sorted output
- [ ] Level Order BFS — snapshot size before inner loop
- [ ] Max Depth: `1 + max(depth(left), depth(right))`
- [ ] Invert: swap, then recurse both sides
- [ ] Symmetric: outer pair + inner pair mirror check

---

## 💬 Community

Binary trees are the foundation of everything that comes next — BST, heaps, tries, segment trees. Nail the traversals today. Which one clicked fastest for you?

**Solved all 5? Drop a 🔥 in the community.**

---

*Next up → Day 36: Binary Trees Interview Questions (BFS — Level Order variations, Right Side View, Zigzag)*
