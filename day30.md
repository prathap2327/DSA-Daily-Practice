# Day 30 — OOPs Part 4: Singleton Defence + HackerRank OOP Practice

> **DSA Partner Challenge** | Week 5

---

## 📌 Topic of the Day

**Protecting Singleton from every attack + 5 HackerRank OOP problems.**

---

## 🎥 Resources

| Language | Links |
|----------|-------|
| Java | [youtu.be/OY2lPr8h93U](https://youtu.be/OY2lPr8h93U?si=WMFs2FqSAc0D33jV) · [youtu.be/9ogGan-R1pc](https://youtu.be/9ogGan-R1pc?si=KBEjUi038eiRwZFv) |
| C++ | [youtu.be/essQiHKRmrc](https://youtu.be/essQiHKRmrc?si=3xqBCm06oOfAR1ge) · [youtu.be/NBsmPHXjLfg](https://youtu.be/NBsmPHXjLfg?si=EgVO9AYJFR_ahgrr) |

---

## 🧠 Topic 1 — Singleton Defence: 3 Attacks + Fixes

### Attack 1: Reflection
```java
// Attack:
Constructor<Singleton> c = Singleton.class.getDeclaredConstructor();
c.setAccessible(true);
Singleton s2 = c.newInstance();  // second instance!

// Fix: throw in constructor if instance exists
private Singleton() {
    if (instance != null)
        throw new RuntimeException("Use getInstance() — cannot instantiate again");
}
```

### Attack 2: Serialisation
```java
// Attack: deserialising creates a new object
ObjectInputStream in = new ObjectInputStream(new FileInputStream("s.obj"));
Singleton s2 = (Singleton) in.readObject();  // new instance!

// Fix: implement readResolve()
class Singleton implements Serializable {
    protected Object readResolve() {
        return getInstance();   // returns existing instance during deserialisation
    }
}
```

### Attack 3: Cloning
```java
// Attack:
Singleton s2 = (Singleton) s1.clone();   // second instance!

// Fix: override clone()
@Override
protected Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException("Singleton — cloning not allowed");
}
```

### Best solution — Enum Singleton
```java
enum Singleton {
    INSTANCE;
    public void doSomething() { }
}
```

| Attack | Enum | Regular Singleton |
|--------|------|------------------|
| Reflection | ✅ Safe | ❌ Vulnerable |
| Serialisation | ✅ Safe | ❌ Vulnerable |
| Cloning | ✅ Safe | ❌ Vulnerable |

---

## 🧠 Topic 2 — Double-Check Locking

Lazy + thread-safe + efficient.

```java
class Singleton {
    private static volatile Singleton instance;   // volatile is ESSENTIAL
    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {                   // Check 1: fast path, no lock
            synchronized (Singleton.class) {       // Lock
                if (instance == null) {            // Check 2: prevents double-creation
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

**Why both checks?**
- Check 1 skips the expensive lock when instance already exists (99% of calls)
- Check 2 prevents two threads that both passed Check 1 from both creating an instance

**Why `volatile`?**
`new Singleton()` is 3 CPU steps: allocate → initialise → assign. Without `volatile`, a thread can see the reference assigned but the object not yet initialised.

| Approach | Thread-safe | Lazy | Performance |
|----------|------------|------|------------|
| Eager | ✅ | ❌ | Fast |
| Lazy no sync | ❌ | ✅ | Fast |
| Synchronised method | ✅ | ✅ | Slow |
| Double-check lock | ✅ | ✅ | **Fast** |
| Bill Pugh | ✅ | ✅ | **Fast** |
| Enum | ✅ | ❌ | **Safest** |

---

## 💻 HackerRank Practice — 5 OOP Problems

### P1. Java Inheritance I
[hackerrank.com/challenges/java-inheritance-1](https://www.hackerrank.com/challenges/java-inheritance-1)
```java
class Animal { void walk() { System.out.println("I am walking"); } }
class Bird extends Animal { void fly() { System.out.println("I am flying"); } }
```
```python
class Animal:
    def walk(self): print('I am walking')
class Bird(Animal):
    def fly(self): print('I am flying')
```

---

### P2. Java Abstract Class
[hackerrank.com/challenges/java-abstract-class](https://www.hackerrank.com/challenges/java-abstract-class)
```java
abstract class Book {
    String title;
    abstract void setTitle(String s);
    String getTitle() { return title; }
}
class MyBook extends Book {
    @Override void setTitle(String s) { title = s; }
}
```
```python
from abc import ABC, abstractmethod
class Book(ABC):
    @abstractmethod
    def set_title(self, s): pass
class MyBook(Book):
    def set_title(self, s): self.title = s
```

---

### P3. Java Interface
[hackerrank.com/challenges/java-interface](https://www.hackerrank.com/challenges/java-interface)
```java
interface AdvancedArithmetic { int divisorSum(int n); }
class MyCalculator implements AdvancedArithmetic {
    public int divisorSum(int n) {
        int sum=0;
        for (int i=1; i<=n; i++) if(n%i==0) sum+=i;
        return sum;
    }
}
```

---

### P4. Java Method Overriding
[hackerrank.com/challenges/java-method-overriding](https://www.hackerrank.com/challenges/java-method-overriding)
```java
class Sports {
    String getName() { return "Generic Sport"; }
    void describe() { System.out.println("Learn to play "+getName()); }
}
class Football extends Sports {
    @Override String getName() { return "Football"; }
    @Override void describe() {
        super.describe();
        System.out.println("Football is played with 11 players per side.");
    }
}
```
```python
class Sports:
    def get_name(self): return 'Generic Sport'
    def describe(self): print(f'Learn to play {self.get_name()}')
class Football(Sports):
    def get_name(self): return 'Football'
    def describe(self):
        super().describe()
        print('Football is played with 11 players.')
```

---

### P5. Java instanceof keyword
[hackerrank.com/challenges/java-instanceof-keyword](https://www.hackerrank.com/challenges/java-instanceof-keyword)
```java
static String typeCheck(Object o) {
    if (o instanceof Integer) return "Integer";
    if (o instanceof Double)  return "Double";
    if (o instanceof String)  return "String";
    return "Unknown";
}
// Java 16+ pattern matching:
if (o instanceof String s) { System.out.println(s.toUpperCase()); }
```
```python
# Python equivalent: isinstance()
isinstance(x, int)            # True if x is int
isinstance(x, (int, float))   # True if int OR float
type(x).__name__               # get type name as string
```

---

## ✅ Checklist Before You Sleep

- [ ] 3 Singleton attacks: Reflection, Serialisation, Cloning
- [ ] 3 fixes: constructor guard, readResolve(), clone() override
- [ ] Enum Singleton is immune to all three
- [ ] Double-check locking: why BOTH checks are needed
- [ ] Why `volatile` is essential for double-check locking
- [ ] Solved all 5 HackerRank OOP problems

---

## 💬 Community

30 days done. Singleton, OOPs, Backtracking, Recursion, Maths, Strings, Arrays, Sorting — we've covered it all. How many days did you not miss?

**Drop your streak in the community. 🔥**

---

*Next up → Day 31: Collections Framework — ArrayList, LinkedList, HashMap, HashSet*
