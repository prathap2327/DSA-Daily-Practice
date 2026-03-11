# Day 5 — Functions & Methods

> **DSA Partner Challenge** | Week 1: Language Basics + Maths for DSA

---

## 📌 Topic of the Day

##notes : https://drive.google.com/file/d/1mBk6GyKOxVWvhnH_aF5sHUXRIDBPxFZv/view?usp=sharing
**Functions & Methods — write once, use anywhere**

Every DSA algorithm you'll write will live inside a function. Today we learn how to define them, call them, pass data in, and get data out — across all 3 languages.

---

## 🎥 Resource

| Language | Resource |
|----------|----------|
| ☕ Java | [Functions & Methods Tutorial](https://youtu.be/vvanI8NRlSI?si=_GNtOHS7RXkmFO95) |
| 🐍 Python | Same concepts — CampusX 100 Days of Python (Functions section) |
| ⚙️ C++ | Same video — Love Babbar / Striver playlist |

---

## 🧠 What to Learn Today

### Why Functions?
- Write code once → reuse it anywhere
- Keeps programs organised and readable
- Easier to test, debug, and fix
- In DSA: every algorithm = a function

---

### Java — Methods

```java
// Syntax
public static returnType methodName(parameters) {
    // body
    return value;  // omit if void
}
```

**void method** — does something, returns nothing:
```java
public static void greet(String name) {
    System.out.println("Hello, " + name);
}
greet("Tripti");   // Hello, Tripti
```

**Return type method:**
```java
public static int add(int a, int b) {
    return a + b;
}
int result = add(5, 3);   // 8
```

**Method Overloading** — same name, different parameters:
```java
public static int add(int a, int b)       { return a + b; }
public static double add(double a, double b) { return a + b; }
public static int add(int a, int b, int c)   { return a+b+c; }
```

**Pass by Value** — Java copies primitives:
```java
void doubleIt(int x) { x = x * 2; }   // only changes copy
int num = 5;
doubleIt(num);
System.out.println(num);   // still 5!
```

---

### Python — Functions

```python
def function_name(parameters):
    # body
    return value   # optional
```

**Basic example:**
```python
def add(a, b):
    return a + b

result = add(5, 3)   # 8
```

**Return multiple values** (Python exclusive):
```python
def min_max(a, b, c):
    return min(a,b,c), max(a,b,c)

low, high = min_max(3, 1, 7)   # low=1, high=7
```

**Default parameters:**
```python
def greet(name, msg="Hello"):
    print(f"{msg}, {name}!")

greet("Tripti")          # Hello, Tripti!
greet("Tripti", "Hi")    # Hi, Tripti!
```

**Variable arguments (*args):**
```python
def total(*numbers):
    return sum(numbers)

total(1, 2, 3, 4, 5)   # 15
```

---

### C++ — Functions

```cpp
returnType functionName(parameters) {
    // body
    return value;
}
```

**Pass by Reference** (C++ exclusive with `&`):
```cpp
// Pass by value — original unchanged
void doubleIt(int x)  { x = x * 2; }

// Pass by reference — original IS changed
void doubleIt(int& x) { x = x * 2; }

int num = 5;
doubleIt(num);
cout << num;   // 10 if &, 5 without
```

**Default parameters:**
```cpp
void greet(string name, string msg = "Hello") {
    cout << msg << ", " << name;
}
greet("Tripti");           // Hello, Tripti
greet("Tripti", "Hi");     // Hi, Tripti
```

**Forward Declaration** (if function is defined after `main`):
```cpp
int add(int a, int b);   // declare first

int main() {
    cout << add(2, 3);
}

int add(int a, int b) { return a + b; }   // define later
```

---

### Quick Comparison

| Feature | Java | Python | C++ |
|---------|------|--------|-----|
| Define | `public static int f()` | `def f():` | `int f()` |
| Return nothing | `void` | `None` (implicit) | `void` |
| Default params | No (use overloading) | Yes | Yes |
| Multiple returns | No | Yes | No |
| Overloading | Yes | No | Yes |
| Pass by reference | No (objects by ref) | No | Yes (`&`) |
| Must be in class | Yes | No | No |

---

## 💻 Practice Questions

Solve in your language. Define proper methods/functions — don't write everything in main().

**1.** Find if a number is palindrome or not
> A palindrome reads the same forwards and backwards → 121, 1331

**2.** HCF and LCM of two numbers
> HCF: largest number that divides both
> LCM: smallest number divisible by both → LCM = (a × b) / HCF

**3.** Vowel or Consonant
> Given a character, check if it's a vowel (a,e,i,o,u) or consonant

**4.** Perfect Number
> A number is perfect if sum of its proper divisors = itself → 6 (1+2+3=6)

**5.** Check Leap Year
> Divisible by 4 AND (not divisible by 100 OR divisible by 400)

**6.** Sum of Digits of a Number
> 1234 → 1+2+3+4 = 10

**7.** Kunal's Even Days (August)
> Kunal can go out only on even days. Count how many even days are in August (31 days).

**8.** Sum of negative numbers, sum of positive even numbers, and sum of positive odd numbers from a list

**9.** Define two methods to print the maximum and minimum among three numbers entered by the user

**10.** Define a method to find whether a given number is even or odd

**11.** Voting Eligibility
> A person can vote if age >= 18. Define a method that returns true/false.

**12.** Write a method that takes two numbers as input and returns their sum

**13.** Sum of N numbers entered by the user — list terminates when user enters 0

---

## ✅ Checklist Before You Sleep

- [ ] I can define a function/method in all 3 languages
- [ ] I understand void vs return-type functions
- [ ] I know what parameters and arguments are
- [ ] I understand pass by value vs pass by reference
- [ ] I know what method overloading is (Java / C++)
- [ ] I understand local vs global scope
- [ ] Solved at least 8 of the 13 practice questions

---

## 💬 Community

Drop your solutions or any doubts in the community.

**Solved all 13? Drop a 🔥 in the community.**

---

*Next up → Day 6: Maths for DSA — Part 1 (Prime Numbers, GCD, LCM, Modulo)*
