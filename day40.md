# 🌳 Day 40 — Tree Traversals

> **DSA Partner Challenge** | Day 40 of 100  
> **Topic:** Tree Traversals (Inorder, Preorder, Postorder, Level Order)  
> **Practice:** All Tree Traversals Implementation in C++

---

## 📌 What is Tree Traversal?

Tree traversal is the process of **visiting every node** in a tree exactly once in a specific order. Since trees are non-linear data structures, there are multiple valid ways to traverse them.

---

## 🌲 Example Tree

```
        1
       / \
      2   3
     / \ / \
    4  5 6  7
```

---

## 🔵 DFS Traversals (Recursive)

### 1. Inorder — `Left → Root → Right`

```cpp
void inorder(Node* root) {
    if (root == NULL) return;
    inorder(root->left);
    cout << root->data << " ";
    inorder(root->right);
}
```

**Output:** `4 2 5 1 6 3 7`  
**Use Case:** Gives **sorted output** for BST. Expression tree evaluation.

---

### 2. Preorder — `Root → Left → Right`

```cpp
void preorder(Node* root) {
    if (root == NULL) return;
    cout << root->data << " ";
    preorder(root->left);
    preorder(root->right);
}
```

**Output:** `1 2 4 5 3 6 7`  
**Use Case:** Tree **serialization** and reconstruction. Making copies of trees.

---

### 3. Postorder — `Left → Right → Root`

```cpp
void postorder(Node* root) {
    if (root == NULL) return;
    postorder(root->left);
    postorder(root->right);
    cout << root->data << " ";
}
```

**Output:** `4 5 2 6 7 3 1`  
**Use Case:** **Deleting** a tree. Evaluating postfix expression trees.

---

## 🔴 BFS Traversal (Iterative)

### 4. Level Order — `Level by Level using Queue`

```cpp
void levelOrder(Node* root) {
    if (!root) return;
    queue<Node*> q;
    q.push(root);
    while (!q.empty()) {
        Node* curr = q.front();
        q.pop();
        cout << curr->data << " ";
        if (curr->left)  q.push(curr->left);
        if (curr->right) q.push(curr->right);
    }
}
```

**Output:** `1 2 3 4 5 6 7`  
**Use Case:** Shortest path in unweighted trees. Finding **width/height** of tree.

---

## 📊 Complexity Analysis

| Traversal      | Time | Space (Best)     | Space (Worst) |
|---------------|------|-----------------|--------------|
| Inorder       | O(n) | O(log n) balanced | O(n) skewed |
| Preorder      | O(n) | O(log n) balanced | O(n) skewed |
| Postorder     | O(n) | O(log n) balanced | O(n) skewed |
| Level Order   | O(n) | O(1) root only    | O(n) last level |

> **Space complexity** for DFS = O(h) where h = height of tree (call stack depth)  
> **Space complexity** for BFS = O(w) where w = maximum width of tree (queue size)

---

## 💡 Key Takeaways

- ✅ **Inorder on BST** → Always gives sorted (ascending) output
- ✅ **Preorder** → Best for serialization and tree reconstruction
- ✅ **Postorder** → Best for deletion and bottom-up computation
- ✅ **Level Order** → BFS-based, uses a queue, visits level by level
- ✅ All DFS traversals: **recursive** approach uses implicit call stack
- ✅ Level Order: **iterative** approach with explicit queue

---

## 🏋️ Practice Questions

1. Print all four traversals for a given binary tree
2. Reconstruct a tree from inorder + preorder sequences
3. Check if two trees are mirror images using traversal
4. Find height of binary tree using postorder
5. Print level order in **reverse** (stack + queue trick)
6. **Zigzag** level order traversal (alternate direction per level)
7. Find the **leftmost** and **rightmost** node at each level

---

## 🧠 Quick Memory Trick

| Traversal | Root Position |
|-----------|-------------|
| **Pre**order | **Pre**fix → Root FIRST |
| **In**order | **In**fix → Root MIDDLE |
| **Post**order | **Post**fix → Root LAST |

---

## 📁 Full Practice Code (C++)

```cpp
#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    Node(int val) : data(val), left(nullptr), right(nullptr) {}
};

void inorder(Node* root) {
    if (!root) return;
    inorder(root->left);
    cout << root->data << " ";
    inorder(root->right);
}

void preorder(Node* root) {
    if (!root) return;
    cout << root->data << " ";
    preorder(root->left);
    preorder(root->right);
}

void postorder(Node* root) {
    if (!root) return;
    postorder(root->left);
    postorder(root->right);
    cout << root->data << " ";
}

void levelOrder(Node* root) {
    if (!root) return;
    queue<Node*> q;
    q.push(root);
    while (!q.empty()) {
        Node* curr = q.front(); q.pop();
        cout << curr->data << " ";
        if (curr->left)  q.push(curr->left);
        if (curr->right) q.push(curr->right);
    }
}

int main() {
    //        1
    //       / \
    //      2   3
    //     / \ / \
    //    4  5 6  7
    Node* root = new Node(1);
    root->left = new Node(2);
    root->right = new Node(3);
    root->left->left = new Node(4);
    root->left->right = new Node(5);
    root->right->left = new Node(6);
    root->right->right = new Node(7);

    cout << "Inorder:     "; inorder(root);     cout << "\n";
    cout << "Preorder:    "; preorder(root);    cout << "\n";
    cout << "Postorder:   "; postorder(root);   cout << "\n";
    cout << "Level Order: "; levelOrder(root);  cout << "\n";

    return 0;
}
```

**Expected Output:**
```
Inorder:     4 2 5 1 6 3 7
Preorder:    1 2 4 5 3 6 7
Postorder:   4 5 2 6 7 3 1
Level Order: 1 2 3 4 5 6 7
```

---

*Day 40 • DSA Partner Challenge • Tree Traversals*  
*#DSAChallenge #100DaysOfCode #TreeTraversal #DataStructures*
