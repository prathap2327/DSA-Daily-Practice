# Day 8 — Linear Search

> **DSA Partner Challenge** | Week 2: Searching + Arrays

---

## 📌 Topic of the Day

**Linear Search — scan every element. Simple. Honest. Effective.**

The most straightforward search algorithm. No sorting needed. Traverse the array element by element until you find what you're looking for — or confirm it's not there.

---

## 🎥 Resources

| Language | Resource |
|----------|----------|
| ☕ Java | [Linear Search Tutorial](https://youtu.be/_HRA37X8N_Q?si=fN1FOBgQRf-4Fp4m) |
| 🐍 Python | CampusX — Python for AI playlist |
| ⚙️ C++ | Striver A2Z DSA Sheet — Searching section |

---

## 🧠 What to Learn Today

### Linear Search — Core Concept

- Traverse the array from left to right
- Compare each element to the target
- Return index when found, `-1` if not found
- **Time:** O(n) | **Space:** O(1)
- Works on **unsorted** arrays — no sorting required

### When to Use
- Array is unsorted (binary search needs sorted)
- Array is small
- Searching for ALL occurrences
- Searching a linked list (must traverse anyway)

---

### Java

```java
// Return first occurrence
public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++)
        if (arr[i] == target) return i;
    return -1;
}

// Return ALL occurrences
public static ArrayList<Integer> searchAll(int[] arr, int target) {
    ArrayList<Integer> indices = new ArrayList<>();
    for (int i = 0; i < arr.length; i++)
        if (arr[i] == target) indices.add(i);
    return indices;
}

// Search in 2D array
public static int[] search2D(int[][] matrix, int target) {
    for (int i = 0; i < matrix.length; i++)
        for (int j = 0; j < matrix[i].length; j++)
            if (matrix[i][j] == target) return new int[]{i, j};
    return new int[]{-1, -1};
}
```

> ⚠️ String comparison: always use `.equals()` not `==` in Java

---

### Python

```python
def linear_search(arr, target):
    for i, val in enumerate(arr):
        if val == target:
            return i
    return -1

# Python built-ins
5 in arr             # check if exists
arr.index(14)        # get index (raises ValueError if not found)
arr.index(99) if 99 in arr else -1   # safe version

# All occurrences
def search_all(arr, target):
    return [i for i, val in enumerate(arr) if val == target]
```

---

### C++

```cpp
// Basic
int linearSearch(vector<int>& arr, int target) {
    for (int i = 0; i < arr.size(); i++)
        if (arr[i] == target) return i;
    return -1;
}

// Using STL
auto it = find(arr.begin(), arr.end(), target);
if (it != arr.end())
    cout << distance(arr.begin(), it);   // index
```

---

### Complexity Summary

| Case | Time | Space |
|------|------|-------|
| Best | O(1) | O(1) |
| Average | O(n) | O(1) |
| Worst | O(n) | O(1) |

> 💡 **Linear vs Binary:** For n=1,000,000 — Linear = up to 1M steps. Binary = up to 20 steps. We cover Binary Search on Day 9.

---

## 💻 LeetCode Practice — 10 Problems

All problems this week are on LeetCode. Open each one, read the examples, then code.

---

**Q1. Build Array from Permutation** — [LC #1920](https://leetcode.com/problems/build-array-from-permutation/) `Easy`
> `ans[i] = nums[nums[i]]` for each index i
> ```python
> return [nums[nums[i]] for i in range(len(nums))]
> ```

---

**Q2. Concatenation of Array** — [LC #1929](https://leetcode.com/problems/concatenation-of-array/) `Easy`
> Return array of length 2n where second half is a copy of first half
> ```python
> return nums + nums
> ```

---

**Q3. Running Sum of 1D Array** — [LC #1480](https://leetcode.com/problems/running-sum-of-1d-array/) `Easy`
> `runningSum[i] = sum(nums[0]...nums[i])`
> ```python
> for i in range(1, len(nums)): nums[i] += nums[i-1]
> return nums
> ```

---

**Q4. Richest Customer Wealth** — [LC #1672](https://leetcode.com/problems/richest-customer-wealth/) `Easy`
> Sum each row (customer), return the maximum sum
> ```python
> return max(sum(row) for row in accounts)
> ```

---

**Q5. Shuffle the Array** — [LC #1470](https://leetcode.com/problems/shuffle-the-array/) `Easy`
> Interleave first half and second half: [x1,y1,x2,y2...]
> ```python
> return [val for i in range(n) for val in (nums[i], nums[i+n])]
> ```

---

**Q6. Kids With the Greatest Number of Candies** — [LC #1431](https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/) `Easy`
> Find max, then check if `candies[i] + extraCandies >= max`
> ```python
> m = max(candies)
> return [c + extraCandies >= m for c in candies]
> ```

---

**Q7. Number of Good Pairs** — [LC #1512](https://leetcode.com/problems/number-of-good-pairs/) `Easy`
> Count pairs (i,j) where `nums[i] == nums[j]` and `i < j`
> Use frequency map — when you see a number for the kth time, it creates k-1 new pairs
> ```python
> count, freq = 0, {}
> for n in nums:
>     count += freq.get(n, 0)
>     freq[n] = freq.get(n, 0) + 1
> return count
> ```

---

**Q8. How Many Numbers Are Smaller Than the Current Number** — [LC #1365](https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/) `Easy`
> Sort a copy. Index in sorted array = count of smaller numbers.
> ```python
> s = sorted(nums)
> return [s.index(n) for n in nums]
> ```

---

**Q9. Create Target Array in the Given Order** — [LC #1389](https://leetcode.com/problems/create-target-array-in-the-given-order/) `Easy`
> Insert `nums[i]` at position `index[i]` into target list sequentially
> ```python
> target = []
> for i in range(len(nums)): target.insert(index[i], nums[i])
> return target
> ```

---

**Q10. Check if the Sentence Is Pangram** — [LC #1832](https://leetcode.com/problems/check-if-the-sentence-is-pangram/) `Easy`
> A pangram contains all 26 letters. Use a set to count unique letters.
> ```python
> return len(set(sentence)) == 26
> ```

---

## ✅ Checklist Before You Sleep

- [ ] I understand linear search — O(n) time, O(1) space
- [ ] I can find first occurrence, all occurrences, and search in 2D arrays
- [ ] I know `.equals()` for String comparison in Java
- [ ] I solved all 10 LeetCode problems
- [ ] I understand the approach behind each problem (not just the code)
- [ ] I know when to use linear vs binary search

---

## 💬 Community

Solved a problem in an interesting way? Share the approach in the community.

**Solved all 10? Drop a 🔥 in the community.**

---

*Next up → Day 9: Binary Search — O(log n) on sorted arrays*
