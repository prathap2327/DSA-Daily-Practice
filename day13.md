# Day 13 — Cycle Sort

> **DSA Partner Challenge** | Week 2: Sorting Algorithms

---

## 📌 Topic of the Day

**Cycle Sort — asked at Amazon, Google, and Microsoft.**

One algorithm. One formula. Six LeetCode problems — all solved with the same pattern.

---

## 🎥 Resource

[Cycle Sort — Amazon, Google, Microsoft Interview Questions (Kunal Kushwaha)](https://youtu.be/JfinxytTYFQ?si=pA_1S3XUueZ0BrY5)

> Watch the full video. All 6 problems are explained in it. These notes are your reference after watching.

---

## 🧠 What is Cycle Sort?

Cycle Sort is a comparison-based, in-place sorting algorithm designed specifically for arrays where elements are in a **known range** — typically `[1, n]` or `[0, n]`.

**When to use it:**
- Array contains integers in range `[1, n]` or `[0, n]`
- You need to find missing, duplicate, or misplaced numbers
- O(n) time and O(1) space is required

---

## 🔑 The Core Formula

```
correctIndex = arr[i] - 1      →      arr[i] belongs at index arr[i]-1
```

**Algorithm:**
```
i = 0
while i < n:
    correctIndex = arr[i] - 1
    if arr[i] != arr[correctIndex]:    ← not in its right place AND no duplicate conflict
        swap arr[i] with arr[correctIndex]
    else:
        i++                             ← already correct OR duplicate, move on
```

After Cycle Sort, every element `x` sits at index `x-1`.

---

## 🔍 Visual Trace — `[3, 5, 2, 1, 4]`

| Step | Array | Action |
|------|-------|--------|
| i=0 | `[3, 5, 2, 1, 4]` | arr[0]=3 → correct idx=2. arr[2]=2≠3 → swap(0,2) |
| i=0 | `[2, 5, 3, 1, 4]` | arr[0]=2 → correct idx=1. arr[1]=5≠2 → swap(0,1) |
| i=0 | `[5, 2, 3, 1, 4]` | arr[0]=5 → correct idx=4. arr[4]=4≠5 → swap(0,4) |
| i=0 | `[4, 2, 3, 1, 5]` | arr[0]=4 → correct idx=3. arr[3]=1≠4 → swap(0,3) |
| i=0 | `[1, 2, 3, 4, 5]` | arr[0]=1 → correct idx=0. Match → i++ |
| Done | `[1, 2, 3, 4, 5]` | Sorted ✓ |

---

## 💻 Cycle Sort Implementation

### Java

```java
public static void cycleSort(int[] arr) {
    int i = 0;
    while (i < arr.length) {
        int correctIndex = arr[i] - 1;
        if (arr[i] != arr[correctIndex]) {
            // swap arr[i] with arr[correctIndex]
            int temp = arr[i];
            arr[i] = arr[correctIndex];
            arr[correctIndex] = temp;
        } else {
            i++;
        }
    }
}
```

### Python

```python
def cycle_sort(arr):
    i = 0
    while i < len(arr):
        correct = arr[i] - 1
        if arr[i] != arr[correct]:
            arr[i], arr[correct] = arr[correct], arr[i]
        else:
            i += 1
    return arr
```

### C++

```cpp
void cycleSort(vector<int>& arr) {
    int i = 0;
    while (i < arr.size()) {
        int correct = arr[i] - 1;
        if (arr[i] != arr[correct])
            swap(arr[i], arr[correct]);
        else
            i++;
    }
}
```

> **Complexity:** O(n) time | O(1) space | Not stable

---

## 💻 LeetCode Problems — All 6 From the Video

---

### Q1. Missing Number — [LC #268](https://leetcode.com/problems/missing-number/) `Easy`

Given array `[0..n]` with one number missing. Find it.

> **Cycle Sort approach:** Range is `[0, n]`, so `correctIndex = arr[i]` (0-indexed). After sort, first position where `arr[i] != i` is missing.

```java
public int missingNumber(int[] nums) {
    int i = 0;
    while (i < nums.length) {
        int correct = nums[i];
        if (nums[i] < nums.length && nums[i] != nums[correct])
            { int t=nums[i]; nums[i]=nums[correct]; nums[correct]=t; }
        else i++;
    }
    for (int j=0; j<nums.length; j++)
        if (nums[j] != j) return j;
    return nums.length;
}
```

```python
def missingNumber(self, nums):
    i = 0
    while i < len(nums):
        correct = nums[i]
        if nums[i] < len(nums) and nums[i] != nums[correct]:
            nums[i], nums[correct] = nums[correct], nums[i]
        else:
            i += 1
    for i, n in enumerate(nums):
        if n != i: return i
    return len(nums)
```

---

### Q2. Find All Numbers Disappeared in an Array — [LC #448](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/) `Easy`

Array of n integers in `[1,n]`. Some appear twice, some missing. Return all missing numbers.

```java
public List<Integer> findDisappearedNumbers(int[] nums) {
    int i = 0;
    while (i < nums.length) {
        int correct = nums[i] - 1;
        if (nums[i] != nums[correct])
            { int t=nums[i]; nums[i]=nums[correct]; nums[correct]=t; }
        else i++;
    }
    List<Integer> result = new ArrayList<>();
    for (int j=0; j<nums.length; j++)
        if (nums[j] != j+1) result.add(j+1);
    return result;
}
```

```python
def findDisappearedNumbers(self, nums):
    i = 0
    while i < len(nums):
        correct = nums[i] - 1
        if nums[i] != nums[correct]:
            nums[i], nums[correct] = nums[correct], nums[i]
        else:
            i += 1
    return [i+1 for i, n in enumerate(nums) if n != i+1]
```

---

### Q3. Find the Duplicate Number — [LC #287](https://leetcode.com/problems/find-the-duplicate-number/) `Medium`

Array of `n+1` integers, all in `[1,n]`. One duplicate. O(n) time, O(1) space.

```java
public int findDuplicate(int[] nums) {
    int i = 0;
    while (i < nums.length) {
        if (nums[i] != i+1) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct])
                { int t=nums[i]; nums[i]=nums[correct]; nums[correct]=t; }
            else return nums[i];  // duplicate found
        } else i++;
    }
    return -1;
}
```

```python
def findDuplicate(self, nums):
    i = 0
    while i < len(nums):
        if nums[i] != i + 1:
            correct = nums[i] - 1
            if nums[i] != nums[correct]:
                nums[i], nums[correct] = nums[correct], nums[i]
            else:
                return nums[i]
        else:
            i += 1
    return -1
```

---

### Q4. Find All Duplicates in an Array — [LC #442](https://leetcode.com/problems/find-all-duplicates-in-an-array/) `Medium`

After cycle sort, any position where `nums[i] != i+1` holds a duplicate.

```java
public List<Integer> findDuplicates(int[] nums) {
    int i = 0;
    while (i < nums.length) {
        int correct = nums[i] - 1;
        if (nums[i] != nums[correct])
            { int t=nums[i]; nums[i]=nums[correct]; nums[correct]=t; }
        else i++;
    }
    List<Integer> result = new ArrayList<>();
    for (int j=0; j<nums.length; j++)
        if (nums[j] != j+1) result.add(nums[j]);
    return result;
}
```

```python
def findDuplicates(self, nums):
    i = 0
    while i < len(nums):
        correct = nums[i] - 1
        if nums[i] != nums[correct]:
            nums[i], nums[correct] = nums[correct], nums[i]
        else:
            i += 1
    return [nums[i] for i in range(len(nums)) if nums[i] != i+1]
```

---

### Q5. Set Mismatch — [LC #645](https://leetcode.com/problems/set-mismatch/) `Easy`

One number appears twice, one is missing. Return `[duplicate, missing]`.

```java
public int[] findErrorNums(int[] nums) {
    int i = 0;
    while (i < nums.length) {
        int correct = nums[i] - 1;
        if (nums[i] != nums[correct])
            { int t=nums[i]; nums[i]=nums[correct]; nums[correct]=t; }
        else i++;
    }
    for (int j=0; j<nums.length; j++)
        if (nums[j] != j+1) return new int[]{nums[j], j+1};
    return new int[]{-1,-1};
}
```

```python
def findErrorNums(self, nums):
    i = 0
    while i < len(nums):
        correct = nums[i] - 1
        if nums[i] != nums[correct]:
            nums[i], nums[correct] = nums[correct], nums[i]
        else:
            i += 1
    for i, n in enumerate(nums):
        if n != i+1: return [n, i+1]
```

---

### Q6. First Missing Positive — [LC #41](https://leetcode.com/problems/first-missing-positive/) `Hard`

Find the smallest missing positive integer. O(n) time, O(1) space.

> **Key difference:** Ignore values ≤ 0 or > n. Only place values in `[1, n]`.

```java
public int firstMissingPositive(int[] nums) {
    int i = 0, n = nums.length;
    while (i < n) {
        int correct = nums[i] - 1;
        if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correct])
            { int t=nums[i]; nums[i]=nums[correct]; nums[correct]=t; }
        else i++;
    }
    for (int j=0; j<n; j++)
        if (nums[j] != j+1) return j+1;
    return n+1;
}
```

```python
def firstMissingPositive(self, nums):
    i, n = 0, len(nums)
    while i < n:
        correct = nums[i] - 1
        if 0 < nums[i] <= n and nums[i] != nums[correct]:
            nums[i], nums[correct] = nums[correct], nums[i]
        else:
            i += 1
    for i, num in enumerate(nums):
        if num != i+1: return i+1
    return n+1
```

> Why Hard? The range is unknown and may include negatives — you must filter to `[1, n]` before placing.

---

## 🧠 The Cycle Sort Template (Memorise This)

```
i = 0
while i < n:
    correct = nums[i] - 1                          ← where nums[i] BELONGS
    if valid(nums[i]) and nums[i] != nums[correct]: ← not in place AND no conflict
        swap(nums[i], nums[correct])
    else:
        i++                                         ← already correct or skip

# After sort: scan for nums[i] != i+1 → that's your answer
```

**Valid condition varies by problem:**
- `[1,n]` range: always valid (Q1 through Q5 except missing)
- `[0,n]` range: `nums[i] < n` (Q1 Missing Number)  
- Unknown range: `0 < nums[i] <= n` (Q6 First Missing Positive)

---

## ✅ Checklist Before You Sleep

- [ ] I understand why `correctIndex = arr[i] - 1`
- [ ] I can write Cycle Sort from memory
- [ ] I know to check `arr[i] != arr[correctIndex]` before swapping (handles duplicates)
- [ ] I solved all 6 problems
- [ ] I know the valid condition changes for 0-indexed (Missing Number) and unknown range (First Missing Positive)
- [ ] I understand why Q6 (First Missing Positive) is Hard — filtering out-of-range values

---

## 💬 Community

If you solved First Missing Positive — share how long it took to click. Drop 🔥 in the community.

---

*Next up → Day 14: Strings — How they work, StringBuilder, and pattern problems*
