# Day 6 — More Practice on Functions

> **DSA Partner Challenge** | Week 1: Language Basics + Maths for DSA

---

## 📌 Topic of the Day

**Practice Day — Functions**

##notes : https://drive.google.com/file/d/1xReOUrtqExV73TYS46sKs8UnJU2VJ5_B/view?usp=sharing

No new syntax today. Pure problem solving. Every question must be solved as a proper function — don't dump everything in `main()`.

> Write once. Call anywhere. That's the whole point.

---

## 🎥 Resource

Same as Day 5 — [Functions & Methods Tutorial](https://youtu.be/vvanI8NRlSI?si=_GNtOHS7RXkmFO95)

---

## 🧠 Approach for Every Question

Before writing code, answer these three things:
1. **What goes IN?** (parameters / inputs)
2. **What comes OUT?** (return type / output)
3. **What's the step-by-step logic?** (pseudocode first)

---

## 💻 Practice Questions

---

### Q1. Is a Number Prime?

Define a method that returns `true` if a number is prime, `false` otherwise.

**Key logic:**
- A prime has exactly 2 factors: 1 and itself
- 1 is NOT prime. 2 is prime (only even prime).
- Check divisors from 2 to **√n** — if any divide evenly, not prime

```java
// Java
public static boolean isPrime(int n) {
    if (n <= 1) return false;
    if (n == 2) return true;
    if (n % 2 == 0) return false;
    for (int i = 3; i <= Math.sqrt(n); i += 2) {
        if (n % i == 0) return false;
    }
    return true;
}
```

```python
# Python
import math
def is_prime(n):
    if n <= 1: return False
    if n == 2: return True
    if n % 2 == 0: return False
    for i in range(3, int(math.sqrt(n)) + 1, 2):
        if n % i == 0: return False
    return True
```

```cpp
// C++
bool isPrime(int n) {
    if (n <= 1) return false;
    if (n == 2) return true;
    if (n % 2 == 0) return false;
    for (int i = 3; i <= sqrt(n); i += 2)
        if (n % i == 0) return false;
    return true;
}
```

> 💡 Why √n? If n has a factor > √n, it must also have one < √n. So checking to √n is enough.

---

### Q2. Grade Calculator

Ask the user for marks (0–100). Define a method that returns the grade.

| Marks | Grade |
|-------|-------|
| 91–100 | AA |
| 81–90 | AB |
| 71–80 | BB |
| 61–70 | BC |
| 51–60 | CD |
| 41–50 | DD |
| ≤ 40 | Fail |

```java
// Java
public static String getGrade(int marks) {
    if      (marks >= 91) return "AA";
    else if (marks >= 81) return "AB";
    else if (marks >= 71) return "BB";
    else if (marks >= 61) return "BC";
    else if (marks >= 51) return "CD";
    else if (marks >= 41) return "DD";
    else                  return "Fail";
}
```

```python
# Python
def get_grade(marks):
    if   marks >= 91: return 'AA'
    elif marks >= 81: return 'AB'
    elif marks >= 71: return 'BB'
    elif marks >= 61: return 'BC'
    elif marks >= 51: return 'CD'
    elif marks >= 41: return 'DD'
    else:             return 'Fail'
```

---

### Q3. Factorial

Define a method named `Factorial` that returns n! for a given n.

```
4! = 1 × 2 × 3 × 4 = 24
0! = 1  (by definition)
1! = 1
```

```java
// Java — use long for big numbers
public static long factorial(int n) {
    if (n == 0 || n == 1) return 1;
    long result = 1;
    for (int i = 2; i <= n; i++) result *= i;
    return result;
}
```

```python
# Python
def factorial(n):
    if n == 0 or n == 1: return 1
    result = 1
    for i in range(2, n + 1):
        result *= i
    return result
```

```cpp
// C++
long long factorial(int n) {
    if (n == 0 || n == 1) return 1;
    long long result = 1;
    for (int i = 2; i <= n; i++) result *= i;
    return result;
}
```

---

### Q4. Palindrome Number

Write a function that takes a number and returns true if it's a palindrome.

**Mathematical approach — reverse the digits:**

```java
// Java
public static boolean isPalindrome(int n) {
    if (n < 0) return false;
    int original = n, reversed = 0;
    while (n > 0) {
        int digit = n % 10;
        reversed  = reversed * 10 + digit;
        n         = n / 10;
    }
    return original == reversed;
}
```

```python
# Python — string trick
def is_palindrome(n):
    if n < 0: return False
    return str(n) == str(n)[::-1]
```

> 💡 Trace n=121: digits → 1, 2, 1 → reversed = 121 → matches original ✓

---

### Q5. Refactor Previous Programs into Functions

Go back to your Day 1–3 programs. Wrap each one in a proper named function.

**Minimum 3 to refactor:**
- `isEven(int n)` — from Day 2
- `isLeapYear(int year)` — from Day 2
- `areaOfCircle(double r)` — from Day 3
- `simpleInterest(double p, double t, double r)` — from Day 2
- `fibonacci(int n)` — from Day 3

> Refactoring = improving structure without changing behaviour. Real skill, real codebase.

---

### Q6. Pythagorean Triplet

Write a function that returns true if three numbers form a Pythagorean triplet (a² + b² = c²).

```java
// Java
public static boolean isPythagorean(int a, int b, int c) {
    int[] nums = {a, b, c};
    java.util.Arrays.sort(nums);
    return nums[0]*nums[0] + nums[1]*nums[1] == nums[2]*nums[2];
}
```

```python
# Python
def is_pythagorean(a, b, c):
    nums = sorted([a, b, c])
    return nums[0]**2 + nums[1]**2 == nums[2]**2
```

```cpp
// C++
bool isPythagorean(int a, int b, int c) {
    int nums[] = {a, b, c};
    sort(nums, nums + 3);
    return nums[0]*nums[0] + nums[1]*nums[1] == nums[2]*nums[2];
}
```

> Sort first — you don't know which is the hypotenuse (c). Classic triplets: (3,4,5), (5,12,13), (8,15,17)

---

### Q7. All Primes Between Two Numbers

Write a function that prints/returns all primes between two given numbers.

```java
// Java — reuse isPrime() from Q1
public static void printPrimes(int start, int end) {
    for (int i = start; i <= end; i++)
        if (isPrime(i)) System.out.print(i + " ");
}
```

```python
# Python
def primes_between(start, end):
    return [n for n in range(start, end + 1) if is_prime(n)]
```

> This question is 3 lines because isPrime() already exists. That's the payoff of reusable functions.

---

### Q8. Sum of First N Natural Numbers

Write a function that returns the sum of first n natural numbers.

```java
// Java — formula O(1)
public static long sumNaturals(int n) {
    return (long) n * (n + 1) / 2;
}
```

```python
# Python
def sum_naturals(n):
    return n * (n + 1) // 2
```

> 🧠 Formula: n×(n+1)/2 — Gauss's formula. Appears constantly in DSA. Know it cold.

---

## ✅ Checklist Before You Sleep

- [ ] isPrime() — understand why √n is the limit
- [ ] gradeCalculator() — proper if-else chain, highest to lowest
- [ ] factorial() — handled 0! = 1 edge case, used `long`
- [ ] isPalindrome() — digit reversal logic understood
- [ ] Refactored at least 3 programs from Day 1–3 into functions
- [ ] isPythagorean() — sorted first, then checked
- [ ] primesInRange() — reused your own isPrime()
- [ ] sumNaturals() — know both loop AND formula approach

---

## 💬 Community

Drop your solutions or doubts in the community.

**Solved all 8? Drop a 🔥 in the community.**

---

*Next up → Day 7: Maths for DSA — Part 1*
