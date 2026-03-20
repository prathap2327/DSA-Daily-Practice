# Day 11 — Binary Search Revision + Bubble Sort

> **DSA Partner Challenge** | Week 2: Searching + Sorting begins

---

## 📌 Topic of the Day : BUBBLE SORT AND BINARY SEARCH PROBLEMS

Two things today:
1. **Revise** — 5 harder binary search problems (rotated arrays, single element)
2. **Learn new** — Bubble Sort theory, code, and complexity in all 3 languages

---

## 🎥 Resources

| Topic | Resource |
|-------|----------|
| Bubble Sort (all languages) | [Tutorial](https://youtu.be/F5MZyqRp_IM?si=EldTc1x-if5E-P0r) |
| Binary Search revision | Day 9 & 10 notes |

---

## 🔁 Part 1 — Binary Search Revision

---

### Q1. Find First and Last Position of Element in Sorted Array — [LC #34](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) `Medium`

Two binary searches: first hunts left when found, second hunts right when found.

```python
from bisect import bisect_left, bisect_right
def searchRange(self, nums, target):
    l = bisect_left(nums, target)
    r = bisect_right(nums, target) - 1
    return [l, r] if l<=r and l<len(nums) and nums[l]==target else [-1,-1]
```

---

### Q2. Single Element in a Sorted Array — [LC #540](https://leetcode.com/problems/single-element-in-a-sorted-array/) `Medium`

Every element appears twice except one. O(log n), O(1) space.

**Key insight:** Before the single element, pairs sit at (even, odd) index pairs. Make mid even, then:
- `arr[mid] == arr[mid+1]` → single is to the **right** → `lo = mid+2`
- else → single is at mid or **left** → `hi = mid`

```java
public int singleNonDuplicate(int[] nums) {
    int lo=0, hi=nums.length-1;
    while (lo<hi) {
        int mid=lo+(hi-lo)/2;
        if (mid%2==1) mid--;           // keep mid even
        if (nums[mid]==nums[mid+1]) lo=mid+2;
        else hi=mid;
    }
    return nums[lo];
}
```

---

### Q3. Search in Rotated Sorted Array — [LC #33](https://leetcode.com/problems/search-in-rotated-sorted-array/) `Medium`

No duplicates. One half is ALWAYS sorted — figure out which, then decide which half holds the target.

```java
if (nums[lo] <= nums[mid]) {  // left half sorted
    if (nums[lo] <= target && target < nums[mid]) hi=mid-1;
    else lo=mid+1;
} else {                      // right half sorted
    if (nums[mid] < target && target <= nums[hi]) lo=mid+1;
    else hi=mid-1;
}
```

---

### Q4. Search in Rotated Sorted Array II — [LC #81](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/) `Medium`

Same as Q3 but MAY have duplicates. Extra case: if `arr[lo] == arr[mid] == arr[hi]` → can't determine sorted half → `lo++; hi--`.

> ⚠️ Worst case degrades to O(n) with duplicates (e.g. `[1,1,1,1,1]`).

---

### Q5. Find Minimum in Rotated Sorted Array — [LC #153](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) `Medium`

The minimum is at the rotation pivot.

```java
if (nums[mid] > nums[hi]) lo = mid+1;  // min is in right half
else                        hi = mid;   // min is at mid or left
```

```python
def findMin(self, nums):
    lo, hi = 0, len(nums)-1
    while lo<hi:
        mid=(lo+hi)//2
        if nums[mid]>nums[hi]: lo=mid+1
        else: hi=mid
    return nums[lo]
```

> Compare `mid` to `hi`, NOT to `lo`. Comparing to `lo` fails because `arr[lo]` could itself be the minimum.

---

## 🫧 Part 2 — Bubble Sort

### How It Works

- Compare adjacent pairs `arr[j]` and `arr[j+1]`
- If `arr[j] > arr[j+1]` → swap them
- After each pass, the largest unsorted element "bubbles" to its correct position
- **Optimisation:** if no swap happens in a full pass → array is already sorted → stop early

### Visual Trace — `[64, 34, 25, 12, 22]`

| Pass | Array After | What happened |
|------|------------|---------------|
| 1 | `[34, 25, 12, 22, 64]` | 64 bubbled to end |
| 2 | `[25, 12, 22, 34, 64]` | 34 bubbled to position |
| 3 | `[12, 22, 25, 34, 64]` | 25 bubbled to position |
| 4 | `[12, 22, 25, 34, 64]` | No swaps → sorted! |

---

### Java

```java
// Basic
public static void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i=0; i<n-1; i++)
        for (int j=0; j<n-1-i; j++)
            if (arr[j] > arr[j+1]) {
                int t=arr[j]; arr[j]=arr[j+1]; arr[j+1]=t;
            }
}

// Optimised — early exit flag
public static void bubbleSortOpt(int[] arr) {
    int n = arr.length;
    for (int i=0; i<n-1; i++) {
        boolean swapped = false;
        for (int j=0; j<n-1-i; j++)
            if (arr[j] > arr[j+1]) {
                int t=arr[j]; arr[j]=arr[j+1]; arr[j+1]=t;
                swapped = true;
            }
        if (!swapped) break;    // sorted early!
    }
}
```

### Python

```python
def bubble_sort(arr):
    n = len(arr)
    for i in range(n-1):
        swapped = False
        for j in range(n-1-i):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]   # Python swap — no temp needed
                swapped = True
        if not swapped: break
    return arr
```

### C++

```cpp
void bubbleSort(vector<int>& arr) {
    int n = arr.size();
    for (int i=0; i<n-1; i++) {
        bool swapped = false;
        for (int j=0; j<n-1-i; j++)
            if (arr[j]>arr[j+1]) { swap(arr[j],arr[j+1]); swapped=true; }
        if (!swapped) break;
    }
}
```

---

### Complexity

| Case | Time | Space | Notes |
|------|------|-------|-------|
| Best | O(n) | O(1) | Already sorted — flag fires after 1 pass |
| Average | O(n²) | O(1) | |
| Worst | O(n²) | O(1) | Reverse sorted |
| Stable? | Yes | — | Equal elements keep original order |

### Sorting Algorithm Comparison (preview)

| Algorithm | Best | Worst | Stable |
|-----------|------|-------|--------|
| Bubble Sort | O(n) | O(n²) | ✅ |
| Selection Sort | O(n²) | O(n²) | ❌ |
| Insertion Sort | O(n) | O(n²) | ✅ |
| Merge Sort | O(n log n) | O(n log n) | ✅ |
| Quick Sort | O(n log n) | O(n²) | ❌ |

---

## ✅ Checklist Before You Sleep

- [ ] Solved all 5 binary search revision problems
- [ ] I understand why mid is kept even in Single Element (Q2)
- [ ] I can implement Search in Rotated Array — determine sorted half first
- [ ] I know the duplicate edge case in Rotated Array II (lo++, hi--)
- [ ] I know why we compare arr[mid] to arr[hi] in Find Minimum
- [ ] I can write Bubble Sort from memory in all 3 languages
- [ ] I understand the swapped flag and when it detects already-sorted input
- [ ] I know Bubble Sort is stable — and what stable means

---

## 💬 Community

The rotated array problems (Q3, Q4) are the trickiest binary search problems so far. If you're stuck, share where you're confused in the community.

**Solved all 5 + wrote Bubble Sort? Drop a 🔥 in the community.**

---

*Next up → Day 12: Selection Sort + Insertion Sort*
