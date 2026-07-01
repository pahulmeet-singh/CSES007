# Array Basics - Java Exam Prep Summary

**Status:** Ready for Exam Tomorrow
**Language:** Java
**Topics:** 7 modules → 10 practice problems
**Total Prep Time:** ~3 hours

---

## Quick Recall: What You Already Know

✅ **Traversal** - Forward, backward, loops
✅ **Sum** - Add all elements
✅ **Average** - Sum / length (remember to cast to double!)

**Today's Focus:** Everything else!

---

## Study Schedule (3 Hours)

### HOUR 1: Learn (60 minutes)

**Topics in order of difficulty:**

```
[5 min]  Second Maximum (MOST IMPORTANT NEW TOPIC)
         - Single-pass algorithm
         - Handles duplicates
         - Key: if (num > max) { secondMax = max; max = num; }

[5 min]  Remove Duplicates (Sorted Array)
         - Two-pointer in-place method
         - Write vs Read indices
         - Key: Only for sorted arrays!

[10 min] Reverse Array
         - Two-pointer from both ends
         - Simple but fundamental
         - Practice: [1,2,3,4,5] → [5,4,3,2,1]

[15 min] Rotate Left by k
         - New array approach first
         - Then reversal method (harder but optimal)
         - Key: k = k % len ALWAYS

[15 min] Combine everything
         - Sum + Average + Max
         - Min + Max + Difference
         - Count Duplicates with HashSet

[5 min]  Review edge cases
         - Empty arrays
         - Single elements
         - All same elements
         - Negative numbers
```

### HOUR 2: Practice Coding (60 minutes)

**Code without looking at solutions:**

```
[30 min]
- Problem 1: Find Max
- Problem 2: Find Second Max
- Problem 3: Remove Duplicates
- Problem 4: Reverse Array

[30 min]
- Problem 5: Rotate Left
- Problem 6: Sum/Avg/Max
- Problem 9: Count Duplicates
- Problem 10: Average Positive
```

**Check your answers against solutions. Understand why your code works.**

### HOUR 3: Master & Mock Test (60 minutes)

```
[10 min] Review cheat sheet

[45 min] TIMED MOCK EXAM
         Problem 2 (Second Max) - 10 min
         Problem 5 (Rotate Left) - 15 min
         Problem 3 (Remove Duplicates) - 10 min
         Problem 8 (Reverse Partial) - 10 min

[5 min]  Check and verify
```

---

## The 7 Topics Ranked by Difficulty

### ⭐ EASIEST (You already know)
1. **Traversal** - Using loops
2. **Sum & Average** - Basic accumulation

### ⭐⭐ EASY
3. **Maximum Element** - Start from arr[0], compare each
4. **Reverse Array** - Two-pointer swap

### ⭐⭐⭐ MEDIUM (FOCUS HERE)
5. **Second Maximum** - Tricky edge cases (duplicates)
6. **Remove Duplicates** - In-place two-pointer (sorted only)
7. **Rotate by k** - Multiple approaches

---

## Critical Java Reminders (Mistakes People Make)

### Mistake #1: Using .length() instead of .length
```java
❌ for (int i = 0; i < arr.length(); i++)  // WRONG! Arrays use .length
✅ for (int i = 0; i < arr.length; i++)    // CORRECT
```

### Mistake #2: Integer division instead of floating point
```java
❌ double avg = sum / arr.length;  // Wrong! Returns 0 for sum < len
✅ double avg = (double) sum / arr.length;  // Cast to double first
```

### Mistake #3: Not initializing max/min
```java
❌ int max;
   for (int num : arr) {
       if (num > max) max = num;  // ERROR: max never initialized!
   }

✅ int max = Integer.MIN_VALUE;
   for (int num : arr) {
       if (num > max) max = num;  // CORRECT
   }

✅ int max = arr[0];  // Or start with first element
   for (int i = 1; i < arr.length; i++) {
       if (arr[i] > max) max = arr[i];
   }
```

### Mistake #4: Forgetting k = k % arr.length in rotations
```java
❌ rotateLeft(arr, 7);  // What if arr.length = 5? ERROR!

✅ k = k % arr.length;  // Normalize first!
   rotateLeft(arr, 7);  // Now it's equivalent to k=2
```

### Mistake #5: Confusing remove duplicates with all duplicates gone
```java
❌ Writing code that removes the second occurrence only
✅ Write code that keeps ONLY the first occurrence of each unique element
```

---

## Code Templates You Should Memorize

### Template 1: Find Max/Min
```java
if (arr.length == 0) return Integer.MIN_VALUE;

int max = arr[0];
for (int num : arr) {
    if (num > max) max = num;
}
return max;
```

### Template 2: Two-Pointer (Reverse, Swap)
```java
int left = 0, right = arr.length - 1;
while (left < right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    left++;
    right--;
}
```

### Template 3: Two-Pointer (Two-Pass)
```java
int write = 0;
for (int read = 1; read < arr.length; read++) {
    if (arr[read] != arr[write]) {
        write++;
        arr[write] = arr[read];
    }
}
return write + 1;
```

### Template 4: Rotation with k normalization
```java
k = k % arr.length;  // ALWAYS DO THIS

int[] result = new int[arr.length];
for (int i = 0; i < arr.length - k; i++) {
    result[i] = arr[k + i];
}
for (int i = 0; i < k; i++) {
    result[arr.length - k + i] = arr[i];
}
return result;
```

### Template 5: HashSet for Duplicates
```java
HashSet<Integer> seen = new HashSet<>();
int count = 0;

for (int num : arr) {
    if (seen.contains(num)) {
        count++;  // It's a duplicate
    } else {
        seen.add(num);
    }
}
return count;
```

---

## The Most Important Concepts for Your Exam

### 🔥 #1: SECOND MAXIMUM (Single-Pass)
This trips up most people because of duplicates!

```java
public static int findSecondMax(int[] arr) {
    if (arr.length < 2) return Integer.MIN_VALUE;
    
    int max = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;
    
    for (int num : arr) {
        if (num > max) {
            secondMax = max;          // Old max becomes second max
            max = num;
        } else if (num > secondMax && num != max) {
            secondMax = num;          // Update second max only if != max
        }
    }
    
    return secondMax;
}
```

**Why this works:**
- When you find a new max, the old max automatically becomes the second max
- The `num != max` check prevents updating second max with duplicates
- Single pass = O(n) efficiency

**Test these cases:**
- `[10, 5, 20, 8]` → 10 ✓
- `[5, 5, 5, 5]` → MIN_VALUE ✓
- `[-5, -10, -2]` → -5 ✓

---

### 🔥 #2: ROTATE BY k (With Reversal)

Most elegant solution for in-place rotation!

```java
private static void reverse(int[] arr, int start, int end) {
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}

public static void rotateLeft(int[] arr, int k) {
    if (arr.length == 0) return;
    k = k % arr.length;
    
    reverse(arr, 0, k - 1);              // Step 1
    reverse(arr, k, arr.length - 1);     // Step 2
    reverse(arr, 0, arr.length - 1);     // Step 3
}
```

**Walkthrough [1,2,3,4,5], k=2:**
```
Original:   [1, 2, 3, 4, 5]
Step 1:     [2, 1, 3, 4, 5]  (reverse indices 0-1)
Step 2:     [2, 1, 5, 4, 3]  (reverse indices 2-4)
Step 3:     [3, 4, 5, 1, 2]  (reverse all) ← CORRECT!
```

**Why this works:**
1. Reverse first k elements: [1,2] → [2,1]
2. Reverse rest: [3,4,5] → [5,4,3]
3. Reverse entire: [2,1,5,4,3] → [3,4,5,1,2]

It's like magic, but it's just clever use of the reverse operation!

---

### 🔥 #3: REMOVE DUPLICATES (Sorted Only)

In-place, two-pointer, only works on sorted arrays!

```java
public static int removeDuplicates(int[] arr) {
    if (arr.length == 0) return 0;
    
    int write = 0;  // Position to write unique elements
    
    for (int read = 1; read < arr.length; read++) {
        if (arr[read] != arr[write]) {  // Found a new unique element
            write++;
            arr[write] = arr[read];
        }
    }
    
    return write + 1;  // Return count of unique elements
}
```

**How to use the result:**
```java
int[] arr = {1, 1, 2, 2, 3, 3, 4};
int count = removeDuplicates(arr);
// Only use arr[0] to arr[count-1]
System.out.println(Arrays.toString(Arrays.copyOf(arr, count)));
// Output: [1, 2, 3, 4]
```

**Why this works:**
- `write` tracks position of last unique element
- `read` scans for next unique element
- When we find a different element, move write forward and place it there
- The tail of array is garbage (don't use)

---

## Example: Writing a Solution in 15 Minutes

### Problem: Find Second Maximum

**Step 1: Read (1 min)**
- Input: array of integers
- Output: second largest integer
- Edge cases: less than 2 elements, all duplicates

**Step 2: Plan (2 min)**
```
Approach: Single-pass
1. Track both max and secondMax
2. When finding new max, old max becomes secondMax
3. Update secondMax only if different from max
Time: O(n), Space: O(1)
```

**Step 3: Code (10 min)**
```java
public static int findSecondMax(int[] arr) {
    if (arr.length < 2) return Integer.MIN_VALUE;
    
    int max = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;
    
    for (int num : arr) {
        if (num > max) {
            secondMax = max;
            max = num;
        } else if (num > secondMax && num != max) {
            secondMax = num;
        }
    }
    
    return secondMax;
}
```

**Step 4: Test (2 min)**
```
Test 1: [10, 5, 20, 8] → 10 ✓
Test 2: [5, 5, 5] → MIN_VALUE ✓
Test 3: [1, 2] → 1 ✓
```

---

## Quick Debug Checklist

If your code isn't working:

- [ ] Is `.length` spelled correctly? (not `.length()`)
- [ ] Are you casting to `double` for division?
- [ ] Is `max` initialized to `Integer.MIN_VALUE`?
- [ ] Did you normalize `k` with `k % arr.length`?
- [ ] Are loop bounds correct? (off-by-one errors?)
- [ ] Did you handle empty array?
- [ ] Does it work with negative numbers?
- [ ] Does it work with duplicates?

---

## Final Exam Tips

### Before You Start Writing Code:
1. ✅ Read the problem statement 2-3 times
2. ✅ Understand what exact output is needed
3. ✅ Check if array is sorted (affects algorithm!)
4. ✅ Check if in-place required (affects approach!)
5. ✅ Write 2-3 test cases mentally

### While Writing Code:
1. ✅ Use clear variable names (`write`, not `w`)
2. ✅ Add comments for complex logic
3. ✅ Initialize all variables properly
4. ✅ Handle edge cases first
5. ✅ Don't rush - cleaner code = fewer bugs

### After Writing Code:
1. ✅ Test with given example
2. ✅ Test with 1-2 edge cases
3. ✅ Check loop bounds manually
4. ✅ Verify time/space complexity
5. ✅ Submit with confidence!

---

## You've Got This!

You already know **Traversal**, **Sum**, and **Average**. Those are the foundation.

Now you're learning:
- **Second Max** - How to track two values simultaneously
- **Remove Duplicates** - How to use two pointers efficiently
- **Reverse** - Basic array manipulation
- **Rotate** - Creative use of reversal

These are all **moderate difficulty problems** that become **easy** with practice.

**Your game plan:**
1. Type each solution 2-3 times
2. Understand the "why" not just the "how"
3. Test edge cases thoroughly
4. Trust yourself during the exam

**Remember:** Your exam is testing if you can:
- Write clean, working code
- Understand time/space trade-offs
- Handle edge cases properly
- Solve problems under time pressure

You have all the knowledge. Now it's just practice!

---

## Quick Links to Your Materials

1. **Array_Basics_Java_Guide.md** - Detailed explanations & examples
2. **Array_Basics_Java_Practice.md** - 10 problems with multiple solutions
3. **Array_Basics_Java_Cheat_Sheet.txt** - One-page quick reference
4. **This file** - Study plan & key concepts

**Pro tip:** Print the cheat sheet! Keep it visible while you study.

---

## Final Words

**You're more prepared than you think.** 

The fact that you're doing this preparation the night before shows you're serious. Most students wing it. You're not.

By tomorrow morning, you'll be able to solve:
- ✅ Find Max/Min
- ✅ Find Second Max (the tricky one)
- ✅ Remove Duplicates
- ✅ Reverse Arrays
- ✅ Rotate by k positions
- ✅ Count Duplicates
- ✅ Complex combinations

**That's mastery of the first module.**

Now go code! 💪

---

*Last update: July 1, 2026*
*Prepared with ❤️ for your success*
