# Day 27 — Object Oriented Programming (OOPs)

> **DSA Partner Challenge** | Week 4

---

## 📌 Topic of the Day

**OOPs — the foundation of every system design and backend interview.**

---

## 🎥 Resources

| Language | Resource |
|----------|----------|
| Java | [youtu.be/BSVKUk58K6U](https://youtu.be/BSVKUk58K6U?si=pzgdHQ_BqQklw9l4) |
| C++ | [youtu.be/iw1Xf_33YM0](https://youtu.be/iw1Xf_33YM0?si=dJMOrgwPynyfPKz6) |
| Python | CampusX YouTube Channel |

---

## 🧠 Part 1 — The 4 Pillars

| Pillar | Definition | Keyword |
|--------|-----------|---------|
| Encapsulation | Bundle data + methods. Hide state via access modifiers | `private`, getter/setter |
| Inheritance | Child acquires parent properties. Promotes reuse | `extends` (Java), `:` (C++) |
| Polymorphism | One interface, many forms. Method behaves differently per object | `@Override`, overloading |
| Abstraction | Show WHAT, hide HOW | `abstract`, `interface` |

---

## 🧠 Part 2 — Classes, Objects, Constructors

```java
class Car {
    String brand; int speed;                    // instance variables
    Car(String b, int s) { this.brand=b; this.speed=s; }  // constructor
    void accelerate() { speed += 10; }
}
Car c1 = new Car("Toyota", 60);  // object on heap
```

```python
class Car:
    def __init__(self, brand, speed):
        self.brand = brand; self.speed = speed
```

```cpp
class Car {
public:
    string brand; int speed;
    Car(string b, int s) : brand(b), speed(s) {}  // initialiser list
};
```

**`this` / `self`:** refers to the current object — used to distinguish instance variables from parameters.

---

## 🧠 Part 3 — static · final · Wrapper Classes

```java
class Counter {
    static int count = 0;           // shared across ALL objects
    Counter() { count++; }
    static int getCount() { return count; }  // call: Counter.getCount()
}
```

- `final variable` → constant, cannot be reassigned
- `final method` → cannot be overridden
- `final class` → cannot be subclassed (e.g. `String`, `Integer`)

**Wrapper classes:** `int → Integer`, `double → Double` — needed for Collections.
Autoboxing/unboxing handles conversion automatically.

---

## 🧠 Part 4 — Inheritance

```java
class Animal { void eat() { System.out.println(name+" eats"); } }
class Dog extends Animal { void bark() { System.out.println("Woof!"); } }
```

- `super.method()` → call parent method
- `super()` → call parent constructor (first line)
- Java supports: Single, Multilevel, Hierarchical. No multiple inheritance (use interface).

---

## 🧠 Part 5 — Polymorphism

**Overloading (compile-time):** same name, different parameters.
```java
int add(int a, int b) { return a+b; }
double add(double a, double b) { return a+b; }
```

**Overriding (runtime):** child replaces parent method.
```java
class Dog extends Animal {
    @Override void sound() { System.out.println("Woof!"); }
}
Animal a = new Dog();
a.sound();   // Woof! ← runtime dispatch (dynamic binding)
```

---

## 🧠 Part 6 — Access Modifiers

| Modifier | Same Class | Same Package | Subclass | Everywhere |
|----------|-----------|-------------|---------|-----------|
| private | ✓ | ✗ | ✗ | ✗ |
| default | ✓ | ✓ | ✗ | ✗ |
| protected | ✓ | ✓ | ✓ | ✗ |
| public | ✓ | ✓ | ✓ | ✓ |

---

## 🧠 Part 7 — Abstract Class vs Interface

| Feature | Abstract Class | Interface |
|---------|---------------|-----------|
| Instantiate | No | No |
| Constructor | Yes | No |
| Methods | Abstract + Concrete | Abstract (+ default Java 8+) |
| Variables | Any | `public static final` only |
| Multiple inheritance | No | Yes (`implements A, B`) |
| Use when | Common base + shared code | Capability contract, multiple types |

```java
abstract class Shape { abstract double area(); }
interface Flyable { void fly(); }
interface Swimmable { void swim(); }
class Duck extends Animal implements Flyable, Swimmable { ... }
```

---

## 🧠 Part 8 — Generics, Lambda, Exceptions

**Generics:**
```java
class Box<T> { private T value; Box(T v){value=v;} T get(){return value;} }
class NumberStack<T extends Number> { ... }  // bounded: only Numbers
```

**Lambda (Java 8+):**
```java
Comparator<String> c = (a, b) -> a.length() - b.length();
list.forEach(System.out::println);   // method reference
```

**Exception hierarchy:**
```java
// Checked (must handle at compile time)
class InsufficientFundsException extends Exception { ... }
// Unchecked (optional to handle)
class NegativeAmountException extends RuntimeException { ... }
```

---

## 💻 5 Interview-Level Questions

---

### Q1. Design a Parking Lot System `System Design OOP`

Key classes: `Vehicle (abstract)`, `Car/Bike/Truck extends Vehicle`, `ParkingSpot`, `ParkingLot`

```java
abstract class Vehicle { String plate; VehicleType type; }
class Car extends Vehicle { Car(String p){plate=p;type=VehicleType.CAR;} }

class ParkingSpot {
    VehicleType type; boolean isOccupied; Vehicle currentVehicle;
    boolean park(Vehicle v) {
        if(!isOccupied && v.type==this.type){ currentVehicle=v; isOccupied=true; return true; }
        return false;
    }
    void vacate() { currentVehicle=null; isOccupied=false; }
}
```

---

### Q2. Generic Stack with Bounded Type `Generics`

```java
class Stack<T> {
    private List<T> data = new ArrayList<>();
    public void push(T item) { data.add(item); }
    public T pop() { return data.remove(data.size()-1); }
}
class NumberStack<T extends Number> {
    private List<T> data = new ArrayList<>();
    public double sum() { return data.stream().mapToDouble(Number::doubleValue).sum(); }
}
```

---

### Q3. Override equals() and hashCode() Correctly `Core Java`

```java
class Point {
    int x, y;
    @Override public boolean equals(Object obj) {
        if(this==obj) return true;
        if(!(obj instanceof Point)) return false;
        Point p=(Point)obj; return x==p.x && y==p.y;
    }
    @Override public int hashCode() { return Objects.hash(x, y); }
}
```

> Contract: if `a.equals(b)` then `a.hashCode() == b.hashCode()`. Breaking this breaks `HashMap`/`HashSet`.

---

### Q4. Custom Exception Hierarchy `Exceptions`

```java
class InsufficientFundsException extends Exception {          // CHECKED
    InsufficientFundsException(double r) { super("Cannot withdraw "+r); }
}
class NegativeAmountException extends RuntimeException {      // UNCHECKED
    NegativeAmountException(double a) { super("Negative amount: "+a); }
}
class BankAccount {
    public void withdraw(double amt) throws InsufficientFundsException {
        if(amt<0) throw new NegativeAmountException(amt);
        if(amt>balance) throw new InsufficientFundsException(amt);
        balance -= amt;
    }
}
```

---

### Q5. Strategy Pattern using Interface + Lambda `Design Patterns`

```java
@FunctionalInterface interface SortStrategy { void sort(int[] arr); }
class Sorter {
    private SortStrategy strategy;
    Sorter(SortStrategy s) { strategy=s; }
    void setStrategy(SortStrategy s) { strategy=s; }
    void sort(int[] arr) { strategy.sort(arr); }
}
SortStrategy bubbleSort = arr -> { /* bubble sort */ };
SortStrategy javaSort   = arr -> Arrays.sort(arr);
Sorter s = new Sorter(bubbleSort);
s.setStrategy(javaSort);   // swap at runtime — no code change in Sorter
```

---

## ✅ Checklist Before You Sleep

- [ ] 4 pillars: Encapsulation, Inheritance, Polymorphism, Abstraction
- [ ] Overloading (compile-time) vs Overriding (runtime)
- [ ] Abstract class vs Interface — when to use which
- [ ] The equals/hashCode contract — why it matters for HashMap
- [ ] Checked vs unchecked exceptions — when to throw each
- [ ] Strategy Pattern: interface + lambda = swappable behaviour at runtime
- [ ] Generic bounded types: `<T extends Number>`

---

## 💬 Community

OOP is tested in EVERY backend and SDE interview. Which of the 5 questions challenged you most today? Drop it in the community.

**Done all 5? Drop a 🔥 in the community.**

---

*Next up → Day 28: Hashing — HashMap, HashSet, frequency maps*
