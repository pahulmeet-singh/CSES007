# Array Basics - Complete Java Exam Guide

**Last Updated:** July 1, 2026 | **Topics:** 7 concepts | **Code Examples:** 50+

---

## Topic 1: INTRODUCTION (Array Fundamentals Review)

### What You Need to Know
- Arrays are ordered collections of elements with **fixed size**
- Index-based access: first element at index 0
- Time complexity: O(1) access, O(n) insertion/deletion
- Space complexity: O(n) where n = array size

### Key Declarations in Java
```java
// Declaration and Initialization
int[] arr = {1, 2, 3, 4, 5};           // With values
int[] arr = new int[5];                 // Size 5, all zeros by default
int[] arr = new int[0];                 // Empty array

// Other data types
String[] strings = {"a", "b", "c"};
double[] doubles = {1.5, 2.5, 3.5};
boolean[] flags = new boolean[10];      // All false by default

// Getting array length
int length = arr.length;                // Note: .length not .length()
```

### Common Operations in Java
```java
// Access
int element = arr[0];                   // O(1)
arr[0] = 10;                            // O(1)

// Length
int length = arr.length;                // O(1)

// No built-in insert/remove in arrays
// (Must use ArrayList for dynamic operations)

// Printing array
System.out.println(Arrays.toString(arr));  // "[1, 2, 3, 4, 5]"
```

---

## Topic 2: TRAVERSE (You Already Know This!)

### Forward Traversal
```java
// Using index-based loop
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}

// Using enhanced for loop (cleaner)
for (int element : arr) {
    System.out.println(element);
}
```

### Backward Traversal
```java
// Using index-based loop
for (int i = arr.length - 1; i >= 0; i--) {
    System.out.println(arr[i]);
}
```

**Time Complexity:** O(n) | **Space Complexity:** O(1)

---

## Topic 3: SUM / AVERAGE / MAX

You know Sum and Average. Here's how to add MAX:

### Sum (You Know This)
```java
public static int findSum(int[] arr) {
    int total = 0;
    for (int element : arr) {
        total += element;
    }
    return total;
}

// Test
int[] arr = {1, 2, 3, 4, 5};
System.out.println(findSum(arr));  // Output: 15
```

### Average (You Know This)
```java
public static double findAverage(int[] arr) {
    if (arr.length == 0) {
        return 0;
    }
    return (double) findSum(arr) / arr.length;
}

// Test
System.out.println(findAverage(new int[]{1, 2, 3, 4, 5}));  // Output: 3.0
```

### Maximum (NEW)
```java
public static int findMax(int[] arr) {
    if (arr.length == 0) {
        return Integer.MIN_VALUE;  // Or throw exception
    }
    
    int maxValue = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > maxValue) {
            maxValue = arr[i];
        }
    }
    return maxValue;
}

// Test
System.out.println(findMax(new int[]{1, 5, 3, 9, 2}));      // Output: 9
System.out.println(findMax(new int[]{-5, -2, -10}));        // Output: -2
```

### All Three Together
```java
public static void sumAvgMax(int[] arr) {
    if (arr.length == 0) {
        System.out.println("Array is empty");
        return;
    }
    
    int sum = 0;
    int maxValue = arr[0];
    
    for (int element : arr) {
        sum += element;
        if (element > maxValue) {
            maxValue = element;
        }
    }
    
    double average = (double) sum / arr.length;
    System.out.printf("Sum: %d, Avg: %.2f, Max: %d%n", sum, average, maxValue);
}

// Test
sumAvgMax(new int[]{10, 20, 30, 5});
// Output: Sum: 65, Avg: 16.25, Max: 30
```

**Time Complexity:** O(n) | **Space Complexity:** O(1)

---

## Topic 4: SECOND MAX (IMPORTANT!)

### Approach 1: Two-Pass Method (Beginner)
```java
public static int findSecondMaxV1(int[] arr) {
    if (arr.length < 2) {
        return Integer.MIN_VALUE;  // Error indicator
    }
    
    // First pass: find max
    int maxValue = arr[0];
    for (int element : arr) {
        if (element > maxValue) {
            maxValue = element;
        }
    }
    
    // Second pass: find second max
    int secondMax = Integer.MIN_VALUE;
    for (int element : arr) {
        if (element != maxValue && element > secondMax) {
            secondMax = element;
        }
    }
    
    return (secondMax == Integer.MIN_VALUE) ? Integer.MIN_VALUE : secondMax;
}

// Test
System.out.println(findSecondMaxV1(new int[]{10, 5, 20, 8}));  // Output: 10
System.out.println(findSecondMaxV1(new int[]{5, 5, 5, 5}));    // Output: MIN_VALUE (all same)
```

### Approach 2: Single-Pass Method (OPTIMAL - Use This!)
```java
public static int findSecondMaxV2(int[] arr) {
    if (arr.length < 2) {
        return Integer.MIN_VALUE;
    }
    
    int maxValue = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;
    
    for (int element : arr) {
        if (element > maxValue) {
            secondMax = maxValue;              // Previous max becomes second max
            maxValue = element;
        } else if (element > secondMax && element != maxValue) {
            secondMax = element;
        }
    }
    
    return (secondMax == Integer.MIN_VALUE) ? Integer.MIN_VALUE : secondMax;
}

// Test
System.out.println(findSecondMaxV2(new int[]{10, 5, 20, 8}));  // Output: 10
System.out.println(findSecondMaxV2(new int[]{5, 5, 5, 5}));    // Output: MIN_VALUE
System.out.println(findSecondMaxV2(new int[]{20, 10}));        // Output: 10
System.out.println(findSecondMaxV2(new int[]{-5, -10, -2}));   // Output: -5
```

### Approach 3: Sorting Method (Simple but slower)
```java
public static int findSecondMaxV3(int[] arr) {
    if (arr.length < 2) {
        return Integer.MIN_VALUE;
    }
    
    Arrays.sort(arr);
    // After sorting, second largest is at arr[length-2]
    return arr[arr.length - 2];
}

// Test
System.out.println(findSecondMaxV3(new int[]{10, 5, 20, 8}));  // Output: 10
```

**Best Time Complexity:** O(n) single-pass | **Space Complexity:** O(1)

### Edge Cases to Remember
- Array with duplicates: `{5, 5, 5, 5}` → MIN_VALUE
- Negative numbers: `{-10, -20, -5}` → -10
- Exactly 2 elements: `{3, 7}` → 3
- All same: Handle duplicates properly!

---

## Topic 5: REMOVE DUPLICATES

### Approach 1: Create New Array Using HashSet
```java
public static int[] removeDuplicatesV1(int[] arr) {
    if (arr.length == 0) {
        return new int[0];
    }
    
    HashSet<Integer> seen = new HashSet<>();
    // First, count unique elements
    for (int element : arr) {
        seen.add(element);
    }
    
    // Create result array
    int[] result = new int[seen.size()];
    int index = 0;
    for (int element : arr) {
        if (seen.contains(element)) {
            result[index++] = element;
            seen.remove(element);  // Remove to ensure we don't add again
        }
    }
    
    return result;
}

// Test
int[] arr1 = {1, 2, 2, 3, 1, 4, 3};
System.out.println(Arrays.toString(removeDuplicatesV1(arr1)));  
// Output: [1, 2, 3, 4]
```

### Approach 2: In-Place (For Sorted Arrays - BEST!)
```java
public static int removeDuplicatesV2(int[] arr) {
    /*
    Modifies array in-place and returns number of unique elements
    Rest of array becomes garbage (don't use those values)
    */
    if (arr.length == 0) {
        return 0;
    }
    
    int writeIndex = 0;
    
    for (int readIndex = 1; readIndex < arr.length; readIndex++) {
        if (arr[readIndex] != arr[writeIndex]) {
            writeIndex++;
            arr[writeIndex] = arr[readIndex];
        }
    }
    
    return writeIndex + 1;
}

// Test
int[] arr1 = {1, 1, 2, 2, 3, 3, 4};
int count = removeDuplicatesV2(arr1);
System.out.println("Count: " + count);  // Output: 4
System.out.println(Arrays.toString(Arrays.copyOf(arr1, count)));  // [1, 2, 3, 4]
```

**Important:** When using in-place approach for sorted array, only access first `count` elements!

**Time Complexity:** O(n) | **Space Complexity:** O(n) for new array, O(1) for in-place

### Important Notes
- **If array is sorted:** Use in-place two-pointer approach (Approach 2)
- **If array is unsorted:** Use HashSet approach (Approach 1)
- Exams often ask in-place with sorted array!

---

## Topic 6: REVERSE

### Approach 1: Two-Pointer Method (BEST!)
```java
public static void reverseArray(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    
    while (left < right) {
        // Swap
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        
        left++;
        right--;
    }
}

// Test
int[] arr1 = {1, 2, 3, 4, 5};
reverseArray(arr1);
System.out.println(Arrays.toString(arr1));  // Output: [5, 4, 3, 2, 1]

int[] arr2 = {1, 2};
reverseArray(arr2);
System.out.println(Arrays.toString(arr2));  // Output: [2, 1]
```

### Approach 2: Using Index Loop (Alternative)
```java
public static void reverseArray2(int[] arr) {
    for (int i = 0; i < arr.length / 2; i++) {
        int temp = arr[i];
        arr[i] = arr[arr.length - 1 - i];
        arr[arr.length - 1 - i] = temp;
    }
}

// Test - same results as Approach 1
```

### Approach 3: Create New Reversed Array
```java
public static int[] reverseArrayCopy(int[] arr) {
    int[] result = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
        result[i] = arr[arr.length - 1 - i];
    }
    return result;
}

// Test
int[] arr1 = {1, 2, 3, 4, 5};
int[] reversed = reverseArrayCopy(arr1);
System.out.println(Arrays.toString(reversed));  // Output: [5, 4, 3, 2, 1]
```

**Time Complexity:** O(n) | **Space Complexity:** O(1) for in-place, O(n) for new array

### Common Variations
```java
// Reverse only part of array
public static void reversePartial(int[] arr, int start, int end) {
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}

// Test
int[] arr = {1, 2, 3, 4, 5};
reversePartial(arr, 1, 3);
System.out.println(Arrays.toString(arr));  // Output: [1, 4, 3, 2, 5]
```

---

## Topic 7: ROTATE

### Approach 1: Left Rotation Using Slicing Logic
```java
public static int[] rotateLeftV1(int[] arr, int k) {
    if (arr.length == 0) return arr;
    
    k = k % arr.length;  // Important!
    int[] result = new int[arr.length];
    
    // Copy arr[k:] to beginning
    for (int i = 0; i < arr.length - k; i++) {
        result[i] = arr[k + i];
    }
    
    // Copy arr[:k] to end
    for (int i = 0; i < k; i++) {
        result[arr.length - k + i] = arr[i];
    }
    
    return result;
}

// Test
int[] arr1 = {1, 2, 3, 4, 5};
System.out.println(Arrays.toString(rotateLeftV1(arr1, 2)));  
// Output: [3, 4, 5, 1, 2]

System.out.println(Arrays.toString(rotateLeftV1(arr1, 7)));  
// Output: [3, 4, 5, 1, 2] (7%5=2)
```

### Approach 2: In-Place Left Rotation Using Reversal (OPTIMAL!)
```java
public static void reversePartial(int[] arr, int start, int end) {
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}

public static void rotateLeftV2(int[] arr, int k) {
    if (arr.length == 0) return;
    
    k = k % arr.length;
    
    // Reverse first k elements
    reversePartial(arr, 0, k - 1);
    
    // Reverse remaining elements
    reversePartial(arr, k, arr.length - 1);
    
    // Reverse entire array
    reversePartial(arr, 0, arr.length - 1);
}

// Test
int[] arr = {1, 2, 3, 4, 5};
rotateLeftV2(arr, 2);
System.out.println(Arrays.toString(arr));  // Output: [3, 4, 5, 1, 2]

// Walkthrough for k=2:
// Original:     [1, 2, 3, 4, 5]
// After step 1: [2, 1, 3, 4, 5]
// After step 2: [2, 1, 5, 4, 3]
// After step 3: [3, 4, 5, 1, 2] ✓
```

### Approach 3: Right Rotation
```java
public static int[] rotateRight(int[] arr, int k) {
    if (arr.length == 0) return arr;
    
    k = k % arr.length;
    int[] result = new int[arr.length];
    
    for (int i = 0; i < arr.length; i++) {
        result[(i + k) % arr.length] = arr[i];
    }
    
    return result;
}

// Test
int[] arr1 = {1, 2, 3, 4, 5};
System.out.println(Arrays.toString(rotateRight(arr1, 2)));  
// Output: [4, 5, 1, 2, 3]
```

**Time Complexity:** O(n) | **Space Complexity:** O(1) for in-place, O(n) for new array

### Key Points
- Always use `k = k % arr.length` to handle k > array length
- Left rotation by k = elements shift left
- Right rotation by k = elements shift right
- Reversal method is most elegant for in-place

---

## PRACTICE PROBLEMS IN JAVA

### Problem 1: Find Maximum
```java
public static int findMax(int[] arr) {
    if (arr.length == 0) return Integer.MIN_VALUE;
    
    int max = arr[0];
    for (int num : arr) {
        if (num > max) max = num;
    }
    return max;
}

// Test
System.out.println(findMax(new int[]{3, 1, 4, 1, 5, 9}));  // 9
```

### Problem 2: Second Maximum
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

// Test
System.out.println(findSecondMax(new int[]{10, 5, 20, 8}));  // 10
```

### Problem 3: Remove Duplicates (Sorted Array)
```java
public static int removeDuplicates(int[] arr) {
    if (arr.length == 0) return 0;
    
    int write = 0;
    for (int read = 1; read < arr.length; read++) {
        if (arr[read] != arr[write]) {
            write++;
            arr[write] = arr[read];
        }
    }
    return write + 1;
}

// Test
int[] arr = {1, 1, 2, 2, 3, 3, 4};
int count = removeDuplicates(arr);
System.out.println(Arrays.toString(Arrays.copyOf(arr, count)));  // [1, 2, 3, 4]
```

### Problem 4: Reverse Array
```java
public static void reverse(int[] arr) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
    }
}

// Test
int[] arr = {1, 2, 3, 4, 5};
reverse(arr);
System.out.println(Arrays.toString(arr));  // [5, 4, 3, 2, 1]
```

### Problem 5: Rotate Left by k
```java
public static int[] rotateLeft(int[] arr, int k) {
    if (arr.length == 0) return arr;
    k = k % arr.length;
    
    int[] result = new int[arr.length];
    for (int i = 0; i < arr.length - k; i++) {
        result[i] = arr[k + i];
    }
    for (int i = 0; i < k; i++) {
        result[arr.length - k + i] = arr[i];
    }
    return result;
}

// Test
System.out.println(Arrays.toString(rotateLeft(new int[]{1,2,3,4,5}, 2)));  
// [3, 4, 5, 1, 2]
```

---

## COMMON JAVA PITFALLS

❌ **Mistake 1:** Confusing `.length` with `.length()`
- Arrays use `.length` (property)
- Strings use `.length()` (method)

✅ **Fix:** 
```java
arr.length      // Correct for arrays
str.length()    // Correct for strings
```

---

❌ **Mistake 2:** Forgetting to cast to double for averages
```java
double avg = sum / arr.length;  // WRONG: integer division!
```

✅ **Fix:**
```java
double avg = (double) sum / arr.length;  // Correct
```

---

❌ **Mistake 3:** Not initializing variables for min/max
```java
int max;  // What's the value?
for (int num : arr) {
    if (num > max) max = num;  // Can throw NullPointerException
}
```

✅ **Fix:**
```java
int max = Integer.MIN_VALUE;  // Or arr[0]
for (int num : arr) {
    if (num > max) max = num;
}
```

---

❌ **Mistake 4:** Forgetting `k = k % arr.length` in rotations
```java
rotateLeft(arr, 7);  // What if arr.length = 5?
```

✅ **Fix:**
```java
k = k % arr.length;  // Always normalize k
```

---

## QUICK REFERENCE - JAVA SYNTAX

```java
// Array initialization
int[] arr = {1, 2, 3};
int[] arr = new int[5];  // All zeros

// Loops
for (int i = 0; i < arr.length; i++) { }           // Index-based
for (int x : arr) { }                               // Enhanced for
for (int i = arr.length - 1; i >= 0; i--) { }      // Backward

// Common operations
System.out.println(Arrays.toString(arr));  // Print array
Arrays.sort(arr);                          // Sort array
System.arraycopy(src, 0, dst, 0, len);    // Copy array

// Integer limits
Integer.MIN_VALUE  // -2147483648
Integer.MAX_VALUE  // 2147483647

// Casting
double avg = (double) sum / len;  // Always cast before division

// HashSet
HashSet<Integer> set = new HashSet<>();
set.add(5);
set.contains(5);
set.remove(5);
```

---

## YOUR STUDY PLAN FOR TOMORROW (JAVA)

**Hour 1: Review & Learn**
- Read sections on Traversal, Sum, Average (review)
- Focus on: Second Max, Remove Duplicates, Reverse
- Code each example in IntelliJ or your IDE

**Hour 2: Practice**
- Code Problems 1-5 WITHOUT looking at solutions
- Test with provided examples
- Compare your code with solutions

**Hour 3: Master**
- Code remaining problems
- Timed practice: 3 problems in 45 minutes
- Review edge cases

**Key:** Type the code yourself, don't just read it!

Good luck! 💪
