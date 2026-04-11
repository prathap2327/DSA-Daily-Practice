# Day 33 — Stacks & Queues: From Scratch

> **DSA Partner Challenge** | Week 5

---

## 📌 Topic of the Day

**Stacks & Queues — build from scratch, understand the internals, use in problems.**

---

## 🎥 Resource

[Stacks & Queues Complete Tutorial](https://youtu.be/rHQI4mrJ3cg?si=QXaMqU4oh38ziJtT) — Kunal Kushwaha

---

## 🧠 Part 1 — Stack (LIFO)

Last In, First Out. Think: stack of plates.

| Operation | Description | Time |
|-----------|-------------|------|
| push(x) | Add x to top | O(1) |
| pop() | Remove and return top | O(1) |
| peek()/top() | View top without removing | O(1) |
| isEmpty() | Check if empty | O(1) |

### Stack using Array — Java
```java
class Stack {
    private int[] arr; private int top; private int capacity;
    Stack(int size) { arr=new int[size]; top=-1; capacity=size; }

    void push(int x) {
        if(top==capacity-1) throw new RuntimeException("Stack Overflow");
        arr[++top]=x;
    }
    int pop() {
        if(top==-1) throw new RuntimeException("Stack Underflow");
        return arr[top--];
    }
    int peek()      { return arr[top]; }
    boolean isEmpty(){ return top==-1; }
}
```

### Stack using Linked List (dynamic) — Java
```java
void push(int data) { Node n=new Node(data); n.next=top; top=n; size++; }
int pop()           { int v=top.data; top=top.next; size--; return v; }
```

### Python (use list)
```python
class Stack:
    def __init__(self): self._data=[]
    def push(self,x): self._data.append(x)
    def pop(self):    return self._data.pop()
    def peek(self):   return self._data[-1]
    def is_empty(self): return len(self._data)==0
```

### C++ (STL)
```cpp
stack<int> st;
st.push(10); st.top(); st.pop(); st.empty(); st.size();
```

> **In Java, use `ArrayDeque` as Stack — NOT `java.util.Stack` (synchronized, slow):**
> `Deque<Integer> stack = new ArrayDeque<>();`

---

## 🧠 Part 2 — Queue (FIFO)

First In, First Out. Think: ticket counter line.

| Operation | Description | Time |
|-----------|-------------|------|
| enqueue(x)/offer(x) | Add x to rear | O(1) |
| dequeue()/poll() | Remove from front | O(1) |
| front()/peek() | View front | O(1) |

### Circular Queue — Java (reuses space)
```java
void enqueue(int x) {
    if(size==capacity) throw new RuntimeException("Full");
    rear=(rear+1)%capacity;   // circular wrap
    arr[rear]=x; size++;
}
int dequeue() {
    int val=arr[front];
    front=(front+1)%capacity; // circular wrap
    size--; return val;
}
```

> Without circular indexing, `front` advances rightward and earlier slots are wasted.

### Queue using Linked List — Java
```java
void enqueue(int d) { Node n=new Node(d); if(rear!=null)rear.next=n; rear=n; if(front==null)front=n; }
int dequeue()       { int v=front.data; front=front.next; if(front==null)rear=null; return v; }
```

### Python (use deque)
```python
from collections import deque
q = deque()
q.append(x)      # enqueue (rear)
q.popleft()      # dequeue (front) — O(1)! list.pop(0) is O(n)
```

---

## 🧠 Part 3 — Deque (Double-Ended Queue)

Insert and delete from BOTH ends.

```java
ArrayDeque<Integer> dq = new ArrayDeque<>();
dq.addFirst(x);  dq.addLast(x);
dq.pollFirst();  dq.pollLast();
dq.peekFirst();  dq.peekLast();
// Use as Stack: addFirst/pollFirst
// Use as Queue: addLast/pollFirst
```

---

## 🧠 Part 4 — Queue using Stack / Stack using Queue

**Queue using 2 Stacks (lazy transfer):**
```java
void push(int x) { s1.push(x); }
int pop() {
    if(s2.isEmpty()) while(!s1.isEmpty()) s2.push(s1.pop());  // transfer once
    return s2.pop();
}
```

**Stack using Queue (rotate on push):**
```java
void push(int x) {
    q.offer(x);
    for(int i=0;i<q.size()-1;i++) q.offer(q.poll());  // rotate → new element at front
}
int pop() { return q.poll(); }
```

---

## 💻 Practice Problems — 5 Questions

---

### Q1. Valid Parentheses — [LC #20](https://leetcode.com/problems/valid-parentheses/) `Easy`

```java
Deque<Character> stack = new ArrayDeque<>();
for(char c:s.toCharArray()){
    if(c=='('||c=='{'||c=='[') stack.push(c);
    else{
        if(stack.isEmpty()) return false;
        char t=stack.pop();
        if(c==')'&&t!='(') return false;
        if(c=='}'&&t!='{') return false;
        if(c==']'&&t!='[') return false;
    }
}
return stack.isEmpty();
```
```python
mapping={')':'(', '}':'{', ']':'['}
stack=[]
for c in s:
    if c in '({[': stack.append(c)
    elif not stack or stack[-1]!=mapping[c]: return False
    else: stack.pop()
return not stack
```

---

### Q2. Implement Queue using Stacks — [LC #232](https://leetcode.com/problems/implement-queue-using-stacks/) `Easy`

```java
Deque<Integer> s1=new ArrayDeque<>(), s2=new ArrayDeque<>();
void push(int x) { s1.push(x); }
void transfer()  { if(s2.isEmpty()) while(!s1.isEmpty()) s2.push(s1.pop()); }
int pop()   { transfer(); return s2.pop(); }
int peek()  { transfer(); return s2.peek(); }
boolean empty() { return s1.isEmpty()&&s2.isEmpty(); }
```

---

### Q3. Implement Stack using Queues — [LC #225](https://leetcode.com/problems/implement-stack-using-queues/) `Easy`

```java
Queue<Integer> q = new LinkedList<>();
void push(int x) {
    q.offer(x);
    for(int i=0;i<q.size()-1;i++) q.offer(q.poll());  // rotate
}
int pop()   { return q.poll(); }
int top()   { return q.peek(); }
boolean empty() { return q.isEmpty(); }
```

---

### Q4. Min Stack — [LC #155](https://leetcode.com/problems/min-stack/) `Medium`

```java
Deque<Integer> stack=new ArrayDeque<>(), minStack=new ArrayDeque<>();
void push(int val) {
    stack.push(val);
    minStack.push(minStack.isEmpty()?val:Math.min(val,minStack.peek()));
}
void pop()      { stack.pop(); minStack.pop(); }
int top()       { return stack.peek(); }
int getMin()    { return minStack.peek(); }
```

```python
def push(self, val):
    self.stack.append(val)
    m = min(val, self.min_stack[-1]) if self.min_stack else val
    self.min_stack.append(m)
def pop(self): self.stack.pop(); self.min_stack.pop()
def top(self): return self.stack[-1]
def getMin(self): return self.min_stack[-1]
```

> `minStack[i]` = minimum of all elements from bottom to position i. Always in sync with main stack.

---

### Q5. Next Greater Element I — [LC #496](https://leetcode.com/problems/next-greater-element-i/) `Medium`

**Monotonic Stack:**
```java
Map<Integer,Integer> nge=new HashMap<>();
Deque<Integer> stack=new ArrayDeque<>();
for(int i=nums2.length-1;i>=0;i--){
    while(!stack.isEmpty()&&stack.peek()<=nums2[i]) stack.pop();
    nge.put(nums2[i], stack.isEmpty()?-1:stack.peek());
    stack.push(nums2[i]);
}
```
```python
nge, stack = {}, []
for n in nums2:
    while stack and stack[-1]<n: nge[stack.pop()]=n
    stack.append(n)
return [nge.get(n,-1) for n in nums1]
```

> **Monotonic Stack pattern** — critical for: Next Greater, Stock Span, Largest Rectangle in Histogram.

---

## 📊 Stack vs Queue

| Feature | Stack | Queue |
|---------|-------|-------|
| Order | LIFO | FIFO |
| Insert | push (top) | enqueue (rear) |
| Remove | pop (top) | dequeue (front) |
| Java | `ArrayDeque` | `ArrayDeque` / `LinkedList` |
| Python | `list` | `collections.deque` |
| Real uses | DFS, undo, expression eval | BFS, scheduling |

---

## ✅ Checklist Before You Sleep

- [ ] Stack from scratch — array + linked list implementations
- [ ] Queue with circular indexing — `rear = (rear+1) % capacity`
- [ ] `deque.popleft()` is O(1); `list.pop(0)` is O(n) — always use deque in Python
- [ ] Queue using Stack — lazy transfer pattern
- [ ] Min Stack — parallel min-tracking stack
- [ ] Monotonic Stack for Next Greater Element
- [ ] Solved all 5 problems

---

## 💬 Community

Min Stack is one of those problems that makes you think "why didn't I think of that?" — the parallel stack idea is elegant. Share your first approach in the community.

**Solved all 5? Drop a 🔥 in the community.**

---

*Next up → Day 34: Stack & Queue — Advanced interview problems*
