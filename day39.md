# Day 39 — HashMap & HashTable in Java: Internal Working

> **DSA Partner Challenge** | Week 6

---

## 📌 Topic of the Day

**HashMap internals — how hashing, chaining, and rehashing really work under the hood.**

---

## 🎥 Resource

[Introduction to HashMap & HashTable in Java](https://youtu.be/XLbvmMz8Fr8?si=3QyISI8yOYaG9Ocl) — Kunal Kushwaha

---

## 🧠 Part 1 — What is Hashing?

```
index = hash(key) % capacity
```

Java's internal hash function: `hash(key) = key.hashCode() ^ (key.hashCode() >>> 16)` (bit spreading to reduce clustering).

**Good hash function:** deterministic + uniform distribution across buckets.

---

## 🧠 Part 2 — Internal Structure

HashMap = array of `Node` objects (buckets). Each `Node` stores: key, value, hashCode, next pointer.

```java
static class Node<K,V> {
    final int hash; final K key; V value; Node<K,V> next;
}
```

```
Bucket[0]: null
Bucket[1]: Node("apple",1) → Node("table",2) → null  ← collision!
Bucket[2]: null
Bucket[3]: Node("cat",3) → null
```

**Default capacity:** 16 buckets. **Default load factor:** 0.75.

### Java 8 Improvement — Linked List → Red-Black Tree
When a bucket accumulates **≥ 8 nodes** (TREEIFY_THRESHOLD), it converts from LinkedList to a Red-Black Tree. Worst case improves from O(n) → O(log n). Converts back at 6 nodes (UNTREEIFY_THRESHOLD).

---

## 🧠 Part 3 — put() and get()

**put(key, value):**
1. Compute `hash(key)`
2. `index = hash & (capacity-1)`
3. Empty bucket → create Node
4. Collision → traverse chain, update if key found, append if not
5. If size > `loadFactor * capacity` → **rehash**

**get(key):**
1. Compute `hash(key)` → find bucket
2. Traverse chain: check `hashCode` first (O(1)), then `equals()` confirms

> Compare hashCode first, equals second — hashCode is faster and filters most mismatches.

---

## 🧠 Part 4 — Collision Resolution

**Separate Chaining (Java's default):** each bucket holds a LinkedList (or RBTree in Java 8+).

**Open Addressing:**
- Linear Probing: `(hash + i) % cap`
- Quadratic Probing: `(hash + i²) % cap`
- Double Hashing: `(hash1 + i * hash2) % cap`

> Linear probing causes **primary clustering** — consecutive filled slots slow down lookups. Quadratic/double hashing mitigate this.

---

## 🧠 Part 5 — Load Factor & Rehashing

```
Default: capacity=16, loadFactor=0.75
Rehash when: size > 16 * 0.75 = 12 entries
Rehash: new array of 2x capacity → redistribute all entries
```

| Load Factor | Collisions | Memory | Speed |
|-------------|-----------|--------|-------|
| Low (0.5) | Fewer | More waste | Faster |
| High (1.0) | More | Less waste | Slower |
| 0.75 (default) | Balanced | Balanced | Balanced |

---

## 🧠 Part 6 — HashMap vs Hashtable vs LinkedHashMap vs TreeMap

| Feature | HashMap | Hashtable | LinkedHashMap | TreeMap |
|---------|---------|-----------|---------------|---------|
| Thread-safe | No | Yes (sync) | No | No |
| Null keys | 1 allowed | Not allowed | 1 allowed | Not allowed |
| Order | None | None | Insertion order | Sorted |
| Performance | O(1) avg | O(1) slower | O(1) avg | O(log n) |
| Use when | General | Thread safety | Maintain order | Sorted keys |

---

## 🧠 Part 7 — HashMap API

```java
map.put("a", 1);
map.get("a");                      // 1
map.getOrDefault("x", 0);          // 0
map.containsKey("a");              // true
map.remove("a");
map.putIfAbsent("a", 1);           // only inserts if absent
map.merge("a", 1, Integer::sum);   // frequency counting pattern
map.getOrDefault(key,0)+1          // most common pattern for counting
for(Map.Entry<K,V> e:map.entrySet()) ...
```

```python
d = {}
d['a'] = d.get('a', 0) + 1        # frequency counting
from collections import defaultdict
d = defaultdict(int)               # auto 0 for new keys
from collections import Counter
Counter(arr)                       # instant frequency map
```

---

## 💻 Practice Problems — 3 Questions

---

### Q1. Two Sum — [LC #1](https://leetcode.com/problems/two-sum/) `Easy`

**One-pass HashMap:** for each number, check if `target - num` is already in the map.

```java
Map<Integer,Integer> map=new HashMap<>();
for(int i=0;i<nums.length;i++){
    int comp=target-nums[i];
    if(map.containsKey(comp)) return new int[]{map.get(comp),i};
    map.put(nums[i],i);
}
```

```python
seen={}
for i,n in enumerate(nums):
    if target-n in seen: return [seen[target-n], i]
    seen[n]=i
```

> Brute force: O(n²). HashMap: O(n) — the classic hash map trade-off.

---

### Q2. Group Anagrams — [LC #49](https://leetcode.com/problems/group-anagrams/) `Medium`

Sort each string → use sorted string as canonical key.

```java
Map<String,List<String>> map=new HashMap<>();
for(String s:strs){
    char[] c=s.toCharArray(); Arrays.sort(c);
    map.computeIfAbsent(new String(c),k->new ArrayList<>()).add(s);
}
return new ArrayList<>(map.values());
```

```python
from collections import defaultdict
d=defaultdict(list)
for s in strs:
    d[''.join(sorted(s))].append(s)
return list(d.values())
```

**Trace:** `["eat","tea","tan","ate","nat","bat"]`
```
"eat" → "aet" → map["aet"] = ["eat"]
"tea" → "aet" → map["aet"] = ["eat","tea","ate"]
"tan" → "ant" → map["ant"] = ["tan","nat"]
"bat" → "abt" → map["abt"] = ["bat"]
```

---

### Q3. Longest Consecutive Sequence — [LC #128](https://leetcode.com/problems/longest-consecutive-sequence/) `Medium`

Put all numbers in HashSet. Only start counting when `n-1 NOT in set` (sequence start). Count forward.

```java
Set<Integer> set=new HashSet<>();
for(int n:nums) set.add(n);
int maxLen=0;
for(int n:set){
    if(!set.contains(n-1)){          // sequence start
        int curr=n, len=1;
        while(set.contains(curr+1)){ curr++; len++; }
        maxLen=Math.max(maxLen,len);
    }
}
return maxLen;
```

```python
s=set(nums)
best=0
for n in s:
    if n-1 not in s:
        curr,length=n,1
        while curr+1 in s: curr+=1; length+=1
        best=max(best,length)
return best
```

> O(n): each number is visited at most twice. Key: only start counting from sequence starts to avoid O(n²).

---

## ✅ Checklist Before You Sleep

- [ ] HashMap = array of buckets + linked list / RBTree per bucket
- [ ] hash(key) % capacity → bucket index
- [ ] Java 8: ≥8 nodes per bucket → LinkedList converts to Red-Black Tree
- [ ] Load factor 0.75 → rehash when 75% full → new 2x array
- [ ] HashMap vs Hashtable: synchronisation, null keys, performance
- [ ] Two Sum — O(n) one-pass HashMap
- [ ] Group Anagrams — sorted string as key
- [ ] Longest Consecutive Sequence — HashSet + start detection

---

## 💬 Community

The "only start counting from sequence starts" trick in LC #128 is what turns O(n²) into O(n). Did you figure it out before looking at the hint?

**Solved all 3? Drop a 🔥 in the community.**

---

*Next up → Day 40: Count Sort, Radix Sort, Huffman Coding*
