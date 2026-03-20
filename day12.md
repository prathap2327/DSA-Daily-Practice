# Day 12 — Selection Sort + Insertion Sort

> **DSA Partner Challenge** | Week 2: Sorting Algorithms

---

## 📌 Topic of the Day

Two sorting algorithms + 6 practice problems including two **classic Hard problems** that use Binary Search on the Answer.

---

## 🎥 Resources

| Topic | Resource |
|-------|----------|
| Selection Sort | [Tutorial](https://youtu.be/Nd4SCCIHFWk?si=Vro9OJsTPnm1FKce) |
| Insertion Sort | [Tutorial](https://youtu.be/By_5-RRqVeE?si=-MZB0A-WAT3EVzPj) |

---

## 🧠 Part 1 — Selection Sort

**Idea:** Find the minimum in the unsorted portion → swap it to the front of the unsorted section.

### Visual Trace — `[29, 64, 73, 34, 20]`

| Pass | Array After | What happened |
|------|------------|---------------|
| 1 | `[20, 64, 73, 34, 29]` | min=20, swap to idx 0 |
| 2 | `[20, 29, 73, 34, 64]` | min=29, swap to idx 1 |
| 3 | `[20, 29, 34, 73, 64]` | min=34, swap to idx 2 |
| 4 | `[20, 29, 34, 64, 73]` | min=64, swap to idx 3 |

### Code (all 3 languages)

```java
public static void selectionSort(int[] arr) {
    int n = arr.length;
    for (int i=0; i<n-1; i++) {
        int minIdx=i;
        for (int j=i+1; j<n; j++)
            if (arr[j]<arr[minIdx]) minIdx=j;
        int t=arr[i]; arr[i]=arr[minIdx]; arr[minIdx]=t;
    }
}
```

```python
def selection_sort(arr):
    for i in range(len(arr)-1):
        min_idx=i
        for j in range(i+1, len(arr)):
            if arr[j]<arr[min_idx]: min_idx=j
        arr[i], arr[min_idx] = arr[min_idx], arr[i]
    return arr
```

```cpp
void selectionSort(vector<int>& arr) {
    int n=arr.size();
    for (int i=0;i<n-1;i++) {
        int minIdx=i;
        for (int j=i+1;j<n;j++) if(arr[j]<arr[minIdx]) minIdx=j;
        swap(arr[i],arr[minIdx]);
    }
}
```

**Complexity:** O(n²) best/avg/worst | O(1) space | **NOT stable** | Exactly n-1 swaps

---

## 🧠 Part 2 — Insertion Sort

**Idea:** Pick the next element (key), shift larger sorted elements right, insert key in the gap.

### Visual Trace — `[12, 11, 13, 5, 6]`

| Pass | Key | Array After |
|------|-----|------------|
| 1 | 11 | `[11, 12, 13, 5, 6]` |
| 2 | 13 | `[11, 12, 13, 5, 6]` |
| 3 | 5  | `[5, 11, 12, 13, 6]` |
| 4 | 6  | `[5, 6, 11, 12, 13]` ✓ |

### Code (all 3 languages)

```java
public static void insertionSort(int[] arr) {
    for (int i=1; i<arr.length; i++) {
        int key=arr[i], j=i-1;
        while (j>=0 && arr[j]>key) { arr[j+1]=arr[j]; j--; }
        arr[j+1]=key;
    }
}
```

```python
def insertion_sort(arr):
    for i in range(1, len(arr)):
        key, j = arr[i], i-1
        while j>=0 and arr[j]>key:
            arr[j+1]=arr[j]; j-=1
        arr[j+1]=key
    return arr
```

```cpp
void insertionSort(vector<int>& arr) {
    for (int i=1;i<arr.size();i++) {
        int key=arr[i], j=i-1;
        while(j>=0 && arr[j]>key) { arr[j+1]=arr[j]; j--; }
        arr[j+1]=key;
    }
}
```

**Complexity:** O(n) best | O(n²) worst | O(1) space | **Stable** | Adaptive (fast on nearly-sorted)

---

## 📊 Sorting Algorithm Comparison

| Algorithm | Best | Worst | Space | Stable |
|-----------|------|-------|-------|--------|
| Bubble Sort | O(n) | O(n²) | O(1) | ✅ |
| Selection Sort | O(n²) | O(n²) | O(1) | ❌ |
| Insertion Sort | O(n) | O(n²) | O(1) | ✅ |
| Merge Sort | O(n log n) | O(n log n) | O(n) | ✅ |
| Quick Sort | O(n log n) | O(n²) | O(log n) | ❌ |

---

## 💻 Practice Problems

---

**Q1. Largest Number** — [LC #179](https://leetcode.com/problems/largest-number/) `Medium`
> Custom sort: compare `a+b` vs `b+a` as strings.
```python
from functools import cmp_to_key
strs.sort(key=cmp_to_key(lambda a,b: 1 if a+b < b+a else -1))
return '0' if strs[0]=='0' else ''.join(strs)
```

---

**Q2. Kth Largest Element in an Array** — [LC #215](https://leetcode.com/problems/kth-largest-element-in-an-array/) `Medium`
> Approach 1: sort, return `nums[n-k]`.
> Approach 2 (optimal): min-heap of size k — keep only k largest.
```python
import heapq
return heapq.nlargest(k, nums)[-1]
```

---

**Q3. Find the Duplicate Number** — [LC #287](https://leetcode.com/problems/find-the-duplicate-number/) `Medium`
> Floyd's cycle detection — treat array values as linked list pointers.
```java
int slow=nums[0], fast=nums[0];
do { slow=nums[slow]; fast=nums[nums[fast]]; } while(slow!=fast);
slow=nums[0];
while(slow!=fast) { slow=nums[slow]; fast=nums[fast]; }
return slow;
```

---

**Q4. Find All Duplicates in an Array** — [LC #442](https://leetcode.com/problems/find-all-duplicates-in-an-array/) `Medium`
> Use array as hash map: for each value v, negate `arr[v-1]`. If already negative → duplicate.
```python
for n in nums:
    idx=abs(n)-1
    if nums[idx]<0: result.append(idx+1)
    else: nums[idx]=-nums[idx]
```

---

**Q5. Aggressive Cows** — GFG / SPOJ `Hard`
> Place C cows in sorted stalls. Maximise the minimum distance between any two cows.
> **Binary Search on Answer:** search space = [1, max_stall - min_stall]
> Feasibility check: greedily place cows, count how many fit with min distance ≥ mid.

```python
def aggressive_cows(stalls, cows):
    stalls.sort()
    def can_place(d):
        count, last = 1, stalls[0]
        for s in stalls[1:]:
            if s-last>=d: count+=1; last=s
            if count>=cows: return True
        return False
    lo, hi, ans = 1, stalls[-1]-stalls[0], 0
    while lo<=hi:
        mid=(lo+hi)//2
        if can_place(mid): ans=mid; lo=mid+1
        else: hi=mid-1
    return ans
```

---

**Q6. Book Allocation** — GFG `Hard`
> Allocate n books to m students (contiguous). Minimise the maximum pages any student reads.
> **Binary Search on Answer:** search space = [max(pages), sum(pages)]
> Feasibility check: greedily assign books, count students needed for max ≤ mid.

```python
def book_allocation(pages, m):
    def students_needed(limit):
        s, cur = 1, 0
        for p in pages:
            if cur+p>limit: s+=1; cur=0
            cur+=p
        return s
    lo, hi, ans = max(pages), sum(pages), 0
    while lo<=hi:
        mid=(lo+hi)//2
        if students_needed(mid)<=m: ans=mid; hi=mid-1
        else: lo=mid+1
    return ans
```

> 💡 **Binary Search on Answer template** — search for the best valid value. Feasibility function is monotone. Same pattern: Painter's Partition, Koko Eating Bananas, Split Array Largest Sum.

---

## ✅ Checklist Before You Sleep

- [ ] I can write Selection Sort from memory (find min, swap to front)
- [ ] I know Selection Sort is NOT stable and always O(n²)
- [ ] I can write Insertion Sort (pick key, shift, insert)
- [ ] I know Insertion Sort IS stable and O(n) on nearly-sorted input
- [ ] I solved Largest Number with custom comparator
- [ ] I understand Floyd's cycle detection for Find Duplicate
- [ ] I understand the index-as-hashmap trick for Find All Duplicates
- [ ] I understand Binary Search on Answer and solved Aggressive Cows + Book Allocation

---

## 💬 Community

Aggressive Cows and Book Allocation are the first hard problems in the challenge. Share your feasibility function in the community if you get it.

**Solved all 6? Drop a 🔥 in the community.**

---

*Next up → Day 13: Merge Sort + Quick Sort — O(n log n) algorithms*
