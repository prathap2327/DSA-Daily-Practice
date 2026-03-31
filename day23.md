# Day 23 — Recursion: Subsets & Subsequences

> **DSA Partner Challenge** | Week 4

---

## 📌 Topic of the Day

**Subsets & Subsequences — include or exclude. Every element. Every time.**

---

## 🎥 Resource

[Subsets & Subsequences Tutorial](https://youtu.be/gdifkIwCJyg?si=n_2fk898vJrK-HDo)

---

## 🧠 Part 1 — Subsets vs Subsequences

| | Subset | Subsequence |
|--|--------|-------------|
| Order matters? | No | Yes |
| Count for n elements | 2^n | 2^n |
| [2,1] from [1,2,3] | = [1,2] (same subset) | NOT valid (order broken) |
| Recursion | Include/exclude | Include/exclude in original order |

> Both use the same recursion template. The difference is only in interpretation.

---

## 🧠 Part 2 — The Include/Exclude Template

```java
// Generate ALL subsets — record at EVERY call
void subsets(int[] arr, int idx, List<Integer> cur, List<List<Integer>> res) {
    res.add(new ArrayList<>(cur));     // record EVERY state
    if (idx == arr.length) return;
    cur.add(arr[idx]);                 // INCLUDE
    subsets(arr, idx+1, cur, res);
    cur.remove(cur.size()-1);         // BACKTRACK
    subsets(arr, idx+1, cur, res);    // EXCLUDE
}
```

```python
def subsets(arr, idx=0, current=[], result=[]):
    result.append(current[:])         # record every state
    if idx == len(arr): return
    current.append(arr[idx])
    subsets(arr, idx+1, current, result)
    current.pop()                     # backtrack
    subsets(arr, idx+1, current, result)
```

**Count subsequences summing to target:**
```java
int count(int[] arr, int idx, int sum, int target) {
    if (sum > target) return 0;       // prune
    if (idx == arr.length) return sum==target ? 1 : 0;
    return count(arr, idx+1, sum+arr[idx], target)   // include
         + count(arr, idx+1, sum, target);            // exclude
}
```

**When to record:**
- Print ALL subsets → record at **every call** (before recursing)
- Subsets matching condition → record **only at base case** when condition met
- Count subsets → return `1` at base when condition met, `0` otherwise

---

## 💻 Practice Problems — 3 Problems

---

### Q1. Divisible Subset — CodeChef `Medium`

Find a non-empty subset where the sum is divisible by K.

**Brute force: generate all 2^n subsets, check each sum % K.**

```java
void solve(int idx, int currentSum, List<Integer> current) {
    if (!current.isEmpty() && currentSum % K == 0) {
        print(current); return;
    }
    if (idx == arr.length) return;
    current.add(arr[idx]);
    solve(idx+1, currentSum+arr[idx], current);
    current.remove(current.size()-1);
    solve(idx+1, currentSum, current);
}
```

```python
def find_divisible(arr, K, idx=0, cur=[], s=0):
    if cur and s%K==0: return cur[:]
    if idx==len(arr): return None
    cur.append(arr[idx])
    res=find_divisible(arr, K, idx+1, cur, s+arr[idx])
    if res: return res
    cur.pop()
    return find_divisible(arr, K, idx+1, cur, s)
```

> 💡 **Pigeonhole Insight (O(n)):** Take prefix sums S[1]...S[n] mod K.
> If any S[i] % K == 0 → arr[0..i] is the answer.
> If any two have same remainder → the slice between them is divisible. Always works when n ≥ K.

---

### Q2. Perfect Squares — [LC #279](https://leetcode.com/problems/perfect-squares/) `Medium`

Minimum number of perfect squares that sum to n.

```java
// DP O(n√n)
int[] dp = new int[n+1];
Arrays.fill(dp, Integer.MAX_VALUE);
dp[0] = 0;
for (int i=1; i<=n; i++)
    for (int j=1; j*j<=i; j++)
        dp[i] = Math.min(dp[i], dp[i-j*j]+1);
return dp[n];
```

```python
# DP
dp = [float('inf')] * (n+1); dp[0]=0
for i in range(1, n+1):
    j=1
    while j*j<=i: dp[i]=min(dp[i], dp[i-j*j]+1); j+=1
return dp[n]

# Recursive + memoisation
from functools import lru_cache
squares=[i*i for i in range(1,int(n**0.5)+1)]
@lru_cache(maxsize=None)
def dp(r): return 0 if r==0 else 1+min(dp(r-s) for s in squares if s<=r)
return dp(n)
```

> By Lagrange's Four-Square Theorem, answer is always 1, 2, 3, or 4.

---

### Q3. Decode String — [LC #394](https://leetcode.com/problems/decode-string/) `Medium`

`"3[a2[c]]"` → `"accaccacc"`

**Stack approach:**
```python
def decodeString(self, s):
    stack=[]; current=''; k=0
    for c in s:
        if c.isdigit(): k=k*10+int(c)
        elif c=='[': stack.append((current,k)); current,k='',0
        elif c==']': prev,times=stack.pop(); current=prev+current*times
        else: current+=c
    return current
```

**Recursive approach (natural for nested brackets):**
```java
// idx is a global/array pointer — each '[' = new recursive call, ']' = return
String decode(String s, int[] idx) {
    StringBuilder res = new StringBuilder();
    while (idx[0]<s.length() && s.charAt(idx[0])!=']') {
        if (!Character.isDigit(s.charAt(idx[0]))) {
            res.append(s.charAt(idx[0]++));
        } else {
            int k=0;
            while (Character.isDigit(s.charAt(idx[0]))) k=k*10+(s.charAt(idx[0]++)-'0');
            idx[0]++;  // skip '['
            String inner=decode(s, idx);
            idx[0]++;  // skip ']'
            res.append(inner.repeat(k));
        }
    }
    return res.toString();
}
```

> Nested `[...]` naturally maps to recursion — each `[` opens a new call, `]` returns.

---

## 📊 When to Use What

| Problem Type | Approach | Record when |
|-------------|---------|------------|
| Print all subsets | Include/exclude | Every recursive call |
| Subsets matching condition | Include/exclude + check | Only at base case |
| Count subsets | Include/exclude + count | Return 1 at base |
| Nested structure (decode) | Recursion or stack | At each `]` |
| Min/max over subsets | Include/exclude + optimize | Track best so far |

---

## ✅ Checklist Before You Sleep

- [ ] I know the difference between subsets and subsequences
- [ ] I can write the include/exclude template from memory
- [ ] I know when to record at every call vs only at base case
- [ ] I understand the Pigeonhole insight for Divisible Subset
- [ ] I solved Perfect Squares with both DP and recursion+memoisation
- [ ] I solved Decode String — stack and recursive approaches
- [ ] I understand why nested brackets → natural recursion

---

## 💬 Community

The Decode String stack trick is one of those that clicks all at once. Share when it clicked for you.

**Solved all 3? Drop a 🔥 in the community.**

---

*Next up → Day 24: Hashing — HashMap, HashSet, frequency maps*
