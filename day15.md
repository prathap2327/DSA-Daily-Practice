# Day 15 — Strings & StringBuilder

> **DSA Partner Challenge** | Week 3: Strings

---

## 📌 Topic of the Day

**Strings & StringBuilder — the most important topic. Finally.**

---

## 🎥 Resources

| Language | Resource |
|----------|----------|
| ☕ Java | [Strings + StringBuilder](https://youtu.be/zL1DPZ0Ovlo?si=KrIZTXMF0lpRMe5w) |
| 🐍 Python | [Live Session 1](https://www.youtube.com/live/6HAu0Y9BjA4?si=0sqwXpIblJq1MQ4p) + [Video 2](https://youtu.be/7ltjqU5iytY?si=rvqH3r9g8qKIFudE) |
| ⚙️ C++ | Striver A2Z DSA playlist — Strings section |

---

## 🧠 Part 1 — Java: Strings

### Key Facts
- String is an **object**, not a primitive
- Strings are **IMMUTABLE** — any modification creates a new object
- Always use `.equals()` for comparison — **never `==`**
- String literals go into the **String Pool** for reuse

### Most-Used Methods

```java
String s = "hello world";

s.length()              // 11
s.charAt(0)             // 'h'
s.substring(6, 11)      // "world"
s.indexOf("world")      // 6
s.contains("hello")     // true
s.replace("hello","hi") // "hi world"
s.toLowerCase()         // "hello world"
s.toUpperCase()         // "HELLO WORLD"
s.trim()                // removes leading/trailing spaces
s.split(" ")            // ["hello", "world"]
s.equals("hello world") // true
s.toCharArray()         // ['h','e','l','l','o',' ','w','o','r','l','d']
String.valueOf(42)      // "42"
Integer.parseInt("42")  // 42
```

### Why Immutability Matters

```java
// BAD — O(n²): creates 1000 String objects
String result = "";
for (int i=0; i<1000; i++) result += i;

// GOOD — O(n): one object, modified in-place
StringBuilder sb = new StringBuilder();
for (int i=0; i<1000; i++) sb.append(i);
String result = sb.toString();
```

---

## 🧠 Part 2 — Java: StringBuilder

```java
StringBuilder sb = new StringBuilder();
sb.append("Hello");        // "Hello"
sb.append(" World");       // "Hello World"
sb.insert(5, "!");         // "Hello! World"
sb.delete(5, 6);           // "Hello World"
sb.reverse();              // "dlroW olleH"
sb.charAt(0);              // 'd'
sb.length();               // 11
sb.toString();             // convert to String

// Common pattern — reverse a String:
String reversed = new StringBuilder(s).reverse().toString();
```

| Feature | String | StringBuilder |
|---------|--------|---------------|
| Mutable | No | Yes |
| Thread safe | Yes | No |
| Concatenation | + (slow in loops) | append() (fast) |
| Use case | Comparisons, fixed | Building in loops |

---

## 🧠 Part 3 — Python: Strings

```python
s = "hello world"

len(s)                # 11
s[0]                  # 'h'
s[-1]                 # 'd'
s[6:11]               # 'world'
s[::-1]               # 'dlrow olleh' — reverse
s.lower()             # 'hello world'
s.upper()             # 'HELLO WORLD'
s.strip()             # remove whitespace
s.split(' ')          # ['hello', 'world']
' '.join(['a','b'])   # 'a b'
s.replace('l','r')    # 'herro worrd'
s.find('world')       # 6  (-1 if not found)
s.count('l')          # 3
'world' in s          # True
s.startswith('he')    # True
s.isdigit()           # False
f"Value: {42}"        # 'Value: 42'
str(42)               # '42'
int('42')             # 42
```

**Fast string building in Python:**
```python
# BAD — O(n²)
result = ''
for i in range(1000): result += str(i)

# GOOD — O(n) — collect then join
parts = [str(i) for i in range(1000)]
result = ''.join(parts)
```

---

## 🧠 Part 4 — C++: Strings

```cpp
#include <string>
using namespace std;

string s = "hello";

s.length()              // 5
s[0]                    // 'h'  ← mutable! s[0]='H' works!
s.substr(1, 3)          // "ell"  (start, LENGTH — not end!)
s.find("ll")            // 2  (string::npos if not found)
s.replace(0, 2, "HE")  // "HEllo"
s += " world"           // "hello world"  ← mutable
s.insert(5, "!")        // "hello! world"
s.erase(5, 1)           // "hello world"
s.empty()               // false
stoi(s)                 // string to int
to_string(42)           // int to string

// Character functions (#include <cctype>)
tolower('A')            // 'a'
toupper('a')            // 'A'
isalpha('a')            // true
isdigit('3')            // true
```

> 💡 C++ `std::string` is **mutable** — no StringBuilder needed. `s.substr(pos, len)` takes LENGTH not end index (different from Java!).

---

## 📊 Quick Comparison

| Feature | Java | Python | C++ |
|---------|------|--------|-----|
| Mutable | No | No | Yes |
| Compare | `.equals()` | `==` | `==` |
| Length | `.length()` | `len(s)` | `.length()` |
| Char at i | `.charAt(i)` | `s[i]` | `s[i]` |
| Slice | `.substring(a,b)` | `s[a:b]` | `.substr(a,b-a)` |
| Reverse | `new StringBuilder(s).reverse()` | `s[::-1]` | `reverse(s.begin(),s.end())` |
| Int→String | `String.valueOf(n)` | `str(n)` | `to_string(n)` |
| String→Int | `Integer.parseInt(s)` | `int(s)` | `stoi(s)` |
| Fast build | StringBuilder | `''.join(list)` | string (mutable) |

---

## 💻 Practice Problems — 7 Easy LeetCode Problems

**Q1. Defanging an IP Address** — [LC #1108](https://leetcode.com/problems/defanging-an-ip-address/) `Easy`
```python
return address.replace('.', '[.]')
```

**Q2. Shuffle String** — [LC #1528](https://leetcode.com/problems/shuffle-string/) `Easy`
```python
res = [''] * len(s)
for i, idx in enumerate(indices): res[idx] = s[i]
return ''.join(res)
```

**Q3. Goal Parser Interpretation** — [LC #1678](https://leetcode.com/problems/goal-parser-interpretation/) `Easy`
```python
return command.replace('()', 'o').replace('(al)', 'al')
```

**Q4. Count Items Matching a Rule** — [LC #1773](https://leetcode.com/problems/count-items-matching-a-rule/) `Easy`
```python
idx = {'type':0, 'color':1, 'name':2}[ruleKey]
return sum(1 for item in items if item[idx] == ruleValue)
```

**Q5. Sorting the Sentence** — [LC #1859](https://leetcode.com/problems/sorting-the-sentence/) `Easy`
```python
words = s.split()
res = [''] * len(words)
for w in words: res[int(w[-1]) - 1] = w[:-1]
return ' '.join(res)
```

**Q6. Check if Two String Arrays are Equivalent** — [LC #1662](https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/) `Easy`
```python
return ''.join(word1) == ''.join(word2)
```

**Q7. To Lower Case** — [LC #709](https://leetcode.com/problems/to-lower-case/) `Easy`
```python
return s.lower()
```

Manual approach (understand ASCII):
```java
// A=65, a=97, difference=32
// lowercase = uppercase + 32
for (char c : s.toCharArray())
    sb.append(c>='A'&&c<='Z' ? (char)(c+32) : c);
```

**ASCII to know:** `'A'=65`, `'Z'=90`, `'a'=97`, `'z'=122`, `'0'=48`, `'9'=57`

---

## ✅ Checklist Before You Sleep

- [ ] I understand String immutability in Java and Python
- [ ] I always use `.equals()` for String comparison in Java
- [ ] I know when to use StringBuilder (loops, building strings in Java)
- [ ] I know `''.join(list)` is the StringBuilder equivalent in Python
- [ ] I know C++ `std::string` is mutable — no StringBuilder needed
- [ ] I know ASCII values for A, a, 0 and the gap of 32
- [ ] I solved all 7 LeetCode problems
- [ ] I can convert between String and int in all 3 languages

---

## 💬 Community

**Solved all 7? Drop a 🔥 in the community.**

---

*Next up → Day 16: String problems — Medium difficulty*
