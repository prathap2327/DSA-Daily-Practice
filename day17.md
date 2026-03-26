# Day 17 — Time & Space Complexity + Recursion Practice

> **DSA Partner Challenge** | Week 3

---

## 📌 Topic of the Day

**Time & Space Complexity — two questions asked in EVERY interview.**

How fast does it run? How much memory does it use?

---

## 🎥 Resource

[Time & Space Complexity Tutorial](https://youtu.be/mV3wrLBbuuE?si=V7dg_HbfxSO05j1R)

---

## 🧠 Part 1 — Big O Notation

Big O describes **worst-case growth** as input size `n` increases.

**Simplification rules:**
- Drop constants: `O(5n)` → `O(n)`
- Drop lower terms: `O(n² + n)` → `O(n²)`
- Only the dominant term matters

### The Big O Classes (Best → Worst)

| Notation | Name | n=1000 ops | Example |
|----------|------|-----------|---------|
| O(1) | Constant | 1 | Array index `arr[i]` |
| O(log n) | Logarithmic | ~10 | Binary search |
| O(n) | Linear | 1,000 | Single loop |
| O(n log n) | Linearithmic | ~10,000 | Merge sort |
| O(n²) | Quadratic | 1,000,000 | Nested loops |
| O(2ⁿ) | Exponential | 10^301 | Naive Fibonacci |
| O(n!) | Factorial | ∞ | Permutations |

```
O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(2ⁿ) < O(n!)
```

---

## 🧠 Part 2 — Calculating Time Complexity

```java
// Single loop → O(n)
for (int i=0; i<n; i++) { }

// Nested loops → O(n²)
for (int i=0; i<n; i++)
    for (int j=0; j<n; j++) { }

// Sequential blocks → add → O(n)
for (int i=0; i<n; i++) { }   // O(n)
for (int j=0; j<n; j++) { }   // O(n)  →  O(n)+O(n) = O(n)

// Halving each step → O(log n)
while (i > 1) i = i / 2;

// Recursion patterns:
// T(n) = T(n-1) + O(1)      →  O(n)       linear recursion
// T(n) = T(n/2) + O(1)      →  O(log n)   binary search
// T(n) = fib(n-1)+fib(n-2)  →  O(2ⁿ)     naive Fibonacci
// T(n) = 2T(n/2) + O(n)     →  O(n log n) merge sort
```

---

## 🧠 Part 3 — Space Complexity

Measures **extra memory** used (not counting input).

| Space | Example |
|-------|---------|
| O(1) | In-place sorting, two pointers |
| O(log n) | Recursive binary search (call stack) |
| O(n) | HashMap, linear recursion stack |
| O(n²) | 2D DP table |

> **Recursion Stack:** Each call frame uses memory. `f(n)→f(n-1)→...→f(0)` = n frames = O(n) space.

---

## 📊 Sorting Algorithm Complexity

| Algorithm | Best | Average | Worst | Space | Stable |
|-----------|------|---------|-------|-------|--------|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | ✅ |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | ❌ |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | ✅ |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | ✅ |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | ❌ |

---

## 💻 Recursion Practice — 10 Problems

---

**Q1. Fibonacci Number** — [LC #509](https://leetcode.com/problems/fibonacci-number/)
```java
// Recursive O(2ⁿ):
int fib(int n) { return n<=1 ? n : fib(n-1)+fib(n-2); }

// Iterative O(n), O(1) space:
int fib(int n) {
    if(n<=1) return n;
    int a=0,b=1;
    for(int i=2;i<=n;i++){int c=a+b;a=b;b=c;}
    return b;
}
```
> Naive recursion is O(2ⁿ) — fib(3) is computed multiple times. Fix: iteration or memoisation.

---

**Q2. Special Fibonacci** — CodeChef
> Same structure as Fibonacci with custom starting values `a` and `b`. Apply the same iterative pattern.

---

**Q3. Length of String using Recursion** — GFG
```java
int length(String s) {
    if (s.isEmpty()) return 0;
    return 1 + length(s.substring(1));
}
```
> Time: O(n) | Space: O(n)

---

**Q4. Geek-onacci Number** — GFG
> T(n) = T(n-1) + T(n-2) + T(n-3), T(1)=T(2)=T(3)=1
```java
int geekOnacci(int n) {
    if (n<=3) return 1;
    int a=1,b=1,c=1;
    for(int i=4;i<=n;i++){int d=a+b+c;a=b;b=c;c=d;}
    return c;
}
```

---

**Q5. Recursive Bubble Sort** — GFG
```java
void bubbleSortRec(int[] arr, int n) {
    if (n==1) return;
    for(int i=0;i<n-1;i++)
        if(arr[i]>arr[i+1]){int t=arr[i];arr[i]=arr[i+1];arr[i+1]=t;}
    bubbleSortRec(arr, n-1);
}
```
> Still O(n²) time. Space: O(n) stack — worse than iterative.

---

**Q6. Recursive Insertion Sort** — GFG
```java
void insertionSortRec(int[] arr, int n) {
    if (n<=1) return;
    insertionSortRec(arr, n-1);
    int key=arr[n-1], j=n-2;
    while(j>=0 && arr[j]>key){arr[j+1]=arr[j];j--;}
    arr[j+1]=key;
}
```

---

**Q7. Sum of Digits using Recursion** — GFG
```java
int sumDigits(int n) {
    if (n==0) return 0;
    return n%10 + sumDigits(n/10);
}
```
> Time: O(log n) — digits count = log₁₀(n)

---

**Q8. Product of Two Numbers using Recursion** — GFG
```java
int product(int a, int b) {
    if (b==0) return 0;
    return a + product(a, b-1);   // a added b times
}
```
> Time: O(b) — b recursive calls

---

**Q9. Check Prime using Recursion** — GFG
```java
boolean isPrime(int n, int div) {
    if (n<2) return false;
    if (div>(int)Math.sqrt(n)) return true;
    if (n%div==0) return false;
    return isPrime(n, div+1);
}
// Call: isPrime(n, 2)
```
> Time: O(√n) | Space: O(√n) stack

---

**Q10. Sum of Natural Numbers using Recursion** — GFG
```java
int sumNatural(int n) {
    if (n==0) return 0;
    return n + sumNatural(n-1);
}
// Better: return n*(n+1)/2;  → O(1)!
```
> Three approaches: loop O(n)/O(1), recursion O(n)/O(n), formula O(1)/O(1) ← BEST

---

## ✅ Checklist Before You Sleep

- [ ] I know the Big O order: O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(2ⁿ)
- [ ] I can calculate complexity for loops, nested loops, and recursion
- [ ] I know to drop constants and lower-order terms
- [ ] I understand recursion uses O(n) call stack space
- [ ] I know why naive Fibonacci is O(2ⁿ)
- [ ] I solved all 10 problems and can state the complexity of each
- [ ] I know the formula `n*(n+1)/2` for sum of naturals — O(1)

---

## 💬 Community

For each problem you solve today — write down the time AND space complexity next to your solution. Make it a habit now.

**Solved all 10? Drop a 🔥 in the community.**

---

*Next up → Day 18: String Medium problems + Recursion revision*
