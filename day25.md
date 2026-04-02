# Day 25 — Hard Backtracking: Sudoku · Letter Tiles · All Paths

> **DSA Partner Challenge** | Week 4

---

## 📌 Topic of the Day

**Hard Backtracking — constraint propagation, counting distinct sequences, DFS on graphs.**

---

## 🎥 Resources

| Language | Link |
|----------|------|
| Java | [youtu.be/zg5v2rlV1tM](https://youtu.be/zg5v2rlV1tM?si=zRawWrHlq11Qg7-8) |
| C++ #1 | [youtu.be/9kl-VbTTwYo](https://youtu.be/9kl-VbTTwYo?si=7ntFZavC5dL1Bdi8) |
| C++ #2 | [youtu.be/cNWKkosDzGE](https://youtu.be/cNWKkosDzGE?si=ug9ZZa94OaZoh_ly) |
| C++ #3 | [youtu.be/M5D3KUKH3gE](https://youtu.be/M5D3KUKH3gE?si=_Xbk2hyc9VZm1j-W) |

---

## 🧠 The Constraint Backtracking Pattern

```java
boolean solve(state) {
    if (isComplete(state)) return true;
    for (each valid candidate) {
        if (isValid(state, candidate)) {
            place(state, candidate);        // PLACE
            if (solve(state)) return true;  // RECURSE → stop on first solution
            remove(state, candidate);       // BACKTRACK
        }
    }
    return false;
}
```

---

## 💻 Practice Problems — 3 Problems

---

### Q1. Sudoku Solver — [LC #37](https://leetcode.com/problems/sudoku-solver/) `Hard`

Fill the 9×9 board so every row, column, and 3×3 box has 1-9 exactly once.

```java
boolean solve(char[][] board) {
    for (int r=0; r<9; r++) for (int c=0; c<9; c++) {
        if (board[r][c]=='.') {
            for (char ch='1'; ch<='9'; ch++) {
                if (isValid(board, r, c, ch)) {
                    board[r][c] = ch;                   // PLACE
                    if (solve(board)) return true;       // stop when solved
                    board[r][c] = '.';                  // BACKTRACK
                }
            }
            return false;   // no digit worked → backtrack
        }
    }
    return true;   // all cells filled!
}

boolean isValid(char[][] b, int r, int c, char ch) {
    for (int i=0; i<9; i++) {
        if (b[r][i]==ch || b[i][c]==ch) return false;          // row + col
        if (b[3*(r/3)+i/3][3*(c/3)+i%3]==ch) return false;    // box
    }
    return true;
}
```

```python
def solveSudoku(self, board):
    def is_valid(r, c, ch):
        for i in range(9):
            if board[r][i]==ch or board[i][c]==ch: return False
            if board[3*(r//3)+i//3][3*(c//3)+i%3]==ch: return False
        return True
    def solve():
        for r in range(9):
            for c in range(9):
                if board[r][c]=='.':
                    for ch in '123456789':
                        if is_valid(r, c, ch):
                            board[r][c]=ch
                            if solve(): return True
                            board[r][c]='.'    # backtrack
                    return False
        return True
    solve()
```

**3×3 Box Formula:**
```
boxRow = 3*(row/3) + i/3
boxCol = 3*(col/3) + i%3
```
Maps `i = 0..8` to all 9 cells in the box. **Memorise this.**

---

### Q2. Letter Tile Possibilities — [LC #1079](https://leetcode.com/problems/letter-tile-possibilities/) `Medium`

Count distinct NON-EMPTY sequences from any subset of tiles.

```java
int count(int[] freq) {
    int res = 0;
    for (int i=0; i<26; i++) {
        if (freq[i] > 0) {
            res++;              // this letter forms a new sequence
            freq[i]--;
            res += count(freq); // count all extensions of this sequence
            freq[i]++;          // backtrack
        }
    }
    return res;
}
// Build freq[] from tiles, call count(freq)
```

```python
def numTilePossibilities(self, tiles):
    freq = [0]*26
    for c in tiles: freq[ord(c)-ord('A')]+=1
    def count():
        res=0
        for i in range(26):
            if freq[i]>0:
                res+=1
                freq[i]-=1; res+=count(); freq[i]+=1
        return res
    return count()
```

> Using frequency array automatically handles duplicate letters — picking 'A' once works regardless of which physical tile it is.

---

### Q3. All Paths From Source to Target — [LC #797](https://leetcode.com/problems/all-paths-from-source-to-target/) `Medium`

Find ALL paths from node 0 to node n-1 in a DAG.

```java
void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> res) {
    if (node == graph.length-1) { res.add(new ArrayList<>(path)); return; }
    for (int next : graph[node]) {
        path.add(next);            // CHOOSE
        dfs(graph, next, path, res);
        path.remove(path.size()-1); // UNCHOOSE
    }
}
// Call: path.add(0); dfs(graph, 0, path, result)
```

```python
def allPathsSourceTarget(self, graph):
    result=[]
    def dfs(node, path):
        if node==len(graph)-1: result.append(path[:]); return
        for nx in graph[node]:
            path.append(nx); dfs(nx, path); path.pop()
    dfs(0, [0])
    return result
```

> **No visited[] needed** — DAG has no cycles. Every path naturally terminates.

---

## 📊 Quick Reference

| Problem | Goal | Stop when | Key trick |
|---------|------|-----------|-----------|
| Sudoku Solver | Fill grid | First valid solution | Box index: `3*(r/3)+i/3` |
| Letter Tiles | Count distinct seqs | No stop (count all) | Freq array = no duplicates |
| All Paths (DAG) | Find all paths | Reached target | No visited[] for DAG |

---

## ✅ Checklist Before You Sleep

- [ ] I implemented Sudoku Solver with the 3×3 box formula memorised
- [ ] I know why Sudoku returns `true` immediately when solved (not `continue` exploring)
- [ ] I implemented Letter Tiles with frequency array — avoiding duplicates naturally
- [ ] I understand why each `result++` in Letter Tiles = one valid non-empty sequence
- [ ] I implemented All Paths using DFS + backtracking on the graph
- [ ] I know why no visited[] is needed for a DAG
- [ ] I solved all 3 problems

---

## 💬 Community

Sudoku Solver is one of the most iconic backtracking problems. Drop your approach in the community — did you try it before checking the solution?

**Solved all 3? Drop a 🔥 in the community.**

---

*Next up → Day 26: Hashing — HashMap, HashSet, frequency maps*
