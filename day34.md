# Day 34 — Stack & Queue Interview Questions (FAANG Level)

> **DSA Partner Challenge** | Week 5

---

## 📌 Topic of the Day

**6 Stack & Queue interview questions from the video — Google · Facebook · Amazon · Microsoft**

---

## 🎥 Resource

[Stack & Queue Interview Questions](https://youtu.be/S9LUYztYLu4?si=aunOzmm0NoY3ABWM) — Kunal Kushwaha

---

## 🧠 Thought Process

Stack triggers: nested structures, matching/pairing, reversals, expression evaluation, undo.
Monotonic Stack: next greater/smaller, stock span, **largest rectangle**, trapping rain water.

---

## 💻 6 Problems from the Video

---

### Q1. Implement Queue using Stacks — [LC #232](https://leetcode.com/problems/implement-queue-using-stacks/) `Easy`

```java
Deque<Integer> s1=new ArrayDeque<>(), s2=new ArrayDeque<>();
void push(int x) { s1.push(x); }
void transfer()  { if(s2.isEmpty()) while(!s1.isEmpty()) s2.push(s1.pop()); }
int pop()   { transfer(); return s2.pop(); }
int peek()  { transfer(); return s2.peek(); }
boolean empty() { return s1.isEmpty()&&s2.isEmpty(); }
```

> Each element: pushed to s1 once, transferred once, popped once = amortised **O(1)**.

---

### Q2. Game of Two Stacks — HackerRank `Medium`

Greedily take as many from stack A as possible. Then try adding from stack B while removing from A if sum exceeds maxSum.

```java
int i=0, j=0, sum=0, count=0, maxCount=0;
while(i<a.length && sum+a[i]<=maxSum) { sum+=a[i++]; count++; }
maxCount=count;
while(j<b.length) {
    sum+=b[j++]; count++;
    while(sum>maxSum && i>0) { sum-=a[--i]; count--; }
    if(sum<=maxSum) maxCount=Math.max(maxCount, count);
}
return maxCount;
```

---

### Q3. Largest Rectangle in Histogram — [LC #84](https://leetcode.com/problems/largest-rectangle-in-histogram/) `Hard`

```java
Deque<Integer> stack=new ArrayDeque<>(); int maxArea=0, n=heights.length;
for(int i=0;i<=n;i++){
    int h=(i==n)?0:heights[i];                        // sentinel 0 at end
    while(!stack.isEmpty() && h<heights[stack.peek()]){
        int height=heights[stack.pop()];
        int width=stack.isEmpty()?i:i-stack.peek()-1; // width between boundaries
        maxArea=Math.max(maxArea,height*width);
    }
    stack.push(i);
}
return maxArea;
```

```python
stack=[]; max_area=0; n=len(heights)
for i in range(n+1):
    h=0 if i==n else heights[i]
    while stack and h<heights[stack[-1]]:
        height=heights[stack.pop()]
        width=i if not stack else i-stack[-1]-1
        max_area=max(max_area,height*width)
    stack.append(i)
return max_area
```

**Trace: [2,1,5,6,2,3]**
```
i=4: pop 3 (h=6). width=4-2-1=1. area=6.
     pop 2 (h=5). width=4-1-1=2. area=10 ← MAX
Final: 10
```

> Monotonic increasing stack. When a shorter bar is found: pop and compute area. Width = current index - new stack top - 1. Sentinel 0 flushes remaining bars.

---

### Q4. Valid Parentheses — [LC #20](https://leetcode.com/problems/valid-parentheses/) `Easy`

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

### Q5. Minimum Add to Make Parentheses Valid — [LC #921](https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/) `Medium`

Each `(` needs one `)`. Track unmatched `(` and unmatched `)`.

```java
int open=0, close=0;
for(char c:s.toCharArray()){
    if(c=='(') open++;
    else{ if(open>0) open--; else close++; }
}
return open+close;
```

```python
open_=close=0
for c in s:
    if c=='(': open_+=1
    elif open_>0: open_-=1
    else: close+=1
return open_+close
```

> `open` = unmatched `(` needing `)`. `close` = unmatched `)` needing `(`. Answer = `open + close`.

---

### Q6. Minimum Insertions to Balance a Parentheses String — [LC #1541](https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/) `Hard`

Each `(` now needs `))` (TWO closing brackets).

```java
int open=0, res=0, i=0;
while(i<s.length()){
    char c=s.charAt(i++);
    if(c=='(') open++;
    else{
        if(i<s.length()&&s.charAt(i)==')') i++;  // consume pair ))
        else res++;                                 // insert )
        if(open>0) open--;
        else res++;                                 // insert (
    }
}
return res+open*2;  // each unmatched ( needs 2 )
```

```python
open_=res=i=0
while i<len(s):
    c=s[i]; i+=1
    if c=='(': open_+=1
    else:
        if i<len(s) and s[i]==')': i+=1  # consume ))
        else: res+=1                      # insert )
        if open_>0: open_-=1
        else: res+=1                      # insert (
return res+open_*2
```

---

## 📊 Pattern Summary

| Problem | Pattern | Key |
|---------|---------|-----|
| Queue using Stacks | 2 stacks + lazy transfer | Amortised O(1) |
| Game of Two Stacks | Greedy two pointer | Try add B, remove A if needed |
| Largest Rectangle | Monotonic increasing stack | Pop when smaller, compute width |
| Valid Parentheses | Bracket matching stack | Push open, pop+match on close |
| Min Add Valid | Implicit counter | open + close unmatched |
| Min Insertions | Pair consumption | ( needs )), track pair and single ) |

---

## ✅ Checklist Before You Sleep

- [ ] Queue using Stacks: lazy transfer, amortised O(1)
- [ ] Largest Rectangle: monotonic stack, sentinel 0, width formula
- [ ] Valid Parentheses: classic stack matching
- [ ] Min Add (LC #921): track open + close, answer = sum
- [ ] Min Insertions (LC #1541): ( needs )) — pair consumption pattern
- [ ] Solved all 6 problems

---

## 💬 Community

Largest Rectangle in Histogram is one of the hardest stack problems. Drop a comment if the trace helped — or if you figured it out a different way.

**Solved all 6? Drop a 🔥 in the community.**

---

*Next up → Day 35: Binary Trees — Introduction, BFS, DFS*
