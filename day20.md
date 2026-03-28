# Day 20 — Advanced Recursion

> **DSA Partner Challenge** | Week 3

---

## 📌 Topic of the Day

**Advanced Recursion — String recursion · Backtracking · Power set · Permutations**

---

## 🎥 Resources

| Video | Link |
|-------|------|
| Advanced Recursion | [youtu.be/JxILxTwHukM](https://youtu.be/JxILxTwHukM?si=3BTGgNUMOCeE7u7H) |
| String Recursion | [youtu.be/kHi1DUhp9kM](https://youtu.be/kHi1DUhp9kM?si=XjDRaBByRUOwD4so) |

---

## 🧠 4 Advanced Recursion Patterns

### Pattern A — String Shrink (process one char at a time)
```java
void solve(String s) {
    if (s.isEmpty()) return;             // base case
    char first = s.charAt(0);           // process first
    // do something with first
    solve(s.substring(1));              // recurse on rest
}
```

### Pattern B — Include / Exclude (generate all subsets)
```java
void generate(String s, int idx, String current) {
    if (idx == s.length()) { print(current); return; }
    generate(s, idx+1, current + s.charAt(idx)); // INCLUDE
    generate(s, idx+1, current);                  // EXCLUDE
}
```

### Pattern C — State Tracking through parameters
```java
// Pass balance, count, visited — as parameters
boolean check(String s, int idx, int balance) {
    if (balance < 0) return false;
    if (idx == s.length()) return balance == 0;
    // update state, recurse
}
```

### Pattern D — Backtracking (add → recurse → remove)
```java
void backtrack(String s, int start, List<String> cur) {
    if (done) { record(cur); return; }
    for (choice : choices) {
        cur.add(choice);              // CHOOSE
        backtrack(s, next, cur);      // RECURSE
        cur.remove(last);             // UNDO (backtrack)
    }
}
```

| Pattern | When | Template |
|---------|------|----------|
| String shrink | Process char by char | `do(s[0]) + f(s[1:])` |
| Include/exclude | Generate all subsets | `f(include) + f(exclude)` |
| State tracking | Balance, count, path | `f(s, idx, state+1)` |
| Backtracking | Generate + filter | `add → recurse → remove` |

---

## 💻 Practice Problems — 5 Problems

---

### Q1. Number of Steps to Reduce a Number to Zero — [LC #1342](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/) `Easy`

Even → divide by 2. Odd → subtract 1.

```java
// Recursive
int numberOfSteps(int num) {
    if (num==0) return 0;
    if ((num&1)==0) return 1 + numberOfSteps(num>>1);
    return 1 + numberOfSteps(num-1);
}
```
```python
def numberOfSteps(self, num):
    if num==0: return 0
    return 1 + self.numberOfSteps(num>>1 if num%2==0 else num-1)
```

> Bit tricks: `(num & 1) == 0` → even. `num >> 1` → divide by 2.

---

### Q2. Check Balanced Parentheses using Recursion (no stack) — GFG `Medium`

Track a `balance` counter: +1 for `(`, -1 for `)`. Balance < 0 → unbalanced. End with balance 0 → balanced.

```java
boolean isBalanced(String s, int idx, int balance) {
    if (balance < 0) return false;
    if (idx == s.length()) return balance == 0;
    if (s.charAt(idx)=='(') return isBalanced(s, idx+1, balance+1);
    if (s.charAt(idx)==')') return isBalanced(s, idx+1, balance-1);
    return isBalanced(s, idx+1, balance);   // other chars
}
// Call: isBalanced(s, 0, 0)
```

```python
def is_balanced(s, idx=0, balance=0):
    if balance<0: return False
    if idx==len(s): return balance==0
    if s[idx]=='(': return is_balanced(s, idx+1, balance+1)
    if s[idx]==')': return is_balanced(s, idx+1, balance-1)
    return is_balanced(s, idx+1, balance)
```

> The `balance` parameter replaces the stack. Call stack acts as memory.

---

### Q3. Remove Consecutive Duplicate Characters — GFG `Easy`

`'aabba'` → `'aba'`

```java
String removeDuplicates(String s) {
    if (s.length()<=1) return s;
    if (s.charAt(0)==s.charAt(1)) return removeDuplicates(s.substring(1));
    return s.charAt(0) + removeDuplicates(s.substring(1));
}
```

```python
def remove_duplicates(s):
    if len(s)<=1: return s
    if s[0]==s[1]: return remove_duplicates(s[1:])
    return s[0] + remove_duplicates(s[1:])
```

**Trace `'aabba'`:**
```
'aabba': a==a → remove('abba')
'abba':  a!=b → 'a' + remove('bba')
'bba':   b==b → remove('ba')
'ba':    b!=a → 'b' + remove('a')
'a':     base → 'a'
→ Result: 'aba' ✓
```

---

### Q4. Print All Palindromic Partitions — GFG `Hard`

Generate all ways to partition a string where every part is a palindrome.

```java
void palindromicPartition(String s, int start, List<String> cur, List<List<String>> res) {
    if (start==s.length()) { res.add(new ArrayList<>(cur)); return; }
    for (int end=start+1; end<=s.length(); end++) {
        String prefix=s.substring(start,end);
        if (isPalindrome(prefix)) {
            cur.add(prefix);
            palindromicPartition(s, end, cur, res);
            cur.remove(cur.size()-1);   // BACKTRACK
        }
    }
}
```

```python
def palindromic_partitions(s, start=0, cur=[], res=[]):
    if start==len(s): res.append(cur[:]); return
    for end in range(start+1, len(s)+1):
        prefix=s[start:end]
        if prefix==prefix[::-1]:
            cur.append(prefix)
            palindromic_partitions(s, end, cur, res)
            cur.pop()   # backtrack
    return res
```

---

### Q5. Power Set / All Permutations in Lexicographic Order — GFG `Hard`

**Power Set (include/exclude):**
```java
void powerSet(String s, int idx, String current) {
    if (idx==s.length()) { print(current); return; }
    powerSet(s, idx+1, current+s.charAt(idx));  // include
    powerSet(s, idx+1, current);                 // exclude
}
// Call: powerSet(s, 0, "")
```

**All Permutations (backtracking with swap):**
```java
void permutations(char[] arr, int idx) {
    if (idx==arr.length) { print(new String(arr)); return; }
    for (int i=idx; i<arr.length; i++) {
        swap(arr, idx, i);
        permutations(arr, idx+1);
        swap(arr, idx, i);   // BACKTRACK: restore
    }
}
// Sort arr first for lexicographic order
```

```python
def power_set(s, idx=0, current='', res=[]):
    if idx==len(s): res.append(current); return res
    power_set(s, idx+1, current+s[idx], res)   # include
    power_set(s, idx+1, current, res)            # exclude
    return res

# Permutations with built-in:
from itertools import permutations
sorted([''.join(p) for p in permutations(sorted(s))])
```

> Power set of n chars = 2^n subsets. Permutations = n!

---

## ✅ Checklist Before You Sleep

- [ ] I know the 4 advanced recursion patterns
- [ ] I can generate power sets using include/exclude
- [ ] I understand backtracking: add → recurse → **REMOVE** (undo choice)
- [ ] I can track balance/state through recursion parameters (no extra data structures)
- [ ] I solved all 5 problems
- [ ] I can generate permutations using swap-backtrack

---

## 💬 Community

Backtracking is the hardest pattern today. If it clicks — explain it to someone else. Teaching it cements it.

**Solved all 5? Drop a 🔥 in the community.**

---

*Next up → Day 21: Hashing — HashMap and HashSet*
