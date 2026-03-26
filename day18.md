# Day 18 — Maths for DSA: Bitwise Operators & Number Systems

> **DSA Partner Challenge** | Week 3

---

## 📌 Topic of the Day

**Bitwise Operators + Number Systems — the bit magic behind FAANG interviews.**

---

## 🎥 Resource

[Maths for DSA — Bitwise Operators & Number Systems](https://youtu.be/fzip9Aml6og?si=LpObvvpvdTZX0Jbk)

---

## 🧠 Part 1 — Number Systems

| System | Base | Digits | Example |
|--------|------|--------|---------|
| Binary | 2 | 0,1 | `1010` = 10 |
| Octal | 8 | 0–7 | `12` = 10 |
| Decimal | 10 | 0–9 | `10` = 10 |
| Hexadecimal | 16 | 0–9, A–F | `A` = 10 |

**Decimal → Binary:** Divide by 2, collect remainders bottom-up.
```
13 ÷ 2 = 6 r 1
 6 ÷ 2 = 3 r 0
 3 ÷ 2 = 1 r 1
 1 ÷ 2 = 0 r 1  → read up: 1101₂ = 13₁₀
```

**Binary → Decimal:** Multiply each bit by 2^position, sum.
```
1101₂ = 1×8 + 1×4 + 0×2 + 1×1 = 13₁₀
```

**Powers of 2 to memorise:** 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024

---

## 🧠 Part 2 — The 6 Bitwise Operators

```
a = 5  = 0101
b = 3  = 0011

a & b  = 0001 = 1   AND  — 1 only where BOTH are 1
a | b  = 0111 = 7   OR   — 1 where EITHER is 1
a ^ b  = 0110 = 6   XOR  — 1 where bits DIFFER
~a     = ...1010 = -6  NOT — flip all bits (2's complement)
a << 1 = 1010 = 10  Left shift  — multiply by 2
a >> 1 = 0010 = 2   Right shift — divide by 2
```

---

## 🧠 Part 3 — XOR Properties (Memorise All 5)

| Property | Example | Why it matters |
|----------|---------|----------------|
| `a ^ a = 0` | `5 ^ 5 = 0` | Same values cancel |
| `a ^ 0 = a` | `5 ^ 0 = 5` | XOR with 0 = identity |
| `a ^ b ^ a = b` | `5^3^5 = 3` | XOR twice cancels |
| Commutative | `a^b = b^a` | Order doesn't matter |
| Associative | `(a^b)^c = a^(b^c)` | Grouping doesn't matter |

**Find Single Number trick:**
```java
int result = 0;
for (int x : nums) result ^= x;  // pairs cancel, unique survives
```

---

## 🧠 Part 4 — Essential Bit Tricks

```java
// Check if ith bit is set
(n & (1 << i)) != 0

// Set ith bit
n = n | (1 << i)

// Clear ith bit
n = n & ~(1 << i)

// Toggle ith bit
n = n ^ (1 << i)

// Check if power of 2
(n > 0) && (n & (n-1)) == 0

// Count set bits (Brian Kernighan)
while (n != 0) { n = n & (n-1); count++; }

// Multiply by 2^k
n << k

// Divide by 2^k
n >> k
```

---

## 💻 Practice Problems — 9 LeetCode Problems

---

**Q1. Decode XORed Array** — [LC #1720](https://leetcode.com/problems/decode-xored-array/) `Easy`
> `arr[i+1] = encoded[i] ^ arr[i]` — XOR is self-inverse
```python
arr = [first]
for x in encoded: arr.append(x ^ arr[-1])
return arr
```

---

**Q2. Sum of All Subset XOR Totals** — [LC #1863](https://leetcode.com/problems/sum-of-all-subset-xor-totals/) `Easy`
> Each bit contributes to exactly 2^(n-1) subsets. Answer = OR of all elements × 2^(n-1)
```python
from functools import reduce; from operator import or_
return reduce(or_, nums) << (len(nums)-1)
```

---

**Q3. Longest Nice Substring** — [LC #1763](https://leetcode.com/problems/longest-nice-substring/) `Easy`
> Divide and conquer: split on any char missing its opposite case. Return longer nice half.
```python
def longestNiceSubstring(self, s):
    if len(s)<2: return ''
    chars=set(s)
    for i,c in enumerate(s):
        if c.upper() not in chars or c.lower() not in chars:
            l=self.longestNiceSubstring(s[:i])
            r=self.longestNiceSubstring(s[i+1:])
            return l if len(l)>=len(r) else r
    return s
```

---

**Q4. Subsets** — [LC #78](https://leetcode.com/problems/subsets/) `Medium`
> Bitmask: mask from 0 to 2^n-1. Bit i set = include nums[i].
```python
n = len(nums)
return [[nums[i] for i in range(n) if mask>>i&1] for mask in range(1<<n)]
```

---

**Q5. Subsets II** — [LC #90](https://leetcode.com/problems/subsets-ii/) `Medium`
> Sort first. Skip `nums[i] == nums[i-1]` at same recursion depth to avoid duplicates.
```python
nums.sort(); res=[]
def bt(start, cur):
    res.append(cur[:])
    for i in range(start, len(nums)):
        if i>start and nums[i]==nums[i-1]: continue
        cur.append(nums[i]); bt(i+1,cur); cur.pop()
bt(0,[]); return res
```

---

**Q6. Single Number II** — [LC #137](https://leetcode.com/problems/single-number-ii/) `Medium`
> Every element appears 3 times except one. For each bit: `sum % 3` gives the bit of the answer.
```java
int result=0;
for (int i=0;i<32;i++) {
    int sum=0;
    for (int n:nums) sum+=(n>>i)&1;
    if (sum%3!=0) result|=(1<<i);
}
return result;
```

---

**Q7. Divide Two Integers** — [LC #29](https://leetcode.com/problems/divide-two-integers/) `Medium`
> Bit shift division: find largest power-of-2 × divisor ≤ dividend. Subtract, accumulate result.
```python
sign = (-1 if (dividend<0)^(divisor<0) else 1)
dvd, dvs = abs(dividend), abs(divisor)
ans = 0
while dvd>=dvs:
    temp, mul = dvs, 1
    while dvd>=(temp<<1): temp<<=1; mul<<=1
    dvd-=temp; ans+=mul
return sign*ans
```

---

**Q8. Gray Code** — [LC #89](https://leetcode.com/problems/gray-code/) `Medium`
> Gray code formula: `i ^ (i >> 1)`. Adjacent codes differ by exactly 1 bit.
```python
return [i ^ (i>>1) for i in range(1<<n)]
```

---

**Q9. Repeated DNA Sequences** — [LC #187](https://leetcode.com/problems/repeated-dna-sequences/) `Medium`
> Sliding window of 10 chars. HashSet to detect duplicates.
```python
seen, dup = set(), set()
for i in range(len(s)-9):
    sub=s[i:i+10]
    if sub in seen: dup.add(sub)
    else: seen.add(sub)
return list(dup)
```

---

## ✅ Checklist Before You Sleep

- [ ] I can convert decimal ↔ binary
- [ ] I know all 6 bitwise operators and their truth tables
- [ ] I know the 5 XOR properties (especially `a^a=0` and `a^b^a=b`)
- [ ] I know: check/set/clear/toggle a bit, isPowerOf2
- [ ] I understand bitmask enumeration for subsets (mask 0 to 2^n-1)
- [ ] I know the Gray code formula: `i ^ (i >> 1)`
- [ ] I solved all 9 LeetCode problems

---

## 💬 Community

The bit tricks are the ones that save you in interviews. Which one clicked for you today? Drop it in the community.

**Solved all 9? Drop a 🔥 in the community.**

---

*Next up → Day 19: Maths for DSA Part 2 — GCD, LCM, Primes, Modular Arithmetic*
