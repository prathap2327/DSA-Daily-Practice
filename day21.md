# Day 21 — Backtracking: Combination Sum · Word Search · Target Sum

> **DSA Partner Challenge** | Week 3

---

## 📌 Topic of the Day

**Backtracking — 3 classic FAANG problems. One pattern. Three applications.**

---

## 🎥 Resources

| Video | Link |
|-------|------|
| Backtracking Tutorial 1 | [youtu.be/sTdiMLom00U](https://youtu.be/sTdiMLom00U?si=FQQbU6JbmZ83qXRD) |
| Backtracking Tutorial 2 | [youtu.be/ymgnIIclCF0](https://youtu.be/ymgnIIclCF0?si=sHRoRR3RHQYkBGtX) |

---

## 🧠 The Backtracking Template

```
void backtrack(state, choices):
    if isComplete(state):
        record(state)
        return
    for choice in choices:
        if isValid(state, choice):
            makeChoice(state, choice)     ← CHOOSE
            backtrack(updatedState)       ← EXPLORE
            undoChoice(state, choice)     ← UNCHOOSE
```

**Three key conditions:**
1. **Goal:** current state is a complete valid solution → record it
2. **Pruning:** current state cannot lead to any solution → stop early
3. **Extension:** try each valid next choice, recurse, then undo

---

## 💻 Practice Problems — 3 LeetCode Problems

---

### Q1. Combination Sum — [LC #39](https://leetcode.com/problems/combination-sum/) `Medium`

Find all combinations of candidates that sum to target. Each candidate can be used unlimited times.

```java
// Java
void backtrack(int[] cands, int remaining, int start, List<Integer> cur, List<List<Integer>> res) {
    if (remaining == 0) { res.add(new ArrayList<>(cur)); return; }
    for (int i=start; i<cands.length; i++) {
        if (cands[i] > remaining) break;    // PRUNE (sorted array)
        cur.add(cands[i]);                  // CHOOSE
        backtrack(cands, remaining-cands[i], i, cur, res); // i: reuse allowed
        cur.remove(cur.size()-1);           // UNCHOOSE
    }
}
// Sort first, call backtrack(candidates, target, 0, [], result)
```

```python
def combinationSum(self, candidates, target):
    candidates.sort()
    result = []
    def backtrack(start, current, remaining):
        if remaining == 0: result.append(current[:]); return
        for i in range(start, len(candidates)):
            if candidates[i] > remaining: break     # prune
            current.append(candidates[i])
            backtrack(i, current, remaining-candidates[i])  # i: reuse
            current.pop()
    backtrack(0, [], target)
    return result
```

> 💡 Pass `i` (not `i+1`) to allow reuse of the same element. Pass `i+1` for Combination Sum II where each element can only be used once.

**Trace: candidates=[2,3,6,7], target=7**
```
pick 2 → remaining=5
  pick 2 → remaining=3
    pick 3 → remaining=0  ✓  [2,2,3]
pick 3 → remaining=4
  pick 3 → remaining=1
    pick 3 → remaining=-2  PRUNE
pick 7 → remaining=0  ✓  [7]
```

---

### Q2. Word Search — [LC #79](https://leetcode.com/problems/word-search/) `Medium`

Find if a word exists in a grid using horizontally/vertically connected letters.

```java
// Java
boolean dfs(char[][] board, String word, int r, int c, int idx) {
    if (idx == word.length()) return true;          // all chars matched
    if (r<0 || r>=board.length || c<0 || c>=board[0].length) return false;
    if (board[r][c] != word.charAt(idx)) return false;
    char tmp = board[r][c];
    board[r][c] = '#';    // MARK visited (in-place, O(1) space)
    boolean found = dfs(board,word,r+1,c,idx+1) || dfs(board,word,r-1,c,idx+1)
                 || dfs(board,word,r,c+1,idx+1) || dfs(board,word,r,c-1,idx+1);
    board[r][c] = tmp;    // RESTORE (backtrack)
    return found;
}
// Call dfs(board, word, i, j, 0) for each cell (i,j)
```

```python
def exist(self, board, word):
    m, n = len(board), len(board[0])
    def dfs(r, c, idx):
        if idx==len(word): return True
        if r<0 or r>=m or c<0 or c>=n or board[r][c]!=word[idx]: return False
        tmp=board[r][c]; board[r][c]='#'   # mark visited
        found=dfs(r+1,c,idx+1) or dfs(r-1,c,idx+1) or dfs(r,c+1,idx+1) or dfs(r,c-1,idx+1)
        board[r][c]=tmp                     # restore
        return found
    return any(dfs(i,j,0) for i in range(m) for j in range(n))
```

**4-directional movement template:**
```java
int[] dr = {0, 0, 1, -1};
int[] dc = {1, -1, 0, 0};
for (int d=0; d<4; d++) dfs(r+dr[d], c+dc[d], idx+1);
```

> In-place marking (`board[r][c] = '#'`) avoids a separate `visited[][]` array — O(1) extra space.

---

### Q3. Target Sum — [LC #494](https://leetcode.com/problems/target-sum/) `Medium`

Assign + or - to each number. Count assignments that make the expression equal target.

**Backtracking O(2^n):**
```java
int backtrack(int[] nums, int target, int idx, int currentSum) {
    if (idx == nums.length) return currentSum == target ? 1 : 0;
    return backtrack(nums, target, idx+1, currentSum+nums[idx])
         + backtrack(nums, target, idx+1, currentSum-nums[idx]);
}
```

```python
def findTargetSumWays(self, nums, target):
    def bt(idx, s):
        if idx==len(nums): return 1 if s==target else 0
        return bt(idx+1, s+nums[idx]) + bt(idx+1, s-nums[idx])
    return bt(0, 0)
```

**With Memoisation — O(n × sum):**
```python
from functools import lru_cache
def findTargetSumWays(self, nums, target):
    @lru_cache(maxsize=None)
    def dp(idx, remaining):
        if idx==len(nums): return 1 if remaining==0 else 0
        return dp(idx+1, remaining-nums[idx]) + dp(idx+1, remaining+nums[idx])
    return dp(0, target)
```

> Memoisation caches `(idx, remaining)` — each unique state computed once. Goes from exponential to polynomial.

---

## 📊 Backtracking Pattern Summary

| Problem | Pattern | Key State | Pruning |
|---------|---------|-----------|---------|
| Combination Sum | Include/repeat | remaining sum | `sum > target` → break |
| Word Search | DFS on grid | visited cells | OOB or wrong char |
| Target Sum | Include/exclude (+/-) | current sum | memoize states |
| Subsets | Include/exclude | current subset | none |
| Permutations | Swap & restore | current position | duplicates |

---

## ✅ Checklist Before You Sleep

- [ ] I know the 3-step backtracking pattern: choose → explore → unchoose
- [ ] Combination Sum: why sort? why `break` not `continue`? why pass `i` not `i+1`?
- [ ] Word Search: in-place marking with restore — no extra visited array
- [ ] I know the 4-directional movement pattern for grid DFS
- [ ] Target Sum: backtracking gives all paths, memoisation caches overlapping subproblems
- [ ] I solved all 3 problems

---

## 💬 Community

These three problems are interview staples. Which one took you the longest to understand? Drop it in the community.

**Solved all 3? Drop a 🔥 in the community.**

---

*Next up → Day 22: Hashing — HashMap, HashSet, frequency maps*
