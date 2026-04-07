# Day 29 — OOPs Part 3: Constructor Internals · Covariant Return · Singleton Pattern

> **DSA Partner Challenge** | Week 5

---

## 📌 Topic of the Day

**OOP deep dive — 3 questions that go beyond surface-level Java knowledge.**

---

## 🎥 Resources

| Language | Links |
|----------|-------|
| Java | [youtu.be/W145DXs8fFg](https://youtu.be/W145DXs8fFg?si=oZ8PBvOhu_qCfuVX) · [youtu.be/rgHZa7-Dibg](https://youtu.be/rgHZa7-Dibg?si=2PnalWT8zcUJk6lM) |
| C++ | [youtu.be/ww02EpE4DZo](https://youtu.be/ww02EpE4DZo?si=DRVh4Rs_87C52Kkn) · [youtu.be/p2h8rGnkD0o](https://youtu.be/p2h8rGnkD0o?si=wOvAn16R16e8iFos) |

---

## Q1. Java constructor returns a value, but what? — Javatpoint

**YES** — a constructor implicitly returns the current class instance (`this`).

There is NO return statement — but the JVM's `new` instruction allocates the object on the heap and the constructor initialises it. The reference was already on the stack from `new`.

```java
class Student {
    String name; int age;
    Student(String n, int a) {
        this.name=n; this.age=a;
        // implicitly returns 'this' — the new Student object
    }
}
Student s = new Student("Alice", 21);
// new → allocates heap memory
// Student(...) → runs constructor, initialises fields
// = s → s holds the reference to the new object
```

| Aspect | Constructor | Regular Method |
|--------|------------|----------------|
| Return type declared | None | void or any type |
| Implicitly returns | Current class instance | Nothing (if void) |
| Name | Same as class name | Any valid identifier |
| Inherited | NOT inherited | Inherited (unless private) |
| Called with | `new` keyword | Object reference |

**Watch out:** A method with a return type named the same as the class is NOT a constructor:
```java
class Test {
    void Test() { }   // ← method, not constructor (has return type void)
}
```

> **Follow-up:** Can a constructor be `final`, `static`, or `abstract`?
> - `final` → NO (constructors aren't inherited)
> - `static` → NO (tied to instance creation)
> - `abstract` → NO (can't override constructors)
> - `synchronized` → YES ✅

---

## Q2. What is Covariant Return Type? — Javatpoint

An overriding method in a child class can return a **more specific (narrower) subtype** than the parent's declared return type.

Introduced in **Java 5**.

```java
class Animal {
    public Animal create() { return new Animal(); }
}
class Dog extends Animal {
    @Override
    public Dog create() {   // Dog is a subtype of Animal — covariant!
        return new Dog();
    }
}
Dog d = new Dog();
Dog puppy = d.create();     // no cast needed!
```

**Classic use — overriding clone():**
```java
class Employee implements Cloneable {
    @Override
    public Employee clone() throws CloneNotSupportedException {
        return (Employee) super.clone();   // covariant — no cast at call site
    }
}
```

| Aspect | Without Covariant | With Covariant |
|--------|-------------------|----------------|
| Child return type | Must match parent | Can be subtype |
| Call site | `(Dog) a.create()` | `d.create()` — no cast |
| Type safety | ClassCastException risk | Compile-time safe |
| Java version | Pre Java 5 | Java 5+ |

> Only reference types can be covariant. Primitive types cannot be narrowed in overrides.

---

## Q3. Private classes and Singleton Classes in Java — GFG

### Part A — Private Classes

Top-level classes **cannot** be private. Only inner/nested classes can.

| Class Type | public | private | default |
|-----------|--------|---------|---------|
| Top-level | ✓ | ✗ compile error | ✓ |
| Inner class | ✓ | ✓ **Allowed** | ✓ |
| Static nested | ✓ | ✓ **Allowed** | ✓ |

```java
class Outer {
    private class Inner {    // private — only Outer can see this
        void show() { System.out.println("Private inner class"); }
    }
    void demo() { new Inner().show(); }
}
```

---

### Part B — Singleton Pattern

Exactly **one instance** throughout the application lifetime.

**Three ingredients:**
1. `private constructor` → prevents `new MyClass()` from outside
2. `private static instance` → stored inside the class
3. `public static getInstance()` → the only way to get it

#### 1. Eager (simplest, thread-safe):
```java
class Singleton {
    private static final Singleton instance = new Singleton();  // eager
    private Singleton() {}
    public static Singleton getInstance() { return instance; }
}
```

#### 2. Lazy (not thread-safe):
```java
class Singleton {
    private static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) instance = new Singleton();  // ← race condition!
        return instance;
    }
}
```

#### 3. Double-Checked Locking (thread-safe + efficient):
```java
class Singleton {
    private static volatile Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) instance = new Singleton();
            }
        }
        return instance;
    }
}
```

#### 4. Bill Pugh (best practice — lazy + thread-safe):
```java
class Singleton {
    private Singleton() {}
    private static class Holder {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance() { return Holder.INSTANCE; }
}
```

#### 5. Enum (safest — Joshua Bloch's recommendation):
```java
enum Singleton {
    INSTANCE;
    public void doSomething() { }
}
// Serialisation-safe ✓  Reflection-safe ✓  Thread-safe ✓
```

**Where Singleton is used:** Logger, DB connection pool, Config manager, Thread pool, Cache manager

**Breaking and protecting Singleton:**
- Reflection attack → throw exception if `instance != null` in constructor
- Serialisation attack → add `readResolve()` returning existing instance
- Clone attack → override `clone()` to throw `CloneNotSupportedException`

---

## 📊 Quick Revision

| Question | Answer |
|----------|--------|
| Constructor returns what? | Current class instance (`this`) — implicit |
| Constructor with return type? | Becomes a method, not a constructor |
| Covariant return type? | Child method returns subtype of parent's return type |
| Added in Java? | Java 5 |
| Top-level class private? | NO — only public or default |
| Best thread-safe Singleton? | Bill Pugh or Enum-based |

---

## ✅ Checklist Before You Sleep

- [ ] I can explain what a constructor implicitly returns
- [ ] I know covariant return type with clone() example
- [ ] I know which class types can be private
- [ ] I can implement all 4 Singleton variants from memory
- [ ] I know the Enum Singleton is the safest
- [ ] I know how to protect Singleton from reflection, serialisation, and cloning

---

## 💬 Community

The Bill Pugh Singleton pattern is elegant. Can you explain WHY the inner class approach is both lazy AND thread-safe without any synchronised block?

**Answered all 3? Drop a 🔥 in the community.**

---

*Next up → Day 30: OOPs — Collections Framework deep dive*
