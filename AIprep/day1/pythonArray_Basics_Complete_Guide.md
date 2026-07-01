# Array Basics - Complete Exam Guide

**Last Updated:** July 1, 2026 | **Topics:** 7 concepts | **Code Examples:** 50+

---

## Topic 1: INTRODUCTION (Array Fundamentals Review)

### What You Need to Know
- Arrays are ordered collections of elements with **fixed size**
- Index-based access: first element at index 0
- Time complexity: O(1) access, O(n) insertion/deletion
- Space complexity: O(n) where n = array size

### Key Declarations
```python
# Python
arr = [1, 2, 3, 4, 5]           # List initialization
arr = [0] * 5                     # Array with 5 zeros
arr = []                          # Empty array

# If using arrays (like Java/C++)
# int[] arr = {1, 2, 3, 4, 5};
# int[] arr = new int[5];
```

### Common Operations
```python
# Access
element = arr[0]                  # O(1)
arr[0] = 10                       # O(1)

# Insert (list-specific)
arr.insert(2, 99)                 # O(n)

# Remove
arr.pop()                         # O(1) for last element
arr.pop(0)                        # O(n) for first element
arr.remove(value)                 # O(n)

# Length
length = len(arr)                 # O(1)
```

---

## Topic 2: TRAVERSE (You Already Know This!)

### Standard Traversal
```python
# Forward traversal
for i in range(len(arr)):
    print(arr[i])

# Backward traversal
for i in range(len(arr)-1, -1, -1):
    print(arr[i])

# Using value directly
for element in arr:
    print(element)
```

**Time Complexity:** O(n) | **Space Complexity:** O(1)

---

## Topic 3: SUM / AVERAGE / MAX

You know Sum and Average. Here's how to add MAX:

### Sum (You Know This)
```python
def find_sum(arr):
    total = 0
    for element in arr:
        total += element
    return total

# Test
arr = [1, 2, 3, 4, 5]
print(find_sum(arr))              # Output: 15
```

### Average (You Know This)
```python
def find_average(arr):
    if len(arr) == 0:
        return 0
    return find_sum(arr) / len(arr)

# Test
print(find_average([1, 2, 3, 4, 5]))  # Output: 3.0
```

### Maximum (NEW)
```python
def find_max(arr):
    if len(arr) == 0:
        return None
    
    max_value = arr[0]              # Start with first element
    for i in range(1, len(arr)):
        if arr[i] > max_value:
            max_value = arr[i]
    return max_value

# Test
print(find_max([1, 5, 3, 9, 2]))   # Output: 9
print(find_max([-5, -2, -10]))     # Output: -2 (handles negatives!)
print(find_max([]))                 # Output: None (handles empty)
```

### All Three Together
```python
def sum_avg_max(arr):
    if len(arr) == 0:
        return None, None, None
    
    total = 0
    max_value = arr[0]
    
    for element in arr:
        total += element
        if element > max_value:
            max_value = element
    
    average = total / len(arr)
    return total, average, max_value

# Test
result = sum_avg_max([10, 20, 30, 5])
print(f"Sum: {result[0]}, Avg: {result[1]}, Max: {result[2]}")
# Output: Sum: 65, Avg: 16.25, Max: 30
```

**Time Complexity:** O(n) | **Space Complexity:** O(1)

---

## Topic 4: SECOND MAX (IMPORTANT!)

### Approach 1: Two-Pass Method (Beginner)
```python
def find_second_max_v1(arr):
    if len(arr) < 2:
        return None
    
    # First pass: find max
    max_value = arr[0]
    for element in arr:
        if element > max_value:
            max_value = element
    
    # Second pass: find second max (excluding max)
    second_max = float('-inf')
    for element in arr:
        if element != max_value and element > second_max:
            second_max = element
    
    return second_max if second_max != float('-inf') else None

# Test
print(find_second_max_v1([10, 5, 20, 8]))      # Output: 10
print(find_second_max_v1([5, 5, 5, 5]))        # Output: None (all same)
print(find_second_max_v1([10]))                # Output: None (only one element)
```

### Approach 2: Single-Pass Method (OPTIMAL - Use This!)
```python
def find_second_max_v2(arr):
    if len(arr) < 2:
        return None
    
    max_value = float('-inf')
    second_max = float('-inf')
    
    for element in arr:
        if element > max_value:
            second_max = max_value        # Previous max becomes second max
            max_value = element
        elif element > second_max and element != max_value:
            second_max = element
    
    return second_max if second_max != float('-inf') else None

# Test
print(find_second_max_v2([10, 5, 20, 8]))      # Output: 10
print(find_second_max_v2([5, 5, 5, 5]))        # Output: None
print(find_second_max_v2([20, 10]))            # Output: 10
print(find_second_max_v2([-5, -10, -2]))       # Output: -5 (negatives work!)
```

### Approach 3: Sorting Method (Simple but slower)
```python
def find_second_max_v3(arr):
    if len(arr) < 2:
        return None
    
    unique_sorted = sorted(set(arr), reverse=True)
    return unique_sorted[1] if len(unique_sorted) >= 2 else None

# Test
print(find_second_max_v3([10, 5, 20, 8]))      # Output: 10
print(find_second_max_v3([5, 5, 5, 5]))        # Output: None
```

**Best Time Complexity:** O(n) single-pass | **Space Complexity:** O(1)

### Edge Cases to Remember
- Array with duplicates: `[5, 5, 5, 5]` → None
- Negative numbers: `[-10, -20, -5]` → -10
- Exactly 2 elements: `[3, 7]` → 3
- All same: Handle duplicates properly!

---

## Topic 5: REMOVE DUPLICATES

### Approach 1: Create New Array (Easiest)
```python
def remove_duplicates_v1(arr):
    seen = set()
    result = []
    
    for element in arr:
        if element not in seen:
            result.append(element)
            seen.add(element)
    
    return result

# Test
print(remove_duplicates_v1([1, 2, 2, 3, 1, 4, 3]))  # Output: [1, 2, 3, 4]
print(remove_duplicates_v1([5, 5, 5]))              # Output: [5]
print(remove_duplicates_v1([]))                     # Output: []
```

### Approach 2: In-Place (Tricky but Important!)
```python
def remove_duplicates_v2(arr):
    """
    Modifies array in-place and returns number of unique elements
    Rest of array becomes garbage (don't use those values)
    """
    if len(arr) == 0:
        return 0
    
    write_index = 0
    
    for read_index in range(1, len(arr)):
        if arr[read_index] != arr[write_index]:
            write_index += 1
            arr[write_index] = arr[read_index]
    
    return write_index + 1

# Test
arr1 = [1, 1, 2, 2, 3, 3, 4]
count = remove_duplicates_v2(arr1)
print(arr1[:count])  # Output: [1, 2, 3, 4]
```

### Approach 3: Using Set (Fastest)
```python
def remove_duplicates_v3(arr):
    return list(dict.fromkeys(arr))  # Preserves order

# OR
def remove_duplicates_v3_alt(arr):
    return list(set(arr))  # Doesn't preserve order

# Test
print(remove_duplicates_v3([1, 2, 2, 3, 1, 4, 3]))  # Output: [1, 2, 3, 4] (ordered)
print(remove_duplicates_v3_alt([1, 2, 2, 3, 1, 4, 3]))  # Unordered
```

**Time Complexity:** O(n) | **Space Complexity:** O(n) for new array, O(1) for in-place

### Important Notes
- **If array is sorted:** Use in-place two-pointer approach (Approach 2)
- **If array is unsorted:** Use set-based approach (Approach 3)
- Exams often ask in-place with sorted array!

---

## Topic 6: REVERSE

### Approach 1: Two-Pointer Method (BEST!)
```python
def reverse_array_v1(arr):
    left = 0
    right = len(arr) - 1
    
    while left < right:
        # Swap
        arr[left], arr[right] = arr[right], arr[left]
        left += 1
        right -= 1
    
    return arr

# Test
print(reverse_array_v1([1, 2, 3, 4, 5]))  # Output: [5, 4, 3, 2, 1]
print(reverse_array_v1([1, 2]))           # Output: [2, 1]
print(reverse_array_v1([1]))              # Output: [1]
print(reverse_array_v1([]))               # Output: []
```

### Approach 2: Built-in/Slicing (Simple)
```python
def reverse_array_v2(arr):
    return arr[::-1]  # Python slicing

# Test
print(reverse_array_v2([1, 2, 3, 4, 5]))  # Output: [5, 4, 3, 2, 1]
```

### Approach 3: Reverse Traversal (Learning Purpose)
```python
def reverse_array_v3(arr):
    result = []
    for i in range(len(arr) - 1, -1, -1):
        result.append(arr[i])
    return result

# Test
print(reverse_array_v3([1, 2, 3, 4, 5]))  # Output: [5, 4, 3, 2, 1]
```

**Time Complexity:** O(n) | **Space Complexity:** O(1) for in-place, O(n) for new array

### Common Variations
```python
# Reverse only part of array
def reverse_partial(arr, start, end):
    while start < end:
        arr[start], arr[end] = arr[end], arr[start]
        start += 1
        end -= 1
    return arr

print(reverse_partial([1, 2, 3, 4, 5], 1, 3))  # Output: [1, 4, 3, 2, 5]

# Reverse in groups of k
def reverse_in_groups(arr, k):
    for i in range(0, len(arr), k):
        left = i
        right = min(i + k - 1, len(arr) - 1)
        while left < right:
            arr[left], arr[right] = arr[right], arr[left]
            left += 1
            right -= 1
    return arr

print(reverse_in_groups([1, 2, 3, 4, 5], 2))  # Output: [2, 1, 4, 3, 5]
```

---

## Topic 7: ROTATE

### Approach 1: Left Rotation (Most Common)
```python
def rotate_left_v1(arr, k):
    """Rotate array left by k positions"""
    n = len(arr)
    k = k % n  # Handle k > n
    
    return arr[k:] + arr[:k]

# Test
print(rotate_left_v1([1, 2, 3, 4, 5], 2))   # Output: [3, 4, 5, 1, 2]
print(rotate_left_v1([1, 2, 3, 4, 5], 7))   # Output: [3, 4, 5, 1, 2] (7%5=2)
print(rotate_left_v1([1, 2, 3, 4, 5], 0))   # Output: [1, 2, 3, 4, 5]
```

### Approach 2: In-Place Left Rotation (OPTIMAL for interviews!)
```python
def rotate_left_v2(arr, k):
    """In-place left rotation using reversal trick"""
    n = len(arr)
    k = k % n
    
    # Reverse first k elements
    reverse_partial(arr, 0, k - 1)
    
    # Reverse remaining elements
    reverse_partial(arr, k, n - 1)
    
    # Reverse entire array
    reverse_partial(arr, 0, n - 1)
    
    return arr

def reverse_partial(arr, start, end):
    while start < end:
        arr[start], arr[end] = arr[end], arr[start]
        start += 1
        end -= 1

# Test
arr = [1, 2, 3, 4, 5]
print(rotate_left_v2(arr, 2))  # Output: [3, 4, 5, 1, 2]
```

### Approach 3: Right Rotation
```python
def rotate_right(arr, k):
    """Rotate array right by k positions"""
    n = len(arr)
    k = k % n
    
    return arr[-k:] + arr[:-k] if k != 0 else arr

# Test
print(rotate_right([1, 2, 3, 4, 5], 2))    # Output: [4, 5, 1, 2, 3]
print(rotate_right([1, 2, 3, 4, 5], 1))    # Output: [5, 1, 2, 3, 4]
```

### Approach 4: Step-by-Step Manual Rotation (Learning)
```python
def rotate_left_manual(arr, k):
    """Rotate by moving elements one position at a time"""
    n = len(arr)
    k = k % n
    
    for _ in range(k):
        first = arr[0]
        for i in range(n - 1):
            arr[i] = arr[i + 1]
        arr[n - 1] = first
    
    return arr

# Test
print(rotate_left_manual([1, 2, 3, 4, 5], 2))  # Output: [3, 4, 5, 1, 2]
```

**Time Complexity:** O(n) | **Space Complexity:** O(1) for in-place, O(n) for new array

### Key Points
- Always use `k % n` to handle k > array length
- Left rotation by k = elements shift left
- Right rotation by k = elements shift right
- Reversal method is most elegant

---

## PRACTICE PROBLEMS

### Easy
1. Find max and min in single pass
2. Find average of positive numbers only
3. Rotate array right by 3
4. Remove duplicates from sorted array

### Medium
5. Find kth largest element
6. Rotate array by multiple of 3
7. Find all elements greater than average
8. Implement circular array rotation

### Hard
9. Rotate matrix 90 degrees (2D array)
10. Find all unique pairs that sum to target

---

## COMMON EXAM MISTAKES TO AVOID

❌ **Mistake 1:** Forgetting edge cases
- Empty arrays
- Single element arrays
- Arrays with all same elements
- Negative numbers

✅ **Fix:** Always add `if len(arr) < 2: return None` checks

---

❌ **Mistake 2:** Off-by-one errors in loops
- Using `range(len(arr))` when should use `range(len(arr)-1)`
- Wrong index when accessing elements

✅ **Fix:** Write out first few iterations by hand

---

❌ **Mistake 3:** Not handling k > array length
- `rotate_left([1,2,3,4,5], 7)` should work!

✅ **Fix:** Always do `k = k % len(arr)`

---

❌ **Mistake 4:** Confusion between in-place and new array
- In-place: modifies original, returns count/void
- New array: returns new array, original unchanged

✅ **Fix:** Read problem carefully: "in-place" or "return"?

---

## QUICK REFERENCE TABLE

| Operation | Time | Space | Difficulty |
|-----------|------|-------|-----------|
| Traverse | O(n) | O(1) | ⭐ |
| Sum/Avg/Max | O(n) | O(1) | ⭐ |
| Second Max | O(n) | O(1) | ⭐⭐ |
| Remove Duplicates | O(n) | O(n) | ⭐⭐ |
| Reverse | O(n) | O(1) | ⭐ |
| Rotate | O(n) | O(1) | ⭐⭐ |

---

## YOUR STUDY PLAN FOR TOMORROW

**Time Allocation:**
1. **Introduction & Traverse** (5 min) - Review only
2. **Sum/Avg/Max** (15 min) - Code all 3 versions
3. **Second Max** (20 min) - Learn single-pass version
4. **Remove Duplicates** (20 min) - Do both approaches
5. **Reverse** (15 min) - Master two-pointer method
6. **Rotate** (20 min) - Do reversal approach
7. **Practice Problems** (25 min) - Code 3-4 problems without looking
8. **Mock Exam** (60 min) - Time yourself on full problems

**Total:** ~3 hours (pace yourself!)

Good luck! 🚀
