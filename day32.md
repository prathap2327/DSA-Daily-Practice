# Day 32 — Linked List Interview Questions (FAANG Level)

> **DSA Partner Challenge** | Week 5

---

## 📌 Topic of the Day

**14 Linked List interview questions — from the video. Recursion · Cycle · Reversal · Merge Sort.**

---

## 🎥 Resource

[Solve Any Linked List Interview Question](https://youtu.be/70tx7KcMROc?si=9oGJJD_xaui1VMIm) — Kunal Kushwaha

---

## 🧠 The 4 Core Techniques

| Technique | When to use | Pattern |
|-----------|-------------|---------|
| Slow/Fast Pointer | Cycle, middle, kth from end | `slow=1 step, fast=2 steps` |
| In-place Reversal | Reverse LL, palindrome, reorder | `prev=null, curr=head, next=curr.next` |
| LL + Recursion | Insert sorted, remove dups | `base: null, recursive: f(node.next)` |
| Merge (D&C) | Sort LL, merge sorted | split → sort → merge |

---

## 💻 14 Interview Problems from the Video

---

### Q1. Recursive Insertion in Linked List `Easy`
```java
Node sortedInsert(Node head, int val) {
    if (head==null || head.data>=val) {
        Node n=new Node(val); n.next=head; return n;
    }
    head.next=sortedInsert(head.next, val);
    return head;
}
```

---

### Q2. Remove Duplicates from Sorted LL — [LC #83](https://leetcode.com/problems/remove-duplicates-from-sorted-list/) `Easy`
```java
ListNode curr=head;
while(curr!=null&&curr.next!=null) {
    if(curr.val==curr.next.val) curr.next=curr.next.next;
    else curr=curr.next;
}
return head;
```

---

### Q3. Merge Two Sorted Linked Lists — [LC #21](https://leetcode.com/problems/merge-two-sorted-lists/) `Easy`
```java
ListNode dummy=new ListNode(0), curr=dummy;
while(l1!=null&&l2!=null) {
    if(l1.val<=l2.val){ curr.next=l1; l1=l1.next; }
    else              { curr.next=l2; l2=l2.next; }
    curr=curr.next;
}
curr.next=(l1!=null)?l1:l2;
return dummy.next;
```
> **Dummy node pattern** — always use when building a new result list to avoid head-edge-case logic.

---

### Q4. Linked List Cycle — [LC #141](https://leetcode.com/problems/linked-list-cycle/) `Easy`
```java
ListNode slow=head, fast=head;
while(fast!=null&&fast.next!=null) {
    slow=slow.next; fast=fast.next.next;
    if(slow==fast) return true;
}
return false;
```

---

### Q5. Linked List Cycle II (find start) — [LC #142](https://leetcode.com/problems/linked-list-cycle-ii/) `Medium`

Phase 1: detect meeting point. Phase 2: move one pointer to head, advance both 1 step — they meet at cycle start.

```java
// Phase 1
while(fast!=null&&fast.next!=null){
    slow=slow.next; fast=fast.next.next;
    if(slow==fast) break;
}
if(fast==null||fast.next==null) return null;
// Phase 2
slow=head;
while(slow!=fast){ slow=slow.next; fast=fast.next; }
return slow;
```

---

### Q6. Happy Number — [LC #202](https://leetcode.com/problems/happy-number/) `Easy`

Cycle detection on the digit-square-sum sequence using Floyd's algorithm.

```python
def sq(x): return sum(int(d)**2 for d in str(x))
slow, fast = n, sq(n)
while fast!=1 and slow!=fast:
    slow=sq(slow); fast=sq(sq(fast))
return fast==1
```

---

### Q7. Sort List (Merge Sort on LL) — [LC #148](https://leetcode.com/problems/sort-list/) `Medium`

```java
ListNode sortList(ListNode head) {
    if(head==null||head.next==null) return head;
    ListNode mid=getMid(head), right=mid.next; mid.next=null;
    return mergeTwoLists(sortList(head), sortList(right));
}
// getMid: slow/fast pointer — returns left-mid
```

> Why Merge Sort (not Quick Sort)? Merge Sort only needs sequential access. Quick Sort needs random access for pivot swapping — O(n) per swap in LL.

---

### Q8. Reverse Linked List — [LC #206](https://leetcode.com/problems/reverse-linked-list/) `Easy`

**Iterative:**
```java
ListNode prev=null, curr=head;
while(curr!=null){ ListNode next=curr.next; curr.next=prev; prev=curr; curr=next; }
return prev;
```

**Recursive:**
```java
if(head==null||head.next==null) return head;
ListNode newHead=reverseList(head.next);
head.next.next=head; head.next=null;
return newHead;
```

---

### Q9. Reverse Linked List II — [LC #92](https://leetcode.com/problems/reverse-linked-list-ii/) `Medium`

Reverse nodes from position `left` to `right` in one pass.

```java
ListNode dummy=new ListNode(0); dummy.next=head;
ListNode prev=dummy;
for(int i=1;i<left;i++) prev=prev.next;
ListNode curr=prev.next;
for(int i=0;i<right-left;i++){
    ListNode next=curr.next; curr.next=next.next;
    next.next=prev.next; prev.next=next;
}
return dummy.next;
```

---

### Q10. Palindrome Linked List — [LC #234](https://leetcode.com/problems/palindrome-linked-list/) `Easy`

O(n) time, O(1) space: find mid → reverse second half → compare.

```python
# find mid
slow=fast=head
while fast and fast.next: slow=slow.next; fast=fast.next.next
# reverse second half
prev=None
while slow: nxt=slow.next;slow.next=prev;prev=slow;slow=nxt
# compare
l,r=head,prev
while r:
    if l.val!=r.val: return False
    l=l.next; r=r.next
return True
```

---

### Q11. Reorder List — [LC #143](https://leetcode.com/problems/reorder-list/) `Medium`

L0→Ln→L1→Ln-1→L2→Ln-2...  Three steps: find mid → reverse second half → merge alternately.

```python
# find mid
slow=fast=head
while fast.next and fast.next.next: slow=slow.next;fast=fast.next.next
# reverse second half
prev,curr=None,slow.next; slow.next=None
while curr: nxt=curr.next;curr.next=prev;prev=curr;curr=nxt
# merge alternately
first,second=head,prev
while second:
    t1,t2=first.next,second.next
    first.next=second; second.next=t1
    first,second=t1,t2
```

---

### Q12. Add Two Numbers — [LC #2](https://leetcode.com/problems/add-two-numbers/) `Medium`

```java
ListNode dummy=new ListNode(0), curr=dummy; int carry=0;
while(l1!=null||l2!=null||carry!=0){
    int sum=carry;
    if(l1!=null){sum+=l1.val;l1=l1.next;}
    if(l2!=null){sum+=l2.val;l2=l2.next;}
    carry=sum/10; curr.next=new ListNode(sum%10); curr=curr.next;
}
return dummy.next;
```

---

### Q13. Remove Nth Node From End — [LC #19](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) `Medium`

Move `fast` n+1 steps ahead. Then advance both. `slow.next` is the node to remove.

```java
ListNode dummy=new ListNode(0); dummy.next=head;
ListNode slow=dummy, fast=dummy;
for(int i=0;i<=n;i++) fast=fast.next;
while(fast!=null){ slow=slow.next; fast=fast.next; }
slow.next=slow.next.next;
return dummy.next;
```

---

### Q14. Middle of the Linked List — [LC #876](https://leetcode.com/problems/middle-of-the-linked-list/) `Easy`

```python
slow=fast=head
while fast and fast.next: slow=slow.next; fast=fast.next.next
return slow
```

---

## ✅ Checklist Before You Sleep

- [ ] Floyd's cycle detection: detect + find start node
- [ ] Reverse LL iteratively (3 pointers) and recursively
- [ ] Palindrome LL in O(1) space: find mid → reverse → compare
- [ ] Merge Sort on LL: find mid → split → sort halves → merge
- [ ] Dummy node pattern: use whenever building a new result list
- [ ] Remove nth from end: fast starts n+1 ahead
- [ ] Solved all 14 problems

---

## 💬 Community

The cycle detection + find start problem is the one that trips most people up. Solve Q5 and explain the math in the community.

**Solved all 14? Drop a 🔥 in the community.**

---

*Next up → Day 33: Linked List — Add Two Numbers II, Copy List with Random Pointer, LRU Cache*
