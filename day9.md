# Day 9 — Binary Search

> **DSA Partner Challenge** | Week 2: Searching + Arrays

---

## 📌 Topic of the Day

**Binary Search — sorted array, half the search space every single step.**

Linear Search: up to 1,000,000 steps for n=1M.
Binary Search: up to **20 steps** for n=1M.

That's the power of O(log n).

---

## 🎥 Resources

| Language | Resource |
|----------|----------|
| ☕ Java | [Binary Search Tutorial](https://youtu.be/f6UU7V3szVw?si=qECc9qTyv6txxssA) |
| 🐍 Python | CampusX — Python for AI playlist |
| ⚙️ C++ | Striver A2Z DSA Sheet — Binary Search section |

---

## 🧠 What to Learn Today

### Core Concept

- **Requires:** array must be SORTED
- **Time:** O(log n) | **Space:** O(1) iterative, O(log n) recursive
- Each step eliminates HALF the remaining elements
- Three cases: found (==), go right (>), go left (<)

### The Algorithm

```
low = 0, high = n-1
while low <= high:
    mid = low + (high - low) / 2    ← NOT (low+high)/2 — overflow risk!
    if arr[mid] == target → return mid
    if arr[mid] < target  → low = mid + 1   (go right)
    if arr[mid] > target  → high = mid - 1  (go left)
return -1
```

> ⚠️ Always use `mid = low + (high-low)/2` — `(low+high)/2` can overflow int in Java/C++ for large values.

---

### Trace Example — Find 23 in [2,5,8,12,16,23,38,56,72,91]

| Step | low | high | mid (arr[mid]) | Decision |
|------|-----|------|----------------|----------|
| 1 | 0 | 9 | 4 (16) | 16 < 23 → low = 5 |
| 2 | 5 | 9 | 7 (56) | 56 > 23 → high = 6 |
| 3 | 5 | 6 | 5 (23) | Found at index 5 ✓ |

---

### Java

```java
// Iterative (preferred)
public static int binarySearch(int[] arr, int target) {
    int low = 0, high = arr.length - 1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if      (arr[mid] == target) return mid;
        else if (arr[mid] <  target) low  = mid + 1;
        else                         high = mid - 1;
    }
    return -1;
}

// Find FIRST occurrence — go left when found
public static int firstOccurrence(int[] arr, int target) {
    int low=0, high=arr.length-1, result=-1;
    while (low<=high) {
        int mid=low+(high-low)/2;
        if (arr[mid]==target) { result=mid; high=mid-1; }  // save, keep going left
        else if (arr[mid]<target) low=mid+1;
        else high=mid-1;
    }
    return result;
}

// Find LAST occurrence — go right when found
public static int lastOccurrence(int[] arr, int target) {
    int low=0, high=arr.length-1, result=-1;
    while (low<=high) {
        int mid=low+(high-low)/2;
        if (arr[mid]==target) { result=mid; low=mid+1; }   // save, keep going right
        else if (arr[mid]<target) low=mid+1;
        else high=mid-1;
    }
    return result;
}
```

---

### Python

```python
def binary_search(arr, target):
    low, high = 0, len(arr) - 1
    while low <= high:
        mid = low + (high - low) // 2
        if   arr[mid] == target: return mid
        elif arr[mid] <  target: low  = mid + 1
        else:                    high = mid - 1
    return -1

# Built-in: bisect
import bisect
bisect.bisect_left(arr, target)   # first position >= target
bisect.bisect_right(arr, target)  # first position > target
```

---

### C++

```cpp
int binarySearch(vector<int>& arr, int target) {
    int low=0, high=arr.size()-1;
    while (low<=high) {
        int mid=low+(high-low)/2;
        if      (arr[mid]==target) return mid;
        else if (arr[mid]<target)  low=mid+1;
        else                       high=mid-1;
    }
    return -1;
}

// STL
binary_search(v.begin(), v.end(), x);  // true/false
lower_bound(v.begin(), v.end(), x);    // iterator to first >= x
upper_bound(v.begin(), v.end(), x);    // iterator to first > x
```

---

### Linear vs Binary Search

| Feature | Linear | Binary |
|---------|--------|--------|
| Time | O(n) | O(log n) |
| Requires sorted | No | Yes |
| n = 1,000,000 | ~1M steps | ~20 steps |
| Works on linked list | Yes | No |

---

## 💻 LeetCode Practice — 9 Problems

---

**Q1. Spiral Matrix** — [LC #54](https://leetcode.com/problems/spiral-matrix/) `Medium`
> Use 4 boundaries: top, bottom, left, right. Peel one layer at a time (right → down → left → up).

**Q2. Set Matrix Zeroes** — [LC #73](https://leetcode.com/problems/set-matrix-zeroes/) `Medium`
> First pass: collect zero row/col indices. Second pass: zero them out. Don't mark while traversing!

**Q3. Product of Array Except Self** — [LC #238](https://leetcode.com/problems/product-of-array-except-self/) `Medium`
> `ans[i] = prefix_product[i] × suffix_product[i]`
> Left pass builds prefix. Right pass (backwards) multiplies suffix in. No division. O(n).

**Q4. Find First and Last Position of Element in Sorted Array** — [LC #34](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) `Medium`
> Two binary searches: one goes left when found (first), one goes right when found (last).
```python
from bisect import bisect_left, bisect_right
l = bisect_left(nums, target)
r = bisect_right(nums, target) - 1
return [l, r] if l <= r and nums[l] == target else [-1, -1]
```

**Q5. Rotate Array** — [LC #189](https://leetcode.com/problems/rotate-array/) `Medium`
> Reverse trick: reverse all → reverse [0..k-1] → reverse [k..n-1]
> Always do `k %= n` first to handle k > n.

**Q6. Sqrt(x)** — [LC #69](https://leetcode.com/problems/sqrtx/) `Easy`
> Binary search between 1 and x/2. Find largest `mid` where `mid*mid <= x`.
> Use `long` for `mid*mid` in Java to avoid overflow.

**Q7. Guess Number Higher or Lower** — [LC #374](https://leetcode.com/problems/guess-number-higher-or-lower/) `Easy`
> Classic binary search. `guess(mid)` returns 0 (correct), 1 (too low), -1 (too high).

**Q8. First Bad Version** — [LC #278](https://leetcode.com/problems/first-bad-version/) `Easy`
> Use `lo < hi`. If `isBadVersion(mid)` → `hi = mid` (mid could be first bad). Else `lo = mid+1`.
> When loop ends: `lo == hi` = first bad version.

**Q9. Two Sum II - Input Array Is Sorted** — [LC #167](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/) `Medium`
> Two pointer on sorted array: `lo=0, hi=n-1`. Sum < target → move lo right. Sum > target → move hi left.
> O(n) time, O(1) space. Return 1-indexed positions.

---

## ✅ Checklist Before You Sleep

- [ ] I know binary search needs a SORTED array
- [ ] I use `mid = low + (high-low)/2` — not `(low+high)/2`
- [ ] I can write iterative binary search from memory
- [ ] I understand the `lo < hi` vs `lo <= hi` distinction (First Bad Version)
- [ ] I can find first and last occurrence using modified binary search
- [ ] I solved all 9 LeetCode problems
- [ ] I understand why Two Pointer works on a sorted array (Q9)

---

## 💬 Community

Stuck on the prefix×suffix trick for Q3? Drop it in the community — it trips everyone up the first time.

**Solved all 9? Drop a 🔥 in the community.**

---

*Next up → Day 10: Sorting Algorithms — Bubble, Selection, Insertion Sort*
