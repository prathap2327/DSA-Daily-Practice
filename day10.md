# Day 10 — Binary Search on 2D Arrays

> **DSA Partner Challenge** | Week 2: Searching + Arrays

---

## 📌 Topic of the Day

**Binary Search on 2D Arrays — flatten the matrix. One index rules them all.**

A sorted m×n matrix is just a sorted 1D array in disguise. Once you know the index mapping, binary search works identically.

---

## 🎥 Resource

| Language | Resource |
|----------|----------|
| ☕ Java | [Binary Search on 2D Arrays](https://youtu.be/enI_KyGLYPo?si=Gf-AbUxr3qVvjl6K) |
| 🐍 Python | CampusX — Python for AI playlist |
| ⚙️ C++ | Striver A2Z DSA Sheet — Binary Search on 2D Arrays |

---

## 🧠 What to Learn Today

### The Core Idea

Treat the m×n sorted matrix as a flat array of size m×n:

```
flat index mid  →  row = mid / cols   (integer division)
                   col = mid % cols   (remainder)
```

**Java/C++:** `matrix[mid/n][mid%n]`
**Python:** `matrix[mid//n][mid%n]`

**Search space:** `low = 0`, `high = m*n - 1`

---

### Two Types of Sorted Matrix

**Type 1 (LC #74)** — Fully sorted: each row sorted + first of row[i+1] > last of row[i]
→ Treat as 1D flat array. One binary search. O(log(m×n)).

**Type 2 (LC #240)** — Row + column sorted (weaker condition)
→ Staircase search from top-right corner. O(m+n).

---

### Type 1 — Flat Binary Search

```java
// Java
public boolean searchMatrix(int[][] matrix, int target) {
    int m=matrix.length, n=matrix[0].length;
    int lo=0, hi=m*n-1;
    while (lo<=hi) {
        int mid=lo+(hi-lo)/2;
        int val=matrix[mid/n][mid%n];   // ← key conversion
        if      (val==target) return true;
        else if (val<target)  lo=mid+1;
        else                  hi=mid-1;
    }
    return false;
}
```

```python
# Python
def searchMatrix(self, matrix, target):
    m, n = len(matrix), len(matrix[0])
    lo, hi = 0, m*n-1
    while lo<=hi:
        mid=(lo+hi)//2
        val=matrix[mid//n][mid%n]
        if val==target: return True
        elif val<target: lo=mid+1
        else: hi=mid-1
    return False
```

---

### Type 2 — Staircase Search (Top-Right)

```java
// Start top-right: row=0, col=n-1
// val > target → col--   (eliminate column)
// val < target → row++   (eliminate row)
public boolean searchMatrixII(int[][] matrix, int target) {
    int row=0, col=matrix[0].length-1;
    while (row<matrix.length && col>=0) {
        if      (matrix[row][col]==target) return true;
        else if (matrix[row][col]>target)  col--;
        else                               row++;
    }
    return false;
}
```

```python
def searchMatrixII(self, matrix, target):
    row, col = 0, len(matrix[0])-1
    while row<len(matrix) and col>=0:
        if   matrix[row][col]==target: return True
        elif matrix[row][col]>target:  col-=1
        else:                          row+=1
    return False
```

---

## 💻 LeetCode Practice — 11 Problems

---

**Q1. Valid Perfect Square** — [LC #367](https://leetcode.com/problems/valid-perfect-square/) `Easy`
> Binary search: find `mid` where `mid*mid == num`. Use `long` to avoid overflow.

---

**Q2. Arranging Coins** — [LC #441](https://leetcode.com/problems/arranging-coins/) `Easy`
> Find largest `k` where `k*(k+1)/2 <= n`. Binary search with answer tracking.

---

**Q3. Find Smallest Letter Greater Than Target** — [LC #744](https://leetcode.com/problems/find-smallest-letter-greater-than-target/) `Easy`
> `bisect_right(letters, target)`. Modulo wraps around if target >= all letters.
```python
return letters[bisect.bisect_right(letters, target) % len(letters)]
```

---

**Q4. Kth Missing Positive Number** — [LC #1539](https://leetcode.com/problems/kth-missing-positive-number/) `Easy`
> At index `i`, missing count = `arr[i] - (i+1)`. Binary search for first index where missing ≥ k.
> Answer = `lo + k`.

---

**Q5. Search Insert Position** — [LC #35](https://leetcode.com/problems/search-insert-position/) `Easy`
> Standard binary search. When loop ends, `lo` is the insertion point.
```python
return bisect.bisect_left(nums, target)
```

---

**Q6. Peak Index in a Mountain Array** — [LC #852](https://leetcode.com/problems/peak-index-in-a-mountain-array/) `Medium`
> `arr[mid] < arr[mid+1]` → ascending → peak is right (`lo=mid+1`)
> else → descending → peak is left or at mid (`hi=mid`)

---

**Q7. Count Negative Numbers in a Sorted Matrix** — [LC #1351](https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/) `Easy`
> Binary search per row for first negative. Count = `row.length - first_neg_index`.
> Or staircase from bottom-left: O(m+n).

---

**Q8. Intersection of Two Arrays** — [LC #349](https://leetcode.com/problems/intersection-of-two-arrays/) `Easy`
> Unique elements in both. Use sets.
```python
return list(set(nums1) & set(nums2))
```

---

**Q9. Intersection of Two Arrays II** — [LC #350](https://leetcode.com/problems/intersection-of-two-arrays-ii/) `Easy`
> Elements with multiplicity. Use frequency map (Counter).
> **Key difference from Q8:** `[2,2] ∩ [2,2] = [2,2]` here, not `[2]`.

---

**Q10. Fair Candy Swap** — [LC #888](https://leetcode.com/problems/fair-candy-swap/) `Easy`
> `diff = (sumA - sumB) / 2`. For each `a` in A, check if `a - diff` exists in set(B).
```python
diff=(sum(a)-sum(b))//2; sb=set(b)
return [[x,x-diff] for x in a if x-diff in sb][0]
```

---

**Q11. Check If N and Its Double Exist** — [LC #1346](https://leetcode.com/problems/check-if-n-and-its-double-exist/) `Easy`
> Use a set. For each `n`, check if `2*n` or `n//2` (if even) already seen. Add AFTER checking (handles zeros).

---

## ✅ Checklist Before You Sleep

- [ ] I know the flat index formula: `row = mid/cols`, `col = mid%cols`
- [ ] I can implement binary search on a fully sorted 2D matrix (Type 1)
- [ ] I know the staircase search for Type 2 (start top-right or bottom-left)
- [ ] I solved Valid Perfect Square and Arranging Coins using binary search
- [ ] I know `lo` is the insertion point when binary search ends without finding (Q5)
- [ ] I know the peak finding pattern: `arr[mid] < arr[mid+1]` → go right
- [ ] I understand the difference between Intersection I and II
- [ ] Solved all 11 LeetCode problems

---

## 💬 Community

The Kth Missing Positive (Q4) is the trickiest one today — `lo+k` at the end. Share your trace in the community if you get it.

**Solved all 11? Drop a 🔥 in the community.**

---

*Next up → Day 11: Sorting Algorithms — Bubble Sort, Selection Sort, Insertion Sort*
