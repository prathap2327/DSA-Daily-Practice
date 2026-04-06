# Day 28 — OOPs Part 2: Java Deep Dive Interview Questions

> **DSA Partner Challenge** | Week 4

---

## 📌 Topic of the Day

**Tricky OOP interview questions — real answers, real reasoning.**

---

## 🎥 Resources

| Language | Links |
|----------|-------|
| Java | [youtu.be/_Ya6CN13t8k](https://youtu.be/_Ya6CN13t8k?si=i3B6CGaeDEx812RI) · [youtu.be/46T2wD3IuhM](https://youtu.be/46T2wD3IuhM?si=Qbe1uN8z1R0eCSTR) |
| C++ | [youtu.be/sNiiJ16dLz0](https://youtu.be/sNiiJ16dLz0?si=bla_NTW2stu0hZzj) · [youtu.be/ZIL8t5AoGmQ](https://youtu.be/ZIL8t5AoGmQ?si=xtDhOWqXrWZGJ5Ly) · [youtu.be/qq3BY4viEB4](https://youtu.be/qq3BY4viEB4?si=9uHrtBopjppDmN37) |

---

## Q1. Can we declare main() as private, protected, or with no access modifier?

**NO.** `main()` must be `public`. The JVM calls it from outside the class — only `public` makes it accessible.

| Modifier | Compiles? | Runtime |
|----------|-----------|---------|
| `public static void main` | Yes | ✅ Works |
| `private static void main` | Yes | ❌ `Main method not found` |
| `protected static void main` | Yes | ❌ `Main method not found` |
| `(default) static void main` | Yes | ❌ `Main method not found` |

```java
// Full correct signature — know this cold:
public static void main(String[] args)
// public  → JVM can access from outside
// static  → JVM calls without creating an object
// void    → returns nothing to JVM
// String[]→ accepts command-line arguments
```

> **Follow-up:** Can we overload `main()`? YES — but JVM only calls `main(String[] args)` as the entry point.

---

## Q2. Difference between Method Overloading and Method Overriding?

| Feature | Overloading | Overriding |
|---------|------------|-----------|
| Definition | Same name, different params | Same name AND same params |
| Location | Same class | Parent + Child class |
| Binding | Compile-time | Runtime |
| Return type | Can differ | Same (or covariant subtype) |
| Access modifier | Can differ | Can only broaden, not restrict |
| static methods | Can overload | Cannot override (method hiding) |
| `@Override` | Not used | Should always use |

```java
// Overloading
int add(int a, int b)         { return a+b; }
double add(double a, double b) { return a+b; }

// Overriding
class Animal { void sound() { System.out.println("..."); } }
class Dog extends Animal {
    @Override void sound() { System.out.println("Woof!"); }
}
Animal a = new Dog();
a.sound();   // Woof! — runtime dispatch
```

---

## Q3. Can we declare interface members as private or protected in Java 8?

**NO (Java 8). YES (Java 9) for private only.**

| Member | Pre-Java 8 | Java 8 | Java 9+ |
|--------|-----------|--------|---------|
| abstract method | public | public | public |
| default method | ✗ | ✅ public | public |
| static method | ✗ | ✅ public | public |
| private method | ✗ | ✗ | ✅ ALLOWED |
| protected method | ✗ | ✗ | ✗ |

```java
// Java 8: default + static (both public)
interface Greeter {
    void greet(String name);                          // abstract
    default void greetAll(String[] names) { ... }    // default (Java 8)
    static Greeter formal() { return name -> ...; }  // static (Java 8)
}

// Java 9: private helper methods
interface Logger {
    default void logInfo(String msg)  { log("INFO",  msg); }
    default void logError(String msg) { log("ERROR", msg); }
    private void log(String level, String msg) { ... }  // Java 9
}
```

---

## Q4. Can we override a private or static method in Java?

**NO to both.**

**Private methods:** not inherited → not visible in child → cannot be overridden. Writing same method in child = brand new method.

**Static methods:** method hiding (not overriding). Resolved at **compile time** based on reference type, not object type.

```java
// Static — method hiding
class Parent { static void display() { System.out.println("Parent"); } }
class Child  { static void display() { System.out.println("Child");  } }

Parent p = new Child();
p.display();   // "Parent" — reference type decides (compile-time)
Child c = new Child();
c.display();   // "Child"
```

> Overriding = runtime dispatch. Hiding = compile-time decision. This is the key difference.

---

## Q5. What is the Diamond Problem in Java?

When a class inherits from two classes that both inherit from a common ancestor, the child has ambiguous access to the ancestor's method.

```
    A
   / \
  B   C
   \ /
    D  ← Which A.method() does D use? B's or C's?
```

**Java prevents this:**
- No multiple class inheritance. Period.
- Interfaces with default methods: compiler **forces** the implementor to resolve the ambiguity.

```java
interface A { default void show() { System.out.println("A"); } }
interface B extends A { default void show() { System.out.println("B"); } }
interface C extends A { default void show() { System.out.println("C"); } }

class D implements B, C {
    @Override
    public void show() {
        B.super.show();   // explicitly choose B's version
    }
}
```

**C++ solution:** `virtual` inheritance ensures only one copy of the base class exists.

---

## Q6. Can we pass 'this' keyword as an argument in a method call?

**YES.** `this` is a reference to the current object. It can be passed, returned, or stored like any other reference.

```java
// Use 1: Pass to another method
class Student {
    void display() {
        Printer p = new Printer();
        p.print(this);   // passes current Student object
    }
}

// Use 2: Return 'this' for method chaining (Builder Pattern)
class Builder {
    Builder setName(String n) { this.name=n; return this; }
    Builder setAge(int a)     { this.age=a;  return this; }
    void build() { System.out.println(name+" "+age); }
}
new Builder().setName("Alice").setAge(25).build();

// Use 3: Constructor chaining
class Point {
    int x, y;
    Point()          { this(0, 0); }     // calls Point(int,int)
    Point(int x, int y) { this.x=x; this.y=y; }
}
```

> `this` cannot be used in static context. `this()` must be the first statement in a constructor.

---

## 📊 Quick Revision

| Question | Answer |
|----------|--------|
| main() private? | NO — must be public (JVM access) |
| Overloading vs Overriding | Same class compile-time vs child class runtime |
| Interface private Java 8? | NO — Java 9 added private methods |
| Override private/static? | NO — private not inherited; static is hidden not overridden |
| Diamond problem? | Multiple inheritance ambiguity — Java prevents; interface resolves with `X.super.method()` |
| Pass `this` as argument? | YES — reference to current object |

---

## ✅ Checklist Before You Sleep

- [ ] I know why main() must be public (JVM access)
- [ ] I can explain overloading vs overriding with code
- [ ] I know what Java 8 added to interfaces and what Java 9 added
- [ ] I understand method hiding (static) vs method overriding (instance)
- [ ] I can draw the diamond problem and explain Java's fix
- [ ] I know the 3 use cases of `this` as argument/return

---

## 💬 Community

The diamond problem question trips up almost everyone the first time. Can you explain it to someone else without looking at your notes?

**Nailed all 6? Drop a 🔥 in the community.**

---

*Next up → Day 29: OOPs continues — Collections, Generics, Exception deep dive*
