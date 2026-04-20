# Day 38 — Binary Trees Interview Questions: DFS (Q10–Q24)

> **DSA Partner Challenge** | Week 6

---

## 📌 Topic of the Day

**Binary Trees FAANG Interview Questions — DFS problems (second ~2.5 hrs of the video).**

---

## 🎥 Resource

[Binary Trees Interview Questions — FAANG](https://youtu.be/9D-vP-jcc-Y?si=2Fv5ggNq4zAMNOgr) — Kunal Kushwaha

---

## 🧠 DFS Core Patterns

**Pattern A — Return upward (compute about subtree):**
```java
int dfs(TreeNode n){ if(n==null) return BASE; int L=dfs(n.left),R=dfs(n.right); return COMBINE(L,R,n.val); }
```

**Pattern B — Pass downward + global answer:**
```java
int ans=0;
void dfs(TreeNode n,int valueSoFar){ valueSoFar+=n.val; if(isLeaf(n)) ans=max(ans,valueSoFar); dfs(n.left,valueSoFar); dfs(n.right,valueSoFar); }
```

---

## 💻 15 DFS Problems from the Video

---

### Q10. Diameter of Binary Tree — [LC #543](https://leetcode.com/problems/diameter-of-binary-tree/) `Easy`

```java
int maxDiam=0;
int height(TreeNode n){
    if(n==null) return 0;
    int L=height(n.left), R=height(n.right);
    maxDiam=Math.max(maxDiam,L+R);  // diameter through this node
    return 1+Math.max(L,R);          // height returned upward
}
```

---

### Q11. Invert Binary Tree — [LC #226](https://leetcode.com/problems/invert-binary-tree/) `Easy`

```java
TreeNode tmp=root.left; root.left=root.right; root.right=tmp;
invertTree(root.left); invertTree(root.right);
```

---

### Q12. Maximum Depth of Binary Tree — [LC #104](https://leetcode.com/problems/maximum-depth-of-binary-tree/) `Easy`

```java
if(root==null) return 0;
return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
```

---

### Q13. Convert Sorted Array to BST — [LC #108](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/) `Easy`

```java
int mid=(lo+hi)/2;
TreeNode n=new TreeNode(a[mid]);
n.left=build(a,lo,mid-1); n.right=build(a,mid+1,hi);
```

---

### Q14. Flatten Binary Tree to Linked List — [LC #114](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/) `Medium`

Morris O(1) space: find rightmost of left subtree → connect to right → move left to right → clear left.

```java
while(curr!=null){
    if(curr.left!=null){
        TreeNode rm=curr.left;
        while(rm.right!=null) rm=rm.right;
        rm.right=curr.right;
        curr.right=curr.left; curr.left=null;
    }
    curr=curr.right;
}
```

---

### Q15. Validate Binary Search Tree — [LC #98](https://leetcode.com/problems/validate-binary-search-tree/) `Medium`

Pass bounds. Use `Long` to avoid overflow edge cases.

```java
boolean validate(TreeNode n,long min,long max){
    if(n==null) return true;
    if(n.val<=min||n.val>=max) return false;
    return validate(n.left,min,n.val) && validate(n.right,n.val,max);
}
// call: validate(root, Long.MIN_VALUE, Long.MAX_VALUE)
```

---

### Q16. Lowest Common Ancestor of a Binary Tree — [LC #236](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) `Medium`

```java
if(root==null||root==p||root==q) return root;
TreeNode L=LCA(root.left,p,q), R=LCA(root.right,p,q);
if(L!=null&&R!=null) return root;  // p and q in different subtrees
return L!=null?L:R;
```

---

### Q17. Kth Smallest Element in a BST — [LC #230](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) `Medium`

Inorder gives sorted order. Count nodes; return when `count==k`.

```java
while(curr!=null||!st.isEmpty()){
    while(curr!=null){st.push(curr);curr=curr.left;}
    curr=st.pop(); count++;
    if(count==k) return curr.val;
    curr=curr.right;
}
```

---

### Q18. Construct Binary Tree from Preorder and Inorder — [LC #105](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) `Hard`

preorder[0] = root. Find index in inorder. Left of index = left subtree. Recurse.

```java
int rootVal=pre[ps]; TreeNode root=new TreeNode(rootVal);
int mid=inMap.get(rootVal), leftSize=mid-is;
root.left =build(pre,ps+1,ps+leftSize,in,is,mid-1);
root.right=build(pre,ps+leftSize+1,pe,in,mid+1,ie);
```

---

### Q19. Serialize and Deserialize Binary Tree — [LC #297](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) `Hard`

Preorder DFS. Use "N" for null.

```java
// Serialize
if(root==null) return "N";
return root.val+","+serialize(root.left)+","+serialize(root.right);

// Deserialize
Queue<String> q=new LinkedList<>(Arrays.asList(data.split(",")));
// pop from queue in preorder DFS
String val=q.poll(); if(val.equals("N")) return null;
TreeNode node=new TreeNode(Integer.parseInt(val));
node.left=dfs(q); node.right=dfs(q);
```

---

### Q20. Path Sum — [LC #112](https://leetcode.com/problems/path-sum/) `Easy`

```java
if(root.left==null&&root.right==null) return root.val==target;
return hasPathSum(root.left,target-root.val)||hasPathSum(root.right,target-root.val);
```

---

### Q21. Sum Root to Leaf Numbers — [LC #129](https://leetcode.com/problems/sum-root-to-leaf-numbers/) `Medium`

```java
int dfs(TreeNode n,int cur){
    if(n==null) return 0;
    cur=cur*10+n.val;
    if(n.left==null&&n.right==null) return cur;
    return dfs(n.left,cur)+dfs(n.right,cur);
}
```

---

### Q22. Binary Tree Maximum Path Sum — [LC #124](https://leetcode.com/problems/binary-tree-maximum-path-sum/) `Hard`

```java
int maxSum=Integer.MIN_VALUE;
int dfs(TreeNode n){
    if(n==null) return 0;
    int L=Math.max(dfs(n.left),0);   // discard negative branches
    int R=Math.max(dfs(n.right),0);
    maxSum=Math.max(maxSum,n.val+L+R); // path through node
    return n.val+Math.max(L,R);         // return best single branch
}
```

> Three decisions: take max(L,0), update global with L+R+node, return only one direction.

---

### Q23. Path Sum II — [LC #113](https://leetcode.com/problems/path-sum-ii/) `Medium`

DFS backtracking. Add node to path, recurse, remove after (backtrack). At leaf if remaining==0, add copy of path.

```java
path.add(n.val);
if(leaf&&remain==n.val) res.add(new ArrayList<>(path));
dfs(n.left,remain-n.val,path); dfs(n.right,remain-n.val,path);
path.remove(path.size()-1); // backtrack
```

---

### Q24. Path Sum III — [LC #437](https://leetcode.com/problems/path-sum-iii/) `Medium`

Prefix sum + hashmap. At each node: count of `(currSum - target)` in map = paths ending here.

```java
curr+=n.val;
count+=prefix.getOrDefault(curr-target,0);
prefix.merge(curr,1,Integer::sum);
// recurse left and right
prefix.merge(curr,-1,Integer::sum); // backtrack
```

```python
curr+=n.val
self.ans+=prefix[curr-target]
prefix[curr]+=1
dfs(n.left,curr); dfs(n.right,curr)
prefix[curr]-=1  # backtrack
```

---

## 📊 DFS Pattern Summary

| Problem | Pattern | Key |
|---------|---------|-----|
| Diameter | Return upward | L+R for ans, 1+max(L,R) returned |
| Max Path Sum | Return upward | max(L,0)+max(R,0)+node for ans |
| Max Depth | Return upward | 1+max(L,R) |
| Flatten LL | Morris | rightmost of left → node.right |
| Validate BST | Pass bounds | min < val < max, Long bounds |
| LCA | Return upward | both non-null → current is LCA |
| Kth Smallest | Inorder DFS | count nodes, stop at k |
| Serialize | Preorder DFS | "N" for null, comma-separated |
| Path Sum | Pass remainder | at leaf, check remain==0 |
| Sum Root to Leaf | Pass number | cur=cur*10+val at leaf return cur |
| Path Sum II | Backtrack | path.add → recurse → path.remove |
| Path Sum III | Prefix sum | map + backtrack |

---

## ✅ Checklist Before You Sleep

- [ ] Diameter: L+R updates ans, 1+max(L,R) returned
- [ ] LCA: both non-null = current node is LCA
- [ ] Validate BST: pass Long bounds, not Integer
- [ ] Serialize: preorder + "N" for null
- [ ] Max Path Sum: discard negatives with max(L,0)
- [ ] Path Sum III: prefix sum hashmap + backtrack
- [ ] Solved all 15 DFS problems

---

*Next up → Day 39: Heaps & Priority Queues*
