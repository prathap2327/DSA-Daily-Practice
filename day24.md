# Day 24 — Divide & Conquer Recursion

> **DSA Partner Challenge** | Week 4

---

## 📌 Topic of the Day

**Divide & Conquer Recursion — split at operators, recurse on halves, combine results.**

---

## 🎥 Resources

| # | Link |
|---|------|
| 1 | [youtu.be/gDGw0cvFXPQ](https://youtu.be/gDGw0cvFXPQ?si=ijtkHlQ0p5KNIWfg) |
| 2 | [youtu.be/9ByWqPzfXDU](https://youtu.be/9ByWqPzfXDU?si=LGVbNCPqj4JZqB7q) |

---

## 🧠 The Divide & Conquer Template

```
solve(problem):
    if base case: return simple answer
    for each split point:
        left  = solve(left_part)   ← DIVIDE + CONQUER
        right = solve(right_part)
        combine all (left, right) pairs  ← COMBINE
    return all results
```

**Key:** try ALL possible split points → generates all possible structures.

---

## 💻 Practice Problems — 4 Problems

---

### Q1. Different Ways to Add Parentheses — [LC #241](https://leetcode.com/problems/different-ways-to-add-parentheses/) `Medium`

Return all possible results by parenthesising the expression differently.

```java
// Java with memoisation
Map<String,List<Integer>> memo = new HashMap<>();
List<Integer> diffWaysToCompute(String expr) {
    if (memo.containsKey(expr)) return memo.get(expr);
    List<Integer> res = new ArrayList<>();
    for (int i=0; i<expr.length(); i++) {
        char c = expr.charAt(i);
        if (c=='+' || c=='-' || c=='*') {
            List<Integer> L = diffWaysToCompute(expr.substring(0,i));
            List<Integer> R = diffWaysToCompute(expr.substring(i+1));
            for (int l:L) for (int r:R)
                res.add(c=='+'?l+r : c=='-'?l-r : l*r);
        }
    }
    if (res.isEmpty()) res.add(Integer.parseInt(expr));
    memo.put(expr, res);
    return res;
}
```

```python
from functools import lru_cache
def diffWaysToCompute(self, expression):
    @lru_cache(maxsize=None)
    def solve(expr):
        res=[]
        for i,c in enumerate(expr):
            if c in '+-*':
                for l in solve(expr[:i]):
                    for r in solve(expr[i+1:]):
                        res.append(l+r if c=='+' else l-r if c=='-' else l*r)
        return res if res else [int(expr)]
    return solve(expression)
```

> Split at each operator → get all left results × all right results. Memoisation avoids recomputing same subexpressions.

---

### Q2. Letter Combinations of a Phone Number — [LC #17](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) `Medium`

```
2→abc, 3→def, 4→ghi, 5→jkl, 6→mno, 7→pqrs, 8→tuv, 9→wxyz
```

```java
void backtrack(String digits, int idx, StringBuilder cur, List<String> res) {
    if (idx==digits.length()) { res.add(cur.toString()); return; }
    for (char c : map[digits.charAt(idx)-'0'].toCharArray()) {
        cur.append(c);
        backtrack(digits, idx+1, cur, res);
        cur.deleteCharAt(cur.length()-1);   // backtrack (StringBuilder is mutable)
    }
}
```

```python
def letterCombinations(self, digits):
    if not digits: return []
    phone={'2':'abc','3':'def','4':'ghi','5':'jkl','6':'mno','7':'pqrs','8':'tuv','9':'wxyz'}
    result=[]
    def bt(idx, current):
        if idx==len(digits): result.append(current); return
        for c in phone[digits[idx]]:
            bt(idx+1, current+c)   # string is immutable, no explicit backtrack needed
    bt(0,'')
    return result
```

---

### Q3. Predict the Winner — [LC #486](https://leetcode.com/problems/predict-the-winner/) `Medium`

Two players alternately pick from ends. Return true if Player 1 can win.

**Key insight:** `dp(lo, hi)` = max score advantage current player achieves over opponent.

```
dp(lo, hi) = max(
    nums[lo] - dp(lo+1, hi),   # pick left, opponent plays on rest
    nums[hi] - dp(lo, hi-1)    # pick right, opponent plays on rest
)
```

Player 1 wins if `dp(0, n-1) >= 0`.

```java
// Java — recursive + memo
int solve(int[] nums, int lo, int hi, Integer[][] memo) {
    if (lo==hi) return nums[lo];
    if (memo[lo][hi]!=null) return memo[lo][hi];
    return memo[lo][hi] = Math.max(nums[lo]-solve(nums,lo+1,hi,memo),
                                   nums[hi]-solve(nums,lo,hi-1,memo));
}
```

```python
from functools import lru_cache
def predictTheWinner(self, nums):
    @lru_cache(maxsize=None)
    def dp(lo, hi):
        if lo==hi: return nums[lo]
        return max(nums[lo]-dp(lo+1,hi), nums[hi]-dp(lo,hi-1))
    return dp(0, len(nums)-1) >= 0
```

---

### Q4. Gray Code — [LC #89](https://leetcode.com/problems/gray-code/) / GFG Google `Medium`

Adjacent numbers differ by exactly 1 bit.

**Formula (simplest):**
```python
return [i ^ (i>>1) for i in range(1<<n)]
```

**Recursive (reflect + prefix):**
```python
def grayCode(self, n):
    if n==1: return [0,1]
    prev = self.grayCode(n-1)
    msb = 1 << (n-1)
    return prev + [msb|x for x in reversed(prev)]
```

**Trace:**
```
G(1) = [0, 1]
G(2) = [0,1] + [3,2]   = [0,1,3,2]
G(3) = [0,1,3,2] + [6,7,5,4] = [0,1,3,2,6,7,5,4]
```

> Every adjacent pair in the sequence differs by exactly 1 bit ✓

---

## ✅ Checklist Before You Sleep

- [ ] I understand divide-and-conquer: split → recurse → combine
- [ ] I implemented Different Ways to Add Parentheses with memoisation
- [ ] I implemented Letter Combinations using backtracking
- [ ] I understand Predict the Winner: `max(pick - opponent_advantage)`
- [ ] I know Gray Code: formula `i^(i>>1)` AND recursive reflect+prefix
- [ ] I know why Python strings don't need explicit backtracking (immutable)
- [ ] I solved all 4 problems

---

## 💬 Community

Predict the Winner is tricky until the "score difference" framing clicks. Share your trace in the community if it helped.

**Solved all 4? Drop a 🔥 in the community.**

---

*Next up → Day 25: Hashing — HashMap, HashSet, frequency maps*
