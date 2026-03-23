# Day 14 — Sunday FunDay: Loop Revision + Pattern Problems

> **DSA Partner Challenge** | Week 2 wrap-up

---

## 📌 Topic of the Day

**Loop revision + 14 pattern problems. Check your logical thinking.**

Sunday is not a rest day. It's a logic day.

---

## 🎥 Resource

[Pattern Problems Tutorial](https://youtu.be/lsOOs5J8ycw?si=lAabPES6ZLGDHiRE)

---

## 🧠 Loop Revision — The Golden Rules

Before patterns, nail these fundamentals:

```
Outer loop = ROWS (how many lines)
Inner loop = COLUMNS (what to print per line)
```

- `System.out.print("*")` — no newline (Java)
- `System.out.println()` — newline after row (Java)
- `print("*", end="")` — no newline (Python)
- `print()` — newline after row (Python)

**Always trace by hand before coding.**

---

## 💻 14 Pattern Problems

---

### Pattern 1 — 5×5 Square of Stars
```
*****
*****
*****
*****
*****
```
```java
for (int i=1; i<=5; i++) {
    for (int j=1; j<=5; j++) System.out.print("*");
    System.out.println();
}
```
```python
for i in range(5): print('*' * 5)
```

---

### Pattern 2 — Right Triangle (increasing)
```
*
**
***
****
*****
```
```java
for (int i=1; i<=5; i++) {
    for (int j=1; j<=i; j++) System.out.print("*");
    System.out.println();
}
```
```python
for i in range(1, 6): print('*' * i)
```

---

### Pattern 3 — Inverted Triangle (decreasing)
```
*****
****
***
**
*
```
```java
for (int i=5; i>=1; i--) {
    for (int j=1; j<=i; j++) System.out.print("*");
    System.out.println();
}
```
```python
for i in range(5, 0, -1): print('*' * i)
```

---

### Pattern 4 — Number Triangle
```
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
```
```java
for (int i=1; i<=5; i++) {
    for (int j=1; j<=i; j++) System.out.print(j + " ");
    System.out.println();
}
```
```python
for i in range(1, 6):
    print(' '.join(str(j) for j in range(1, i+1)))
```

---

### Pattern 5 — Diamond / Rhombus (full, left-aligned)
```
*
**
***
****
*****
****
***
**
*
```
```java
for (int i=1; i<=5; i++) { /* increasing half */
    for (int j=1; j<=i; j++) System.out.print("*");
    System.out.println();
}
for (int i=4; i>=1; i--) { /* decreasing half */
    for (int j=1; j<=i; j++) System.out.print("*");
    System.out.println();
}
```
```python
for i in list(range(1, 6)) + list(range(4, 0, -1)):
    print('*' * i)
```

---

### Pattern 6 — Right-aligned Triangle (spaces + stars)
```
    *
   **
  ***
 ****
*****
```
```java
int n = 5;
for (int i=1; i<=n; i++) {
    for (int j=1; j<=n-i; j++) System.out.print(" ");
    for (int j=1; j<=i; j++) System.out.print("*");
    System.out.println();
}
```
```python
n = 5
for i in range(1, n+1): print(' '*(n-i) + '*'*i)
```

---

### Pattern 7 — Right-aligned Inverted Triangle
```
*****
 ****
  ***
   **
    *
```
```java
int n = 5;
for (int i=n; i>=1; i--) {
    for (int j=1; j<=n-i; j++) System.out.print(" ");
    for (int j=1; j<=i; j++) System.out.print("*");
    System.out.println();
}
```
```python
n = 5
for i in range(n, 0, -1): print(' '*(n-i) + '*'*i)
```

---

### Pattern 8 — Pyramid (centred)
```
    *
   ***
  *****
 *******
*********
```
> Stars per row = `2*i - 1` | Spaces before = `n - i`

```java
int n = 5;
for (int i=1; i<=n; i++) {
    for (int j=1; j<=n-i; j++) System.out.print(" ");
    for (int j=1; j<=2*i-1; j++) System.out.print("*");
    System.out.println();
}
```
```python
n = 5
for i in range(1, n+1): print(' '*(n-i) + '*'*(2*i-1))
```

---

### Pattern 9 — Inverted Pyramid
```
*********
 *******
  *****
   ***
    *
```
```java
int n = 5;
for (int i=n; i>=1; i--) {
    for (int j=1; j<=n-i; j++) System.out.print(" ");
    for (int j=1; j<=2*i-1; j++) System.out.print("*");
    System.out.println();
}
```
```python
n = 5
for i in range(n, 0, -1): print(' '*(n-i) + '*'*(2*i-1))
```

---

### Pattern 10 — Butterfly
```
*         *
**       **
***     ***
****   ****
**********
****   ****
***     ***
**       **
*         *
```
> Stars on each side = `i` | Spaces in middle = `2*(n-i)`

```java
int n = 5;
for (int i=1; i<=n; i++) {  // top
    for(int j=1;j<=i;j++) System.out.print("*");
    for(int j=1;j<=2*(n-i);j++) System.out.print(" ");
    for(int j=1;j<=i;j++) System.out.print("*");
    System.out.println();
}
for (int i=n; i>=1; i--) {  // bottom
    for(int j=1;j<=i;j++) System.out.print("*");
    for(int j=1;j<=2*(n-i);j++) System.out.print(" ");
    for(int j=1;j<=i;j++) System.out.print("*");
    System.out.println();
}
```
```python
n = 5
for i in list(range(1, n+1)) + list(range(n, 0, -1)):
    print('*'*i + ' '*(2*(n-i)) + '*'*i)
```

---

### Pattern 11 — Hollow Rectangle
```
****
*  *
*  *
****
```
```java
int r=4, c=4;
for (int i=1; i<=r; i++) {
    for (int j=1; j<=c; j++)
        System.out.print(i==1||i==r||j==1||j==c ? "*" : " ");
    System.out.println();
}
```
```python
r, c = 4, 4
for i in range(r):
    for j in range(c):
        print('*' if i==0 or i==r-1 or j==0 or j==c-1 else ' ', end='')
    print()
```

---

### Pattern 12 — Number Staircase (continuous count)
```
1
2  3
4  5  6
7  8  9  10
11 12 13 14 15
```
```java
int n=5, num=1;
for (int i=1; i<=n; i++) {
    for (int j=1; j<=i; j++) System.out.print(num++ + " ");
    System.out.println();
}
```

---

### Pattern 13 — Row Number Triangle
```
1
2 2
3 3 3
4 4 4 4
5 5 5 5 5
```
```java
for (int i=1; i<=5; i++) {
    for (int j=1; j<=i; j++) System.out.print(i + " ");
    System.out.println();
}
```
```python
for i in range(1, 6): print((str(i)+' ') * i)
```

---

### Pattern 14 — 0-1 Triangle
```
1
0 1
1 0 1
0 1 0 1
1 0 1 0 1
```
> Odd rows start with 1. Even rows start with 0. Flip with `1 - start` each step.

```java
for (int i=1; i<=5; i++) {
    int start = (i % 2 == 0) ? 0 : 1;
    for (int j=1; j<=i; j++) {
        System.out.print(start + " ");
        start = 1 - start;
    }
    System.out.println();
}
```
```python
for i in range(1, 6):
    start = i % 2  # odd row → 1, even row → 0
    row = []
    for j in range(i):
        row.append(str(start)); start = 1 - start
    print(' '.join(row))
```

---

## ✅ Checklist Before You Sleep

- [ ] I know: outer loop = rows, inner loop = columns
- [ ] I can print without newline in Java and Python
- [ ] I traced each pattern manually before coding
- [ ] I solved all 14 patterns
- [ ] I know the pyramid formula: spaces = n-i, stars = 2*i-1
- [ ] I understand the 0-1 flip trick: `start = 1 - start`
- [ ] I know the butterfly = top half + bottom half, same logic

---

## 💬 Community

Which pattern took you the longest? Drop the number in the community.

**Solved all 14? Drop a 🔥 in the community.**

---

*Next up → Day 15: Strings & StringBuilder — the most important topic. Week 3 begins.*
