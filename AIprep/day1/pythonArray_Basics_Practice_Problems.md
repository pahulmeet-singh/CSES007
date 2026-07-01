# Array Basics - Practice Problems & Solutions

---

## PROBLEM 1: Find Maximum Element

### Statement
Given an array of integers, find and return the maximum element.

### Examples
```
Input: [3, 1, 4, 1, 5, 9, 2, 6]
Output: 9

Input: [-5, -2, -10]
Output: -2

Input: [7]
Output: 7
```

### Solution 1: Iteration
```python
def find_max(arr):
    if not arr:
        return None
    
    max_val = arr[0]
    for num in arr[1:]:
        if num > max_val:
            max_val = num
    return max_val

# Test
print(find_max([3, 1, 4, 1, 5, 9, 2, 6]))  # 9
print(find_max([-5, -2, -10]))              # -2
```

### Solution 2: Using Built-in
```python
def find_max(arr):
    return max(arr) if arr else None

# Test
print(find_max([3, 1, 4, 1, 5, 9, 2, 6]))  # 9
```

**Time:** O(n) | **Space:** O(1)

---

## PROBLEM 2: Find Second Maximum Element

### Statement
Find the second largest element in an array. Return None if it doesn't exist (array too small or all elements same).

### Examples
```
Input: [10, 5, 20, 8]
Output: 10

Input: [5, 5, 5, 5]
Output: None

Input: [1, 2]
Output: 1
```

### Solution 1: Optimal Single-Pass
```python
def find_second_max(arr):
    if len(arr) < 2:
        return None
    
    max_val = float('-inf')
    second_max = float('-inf')
    
    for num in arr:
        if num > max_val:
            second_max = max_val
            max_val = num
        elif num > second_max and num != max_val:
            second_max = num
    
    return second_max if second_max != float('-inf') else None

# Test
print(find_second_max([10, 5, 20, 8]))     # 10
print(find_second_max([5, 5, 5, 5]))       # None
print(find_second_max([1, 2]))             # 1
```

### Solution 2: Two-Pass Method
```python
def find_second_max_two_pass(arr):
    if len(arr) < 2:
        return None
    
    max_val = max(arr)
    second_max = float('-inf')
    
    for num in arr:
        if num != max_val and num > second_max:
            second_max = num
    
    return second_max if second_max != float('-inf') else None

# Test
print(find_second_max_two_pass([10, 5, 20, 8]))  # 10
```

**Time:** O(n) | **Space:** O(1)

---

## PROBLEM 3: Remove Duplicates From Sorted Array

### Statement
Given a sorted array, remove all duplicates in-place. Return the number of unique elements.

### Examples
```
Input: [1, 1, 2, 2, 3, 3, 4]
Output: 4 (array becomes [1, 2, 3, 4, ...])

Input: [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
Output: 5 (array becomes [0, 1, 2, 3, 4, ...])

Input: [1]
Output: 1
```

### Solution 1: Two-Pointer In-Place (BEST for sorted arrays!)
```python
def remove_duplicates(arr):
    if not arr:
        return 0
    
    write_idx = 0
    
    for read_idx in range(1, len(arr)):
        if arr[read_idx] != arr[write_idx]:
            write_idx += 1
            arr[write_idx] = arr[read_idx]
    
    return write_idx + 1

# Test
arr1 = [1, 1, 2, 2, 3, 3, 4]
count = remove_duplicates(arr1)
print(f"Count: {count}, Array: {arr1[:count]}")
# Output: Count: 4, Array: [1, 2, 3, 4]

arr2 = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
count = remove_duplicates(arr2)
print(f"Count: {count}, Array: {arr2[:count]}")
# Output: Count: 5, Array: [0, 1, 2, 3, 4]
```

### Solution 2: Using Set (For Unsorted)
```python
def remove_duplicates_unsorted(arr):
    return list(dict.fromkeys(arr))  # Maintains order

# Test
print(remove_duplicates_unsorted([1, 2, 2, 3, 1, 4, 3]))
# Output: [1, 2, 3, 4]
```

**Time:** O(n) | **Space:** O(1) for sorted + in-place

---

## PROBLEM 4: Reverse an Array

### Statement
Reverse the array in-place.

### Examples
```
Input: [1, 2, 3, 4, 5]
Output: [5, 4, 3, 2, 1]

Input: [1, 2]
Output: [2, 1]

Input: []
Output: []
```

### Solution 1: Two-Pointer (BEST!)
```python
def reverse_array(arr):
    left, right = 0, len(arr) - 1
    
    while left < right:
        arr[left], arr[right] = arr[right], arr[left]
        left += 1
        right -= 1
    
    return arr

# Test
print(reverse_array([1, 2, 3, 4, 5]))    # [5, 4, 3, 2, 1]
print(reverse_array([1, 2]))             # [2, 1]
print(reverse_array([]))                 # []
```

### Solution 2: Python Slicing
```python
def reverse_array_slice(arr):
    return arr[::-1]

# Test
print(reverse_array_slice([1, 2, 3, 4, 5]))  # [5, 4, 3, 2, 1]
```

**Time:** O(n) | **Space:** O(1) for in-place, O(n) for new

---

## PROBLEM 5: Rotate Array Left by k Positions

### Statement
Rotate array to the left by k positions.

### Examples
```
Input: arr = [1, 2, 3, 4, 5], k = 2
Output: [3, 4, 5, 1, 2]

Input: arr = [1, 2, 3, 4, 5], k = 7
Output: [3, 4, 5, 1, 2]  (7 % 5 = 2)

Input: arr = [1, 2, 3, 4, 5], k = 0
Output: [1, 2, 3, 4, 5]
```

### Solution 1: Slicing (Simplest)
```python
def rotate_left(arr, k):
    if not arr:
        return arr
    k = k % len(arr)
    return arr[k:] + arr[:k]

# Test
print(rotate_left([1, 2, 3, 4, 5], 2))   # [3, 4, 5, 1, 2]
print(rotate_left([1, 2, 3, 4, 5], 7))   # [3, 4, 5, 1, 2]
print(rotate_left([1, 2, 3, 4, 5], 0))   # [1, 2, 3, 4, 5]
```

### Solution 2: In-Place with Reversal (OPTIMAL!)
```python
def reverse(arr, start, end):
    while start < end:
        arr[start], arr[end] = arr[end], arr[start]
        start += 1
        end -= 1

def rotate_left_inplace(arr, k):
    if not arr:
        return arr
    
    n = len(arr)
    k = k % n
    
    # Step 1: Reverse first k elements
    reverse(arr, 0, k - 1)
    
    # Step 2: Reverse remaining elements
    reverse(arr, k, n - 1)
    
    # Step 3: Reverse entire array
    reverse(arr, 0, n - 1)
    
    return arr

# Test
arr = [1, 2, 3, 4, 5]
print(rotate_left_inplace(arr, 2))   # [3, 4, 5, 1, 2]

# Example walkthrough for k=2:
# Original: [1, 2, 3, 4, 5]
# After step 1 (reverse [1,2]): [2, 1, 3, 4, 5]
# After step 2 (reverse [3,4,5]): [2, 1, 5, 4, 3]
# After step 3 (reverse all): [3, 4, 5, 1, 2] ✓
```

### Solution 3: Rotate Right by k
```python
def rotate_right(arr, k):
    if not arr:
        return arr
    k = k % len(arr)
    return arr[-k:] + arr[:-k] if k != 0 else arr

# Test
print(rotate_right([1, 2, 3, 4, 5], 2))   # [4, 5, 1, 2, 3]
```

**Time:** O(n) | **Space:** O(1) for in-place

---

## PROBLEM 6: Find Sum and Average

### Statement
Calculate sum and average of all elements.

### Examples
```
Input: [1, 2, 3, 4, 5]
Output: sum = 15, average = 3.0

Input: [10, 20]
Output: sum = 30, average = 15.0

Input: []
Output: sum = 0, average = None
```

### Solution
```python
def sum_and_average(arr):
    if not arr:
        return 0, None
    
    total = sum(arr)
    average = total / len(arr)
    
    return total, average

# Alternative manual approach
def sum_and_average_manual(arr):
    if not arr:
        return 0, None
    
    total = 0
    for num in arr:
        total += num
    
    average = total / len(arr)
    return total, average

# Test
print(sum_and_average([1, 2, 3, 4, 5]))  # (15, 3.0)
print(sum_and_average([10, 20]))         # (30, 15.0)
print(sum_and_average([]))               # (0, None)
```

**Time:** O(n) | **Space:** O(1)

---

## PROBLEM 7: Find Max, Min, and Difference

### Statement
Find maximum, minimum, and their difference in a single pass.

### Examples
```
Input: [3, 7, 2, 8, 1]
Output: max = 8, min = 1, diff = 7

Input: [5, 5, 5]
Output: max = 5, min = 5, diff = 0

Input: [-5, -2, -10]
Output: max = -2, min = -10, diff = 8
```

### Solution
```python
def find_max_min_diff(arr):
    if not arr:
        return None, None, None
    
    max_val = arr[0]
    min_val = arr[0]
    
    for num in arr[1:]:
        if num > max_val:
            max_val = num
        if num < min_val:
            min_val = num
    
    difference = max_val - min_val
    return max_val, min_val, difference

# Test
print(find_max_min_diff([3, 7, 2, 8, 1]))    # (8, 1, 7)
print(find_max_min_diff([5, 5, 5]))          # (5, 5, 0)
print(find_max_min_diff([-5, -2, -10]))      # (-2, -10, 8)
```

**Time:** O(n) | **Space:** O(1)

---

## PROBLEM 8: Reverse Array in Place (Partial)

### Statement
Reverse only elements from index start to end (inclusive).

### Examples
```
Input: arr = [1, 2, 3, 4, 5], start = 1, end = 3
Output: [1, 4, 3, 2, 5]

Input: arr = [1, 2, 3, 4, 5], start = 0, end = 4
Output: [5, 4, 3, 2, 1]
```

### Solution
```python
def reverse_partial(arr, start, end):
    while start < end:
        arr[start], arr[end] = arr[end], arr[start]
        start += 1
        end -= 1
    
    return arr

# Test
print(reverse_partial([1, 2, 3, 4, 5], 1, 3))    # [1, 4, 3, 2, 5]
print(reverse_partial([1, 2, 3, 4, 5], 0, 4))    # [5, 4, 3, 2, 1]
print(reverse_partial([1, 2, 3, 4, 5], 2, 2))    # [1, 2, 3, 4, 5]
```

**Time:** O(n) | **Space:** O(1)

---

## PROBLEM 9: Count Duplicates

### Statement
Count how many duplicate elements exist in the array.

### Examples
```
Input: [1, 2, 2, 3, 3, 3, 4]
Output: 3 (three duplicates: one extra 2, two extra 3s)

Input: [1, 2, 3, 4]
Output: 0

Input: [5, 5, 5, 5]
Output: 3
```

### Solution
```python
def count_duplicates(arr):
    seen = set()
    duplicate_count = 0
    
    for num in arr:
        if num in seen:
            duplicate_count += 1
        else:
            seen.add(num)
    
    return duplicate_count

# Test
print(count_duplicates([1, 2, 2, 3, 3, 3, 4]))  # 3
print(count_duplicates([1, 2, 3, 4]))           # 0
print(count_duplicates([5, 5, 5, 5]))           # 3
```

**Time:** O(n) | **Space:** O(n)

---

## PROBLEM 10: Find Average of Non-Negative Elements

### Statement
Find average of only positive (>= 0) elements.

### Examples
```
Input: [1, -2, 3, -4, 5]
Output: 3.0 (average of 1, 3, 5)

Input: [-1, -2, -3]
Output: None (no positive elements)

Input: [0, 0, 0]
Output: 0.0
```

### Solution
```python
def average_non_negative(arr):
    positive_nums = [num for num in arr if num >= 0]
    
    if not positive_nums:
        return None
    
    return sum(positive_nums) / len(positive_nums)

# Test
print(average_non_negative([1, -2, 3, -4, 5]))  # 3.0
print(average_non_negative([-1, -2, -3]))       # None
print(average_non_negative([0, 0, 0]))          # 0.0
```

**Time:** O(n) | **Space:** O(n)

---

## STRATEGY FOR EXAM

### Reading the Problem (2 min)
1. Identify what you need to output
2. Check example inputs/outputs
3. Note any constraints (sorted? size limits? in-place?)

### Planning (3-5 min)
1. Write pseudo-code
2. Identify time/space complexity
3. Think about edge cases

### Coding (10-15 min)
1. Write clean, readable code
2. Add comments explaining logic
3. Use meaningful variable names

### Testing (5 min)
1. Test with provided examples
2. Test edge cases:
   - Empty array
   - Single element
   - All same elements
   - Negative numbers
3. Verify complexity

### Common Pitfalls Checklist
- ✅ Handle empty arrays
- ✅ Handle single element
- ✅ Use k % n for rotations
- ✅ Correct loop bounds
- ✅ Off-by-one errors
- ✅ Proper two-pointer logic

---

## PRACTICE ASSIGNMENT

**Solve these before your exam:**

1. **Easy:** Problems 1, 4, 6
2. **Medium:** Problems 2, 3, 5, 9
3. **Hard:** Problems 7, 8, 10

**Time Goal:** 2 hours for all problems

**Then:** Do a mock exam where you solve 3-5 problems in 60 minutes.

Good luck! 💪
