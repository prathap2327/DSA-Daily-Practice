# 🌳 Day 41 — Tree Problems

> **DSA Partner Challenge** | Day 41 of 100
> **Topic:** Binary Tree Questions (LeetCode)
> **Problems:** 4 Easy | Pattern: Recursive DFS

---

## 📋 Problem List

| # | Problem | Difficulty | LeetCode |
|---|---------|-----------|---------|
| Q1 | Binary Tree Inorder Traversal | Easy | #94 |
| Q2 | Same Tree | Easy | #100 |
| Q3 | Symmetric Tree | Easy | #101 |
| Q4 | Maximum Depth of Binary Tree | Easy | #104 |

---

## Q1 — Binary Tree Inorder Traversal
🔗 https://leetcode.com/problems/binary-tree-inorder-traversal/

### Problem
Given the root of a binary tree, return the **inorder traversal** of its node values (Left → Root → Right).

### Approach
- **Recursive:** call left subtree → push root → call right subtree
- **Iterative:** use a stack; keep going left, pop and record, then go right

### Solution (C++)

```cpp
// Recursive
class Solution {
public:
    void solve(TreeNode* root, vector<int>& ans) {
        if (!root) return;
        solve(root->left, ans);
        ans.push_back(root->val);
        solve(root->right, ans);
    }
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> ans;
        solve(root, ans);
        return ans;
    }
};

// Iterative (Stack)
vector<int> inorderTraversal(TreeNode* root) {
    vector<int> ans;
    stack<TreeNode*> st;
    TreeNode* curr = root;
    while (curr || !st.empty()) {
        while (curr) { st.push(curr); curr = curr->left; }
        curr = st.top(); st.pop();
        ans.push_back(curr->val);
        curr = curr->right;
    }
    return ans;
}
```

### Complexity
| | Value | Note |
|--|-------|------|
| Time | O(n) | Every node visited once |
| Space | O(n) | Stack / recursion depth |

### Key Takeaways
- Iterative avoids stack overflow on skewed trees
- Inorder on BST → sorted output
- Both approaches identical in complexity

---

## Q2 — Same Tree
🔗 https://leetcode.com/problems/same-tree/

### Problem
Given roots of two binary trees `p` and `q`, return `true` if they are **structurally identical** with the **same node values**.

### Approach
Simultaneously traverse both trees and compare at each step. Three base cases handle all null scenarios cleanly.

### Solution (C++)

```cpp
class Solution {
public:
    bool isSameTree(TreeNode* p, TreeNode* q) {
        if (!p && !q) return true;   // both null → same
        if (!p || !q) return false;  // one null → different
        if (p->val != q->val) return false; // values differ
        return isSameTree(p->left,  q->left)   // check left subtrees
            && isSameTree(p->right, q->right); // check right subtrees
    }
};
```

### Complexity
| | Value | Note |
|--|-------|------|
| Time | O(n) | n = min nodes in both trees |
| Space | O(h) | h = height of tree |

### Key Takeaways
- 3 base cases elegantly cover all possibilities
- Short-circuits early on first mismatch
- Works on any binary tree (not just BST)

---

## Q3 — Symmetric Tree
🔗 https://leetcode.com/problems/symmetric-tree/

### Problem
Given the root of a binary tree, check if it is a **mirror of itself** (symmetric around its center).

### Key Insight ⭐
The cross-comparison is everything:
- Compare `left.left` with `right.right` (outer pair)
- Compare `left.right` with `right.left` (inner pair)

### Solution (C++)

```cpp
class Solution {
public:
    bool isMirror(TreeNode* left, TreeNode* right) {
        if (!left && !right) return true;
        if (!left || !right) return false;
        if (left->val != right->val) return false;
        // KEY: outer pair + inner pair
        return isMirror(left->left,  right->right)
            && isMirror(left->right, right->left);
    }
    bool isSymmetric(TreeNode* root) {
        if (!root) return true;
        return isMirror(root->left, root->right);
    }
};
```

### Complexity
| | Value | Note |
|--|-------|------|
| Time | O(n) | Every node visited once |
| Space | O(h) | Recursive call stack |

### Key Takeaways
- Structurally identical to Same Tree — only recursion args differ!
- `isMirror(L, R)` vs `isSameTree(p, q)` — spot the difference in args
- Can be solved iteratively with a queue (BFS)

---

## Q4 — Maximum Depth of Binary Tree
🔗 https://leetcode.com/problems/maximum-depth-of-binary-tree/

### Problem
Return the **maximum depth** of a binary tree — the number of nodes along the longest root-to-leaf path.

### Approach
Classic postorder DFS: get depth of left and right subtrees, return `max(left, right) + 1`. Also solvable via BFS — count levels.

### Solution (C++)

```cpp
// DFS (Postorder) — Most Elegant
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (!root) return 0;
        int leftDepth  = maxDepth(root->left);
        int rightDepth = maxDepth(root->right);
        return max(leftDepth, rightDepth) + 1;
    }
};

// BFS (Level Order) — Count Levels
int maxDepth(TreeNode* root) {
    if (!root) return 0;
    queue<TreeNode*> q;
    q.push(root);
    int depth = 0;
    while (!q.empty()) {
        int sz = q.size();
        depth++;
        for (int i = 0; i < sz; i++) {
            TreeNode* node = q.front(); q.pop();
            if (node->left)  q.push(node->left);
            if (node->right) q.push(node->right);
        }
    }
    return depth;
}
```

### Complexity
| | DFS | BFS |
|--|-----|-----|
| Time | O(n) | O(n) |
| Space | O(h) | O(w) — max width |

### Key Takeaways
- One of the most elegant recursive solutions — just 3 lines of logic!
- DFS: process children before parent (postorder)
- BFS: explicitly counts levels — intuitive to visualize
- For a balanced tree: h = O(log n); for skewed: h = O(n)

---

## 📊 Day 41 Summary

| Problem | Core Pattern | Time | Space |
|---------|-------------|------|-------|
| Inorder Traversal | DFS Recursive / Iterative Stack | O(n) | O(n) |
| Same Tree | Simultaneous DFS | O(n) | O(h) |
| Symmetric Tree | DFS Cross-Compare (Mirror) | O(n) | O(h) |
| Max Depth | Postorder DFS / Level BFS | O(n) | O(h) |

---

## 🧠 Patterns & Observations

- **All 4 use Recursive DFS** as their foundation
- **Universal base case:** `if (!root) return [0 / null / true]`
- **Same Tree ≈ Symmetric Tree** — the only difference is which nodes you compare in the recursive call
- **Max Depth = postorder:** compute both children's results before using them at the current node
- **Iterative alternatives** always exist: Stack for DFS, Queue for BFS

---

## 🔗 LeetCode Links
- [94. Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)
- [100. Same Tree](https://leetcode.com/problems/same-tree/)
- [101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)
- [104. Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)

---

*Day 41 • DSA Partner Challenge • Tree Problems*
*#DSAChallenge #100DaysOfCode #LeetCode #BinaryTree #DFS*
