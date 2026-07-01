# Array Basics - Java Practice Problems & Solutions

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

### Solution
```java
public static int findMax(int[] arr) {
    if (arr.length == 0) {
        return Integer.MIN_VALUE;  // Indicator of error
    }
    
    int maxVal = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > maxVal) {
            maxVal = arr[i];
        }
    }
    return maxVal;
}

// OR using enhanced for loop
public static int findMaxV2(int[] arr) {
    if (arr.length == 0) return Integer.MIN_VALUE;
    
    int maxVal = arr[0];
    for (int num : arr) {
        if (num > maxVal) {
            maxVal = num;
        }
    }
    return maxVal;
}

// Test
public static void main(String[] args) {
    System.out.println(findMax(new int[]{3, 1, 4, 1, 5, 9, 2, 6}));  // 9
    System.out.println(findMax(new int[]{-5, -2, -10}));              // -2
    System.out.println(findMax(new int[]{7}));                        // 7
}
```

**Time:** O(n) | **Space:** O(1)

---

## PROBLEM 2: Find Second Maximum Element

### Statement
Find the second largest element in an array. Return Integer.MIN_VALUE if not possible.

### Examples
```
Input: [10, 5, 20, 8]
Output: 10

Input: [5, 5, 5, 5]
Output: Integer.MIN_VALUE (all same)

Input: [1, 2]
Output: 1
```

### Solution 1: Optimal Single-Pass
```java
public static int findSecondMax(int[] arr) {
    if (arr.length < 2) {
        return Integer.MIN_VALUE;
    }
    
    int maxVal = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;
    
    for (int num : arr) {
        if (num > maxVal) {
            secondMax = maxVal;
            maxVal = num;
        } else if (num > secondMax && num != maxVal) {
            secondMax = num;
        }
    }
    
    return secondMax;
}

// Test
public static void main(String[] args) {
    System.out.println(findSecondMax(new int[]{10, 5, 20, 8}));   // 10
    System.out.println(findSecondMax(new int[]{5, 5, 5, 5}));     // MIN_VALUE
    System.out.println(findSecondMax(new int[]{1, 2}));           // 1
}
```

### Solution 2: Two-Pass Method
```java
public static int findSecondMaxTwoPass(int[] arr) {
    if (arr.length < 2) {
        return Integer.MIN_VALUE;
    }
    
    // Find max first
    int maxVal = arr[0];
    for (int num : arr) {
        if (num > maxVal) maxVal = num;
    }
    
    // Find second max
    int secondMax = Integer.MIN_VALUE;
    for (int num : arr) {
        if (num != maxVal && num > secondMax) {
            secondMax = num;
        }
    }
    
    return secondMax;
}

// Test - same results
```

### Solution 3: Sort Method
```java
import java.util.Arrays;

public static int findSecondMaxSort(int[] arr) {
    if (arr.length < 2) {
        return Integer.MIN_VALUE;
    }
    
    Arrays.sort(arr);
    return arr[arr.length - 2];  // Second last element
}

// Test
System.out.println(findSecondMaxSort(new int[]{10, 5, 20, 8}));  // 10
```

**Time:** O(n) | **Space:** O(1)

---

## PROBLEM 3: Remove Duplicates From Sorted Array

### Statement
Given a sorted array, remove duplicates in-place. Return count of unique elements.

### Examples
```
Input: [1, 1, 2, 2, 3, 3, 4]
Output: 4 (array becomes [1, 2, 3, 4, ...])

Input: [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
Output: 5 (array becomes [0, 1, 2, 3, 4, ...])
```

### Solution 1: Two-Pointer In-Place (BEST!)
```java
public static int removeDuplicates(int[] arr) {
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
public static void main(String[] args) {
    int[] arr1 = {1, 1, 2, 2, 3, 3, 4};
    int count = removeDuplicates(arr1);
    System.out.println("Count: " + count);  // 4
    System.out.println(Arrays.toString(Arrays.copyOf(arr1, count)));  
    // Output: [1, 2, 3, 4]
    
    int[] arr2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    count = removeDuplicates(arr2);
    System.out.println("Count: " + count);  // 5
    System.out.println(Arrays.toString(Arrays.copyOf(arr2, count)));  
    // Output: [0, 1, 2, 3, 4]
}
```

### Solution 2: Using HashSet (For Unsorted)
```java
import java.util.HashSet;

public static int[] removeDuplicatesHashSet(int[] arr) {
    if (arr.length == 0) return new int[0];
    
    HashSet<Integer> seen = new HashSet<>();
    int[] result = new int[arr.length];
    int index = 0;
    
    for (int num : arr) {
        if (!seen.contains(num)) {
            result[index++] = num;
            seen.add(num);
        }
    }
    
    return Arrays.copyOf(result, index);
}

// Test
int[] result = removeDuplicatesHashSet(new int[]{1, 2, 2, 3, 1, 4, 3});
System.out.println(Arrays.toString(result));  // [1, 2, 3, 4]
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
```

### Solution 1: Two-Pointer (BEST!)
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
public static void main(String[] args) {
    int[] arr1 = {1, 2, 3, 4, 5};
    reverseArray(arr1);
    System.out.println(Arrays.toString(arr1));  // [5, 4, 3, 2, 1]
    
    int[] arr2 = {1, 2};
    reverseArray(arr2);
    System.out.println(Arrays.toString(arr2));  // [2, 1]
}
```

### Solution 2: Loop with Index
```java
public static void reverseArrayV2(int[] arr) {
    for (int i = 0; i < arr.length / 2; i++) {
        int temp = arr[i];
        arr[i] = arr[arr.length - 1 - i];
        arr[arr.length - 1 - i] = temp;
    }
}

// Test - same results
```

### Solution 3: Create New Array
```java
public static int[] reverseArrayCopy(int[] arr) {
    int[] result = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
        result[i] = arr[arr.length - 1 - i];
    }
    return result;
}

// Test
int[] arr = {1, 2, 3, 4, 5};
int[] reversed = reverseArrayCopy(arr);
System.out.println(Arrays.toString(reversed));  // [5, 4, 3, 2, 1]
```

**Time:** O(n) | **Space:** O(1) in-place, O(n) for copy

---

## PROBLEM 5: Rotate Array Left by k

### Statement
Rotate array to the left by k positions.

### Examples
```
Input: [1, 2, 3, 4, 5], k = 2
Output: [3, 4, 5, 1, 2]

Input: [1, 2, 3, 4, 5], k = 7
Output: [3, 4, 5, 1, 2]  (k % 5 = 2)
```

### Solution 1: New Array (Simplest)
```java
public static int[] rotateLeft(int[] arr, int k) {
    if (arr.length == 0) return arr;
    
    k = k % arr.length;  // IMPORTANT!
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
public static void main(String[] args) {
    System.out.println(Arrays.toString(rotateLeft(new int[]{1, 2, 3, 4, 5}, 2)));
    // Output: [3, 4, 5, 1, 2]
    
    System.out.println(Arrays.toString(rotateLeft(new int[]{1, 2, 3, 4, 5}, 7)));
    // Output: [3, 4, 5, 1, 2]
}
```

### Solution 2: In-Place with Reversal (OPTIMAL!)
```java
private static void reversePartial(int[] arr, int start, int end) {
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}

public static void rotateLeftInPlace(int[] arr, int k) {
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
public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    rotateLeftInPlace(arr, 2);
    System.out.println(Arrays.toString(arr));  // [3, 4, 5, 1, 2]
    
    // Walkthrough:
    // Original:     [1, 2, 3, 4, 5]
    // Reverse [0,1]: [2, 1, 3, 4, 5]
    // Reverse [2,4]: [2, 1, 5, 4, 3]
    // Reverse all:   [3, 4, 5, 1, 2] ✓
}
```

### Solution 3: Rotate Right
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
System.out.println(Arrays.toString(rotateRight(new int[]{1, 2, 3, 4, 5}, 2)));
// Output: [4, 5, 1, 2, 3]
```

**Time:** O(n) | **Space:** O(1) in-place, O(n) for new array

---

## PROBLEM 6: Sum, Average, and Max

### Statement
Calculate sum, average, and maximum in one pass.

### Solution
```java
public static void sumAvgMax(int[] arr) {
    if (arr.length == 0) {
        System.out.println("Empty array");
        return;
    }
    
    int sum = 0;
    int maxVal = arr[0];
    
    for (int num : arr) {
        sum += num;
        if (num > maxVal) {
            maxVal = num;
        }
    }
    
    double average = (double) sum / arr.length;
    System.out.printf("Sum: %d, Avg: %.2f, Max: %d%n", sum, average, maxVal);
}

// Test
public static void main(String[] args) {
    sumAvgMax(new int[]{10, 20, 30, 5});
    // Output: Sum: 65, Avg: 16.25, Max: 30
}
```

**Time:** O(n) | **Space:** O(1)

---

## PROBLEM 7: Max, Min, and Difference

### Statement
Find maximum, minimum, and their difference in single pass.

### Examples
```
Input: [3, 7, 2, 8, 1]
Output: max=8, min=1, diff=7
```

### Solution
```java
public static void findMaxMinDiff(int[] arr) {
    if (arr.length == 0) {
        System.out.println("Empty array");
        return;
    }
    
    int maxVal = arr[0];
    int minVal = arr[0];
    
    for (int num : arr) {
        if (num > maxVal) maxVal = num;
        if (num < minVal) minVal = num;
    }
    
    int difference = maxVal - minVal;
    System.out.printf("Max: %d, Min: %d, Diff: %d%n", maxVal, minVal, difference);
}

// Test
public static void main(String[] args) {
    findMaxMinDiff(new int[]{3, 7, 2, 8, 1});  // Max: 8, Min: 1, Diff: 7
    findMaxMinDiff(new int[]{5, 5, 5});        // Max: 5, Min: 5, Diff: 0
    findMaxMinDiff(new int[]{-5, -2, -10});    // Max: -2, Min: -10, Diff: 8
}
```

**Time:** O(n) | **Space:** O(1)

---

## PROBLEM 8: Reverse Partial Array

### Statement
Reverse only elements from index start to end (inclusive).

### Examples
```
Input: [1, 2, 3, 4, 5], start=1, end=3
Output: [1, 4, 3, 2, 5]
```

### Solution
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

// Test
public static void main(String[] args) {
    int[] arr1 = {1, 2, 3, 4, 5};
    reversePartial(arr1, 1, 3);
    System.out.println(Arrays.toString(arr1));  // [1, 4, 3, 2, 5]
    
    int[] arr2 = {1, 2, 3, 4, 5};
    reversePartial(arr2, 0, 4);
    System.out.println(Arrays.toString(arr2));  // [5, 4, 3, 2, 1]
}
```

**Time:** O(n) | **Space:** O(1)

---

## PROBLEM 9: Count Duplicates

### Statement
Count how many duplicate elements exist (count extras, not unique).

### Examples
```
Input: [1, 2, 2, 3, 3, 3, 4]
Output: 3 (one extra 2, two extra 3s)

Input: [1, 2, 3, 4]
Output: 0
```

### Solution
```java
import java.util.HashSet;

public static int countDuplicates(int[] arr) {
    HashSet<Integer> seen = new HashSet<>();
    int duplicateCount = 0;
    
    for (int num : arr) {
        if (seen.contains(num)) {
            duplicateCount++;
        } else {
            seen.add(num);
        }
    }
    
    return duplicateCount;
}

// Test
public static void main(String[] args) {
    System.out.println(countDuplicates(new int[]{1, 2, 2, 3, 3, 3, 4}));  // 3
    System.out.println(countDuplicates(new int[]{1, 2, 3, 4}));           // 0
    System.out.println(countDuplicates(new int[]{5, 5, 5, 5}));           // 3
}
```

**Time:** O(n) | **Space:** O(n)

---

## PROBLEM 10: Average of Positive Elements Only

### Statement
Calculate average of only non-negative elements (>= 0).

### Examples
```
Input: [1, -2, 3, -4, 5]
Output: 3.0 (average of 1, 3, 5)

Input: [-1, -2, -3]
Output: 0 (no positive elements)
```

### Solution
```java
public static double averagePositive(int[] arr) {
    int sum = 0;
    int count = 0;
    
    for (int num : arr) {
        if (num >= 0) {
            sum += num;
            count++;
        }
    }
    
    if (count == 0) return 0;
    return (double) sum / count;
}

// Test
public static void main(String[] args) {
    System.out.println(averagePositive(new int[]{1, -2, 3, -4, 5}));  // 3.0
    System.out.println(averagePositive(new int[]{-1, -2, -3}));       // 0.0
    System.out.println(averagePositive(new int[]{0, 0, 0}));          // 0.0
}
```

**Time:** O(n) | **Space:** O(1)

---

## COMPLETE TEST CLASS

```java
import java.util.Arrays;
import java.util.HashSet;

public class ArrayProblems {
    
    public static void main(String[] args) {
        System.out.println("=== PROBLEM 1: Find Max ===");
        System.out.println(findMax(new int[]{3, 1, 4, 1, 5, 9}));  // 9
        
        System.out.println("\n=== PROBLEM 2: Second Max ===");
        System.out.println(findSecondMax(new int[]{10, 5, 20, 8}));  // 10
        
        System.out.println("\n=== PROBLEM 3: Remove Duplicates ===");
        int[] arr3 = {1, 1, 2, 2, 3, 3, 4};
        int count = removeDuplicates(arr3);
        System.out.println(Arrays.toString(Arrays.copyOf(arr3, count)));  // [1, 2, 3, 4]
        
        System.out.println("\n=== PROBLEM 4: Reverse ===");
        int[] arr4 = {1, 2, 3, 4, 5};
        reverseArray(arr4);
        System.out.println(Arrays.toString(arr4));  // [5, 4, 3, 2, 1]
        
        System.out.println("\n=== PROBLEM 5: Rotate Left ===");
        System.out.println(Arrays.toString(rotateLeft(new int[]{1, 2, 3, 4, 5}, 2)));
        // [3, 4, 5, 1, 2]
        
        System.out.println("\n=== PROBLEM 6: Sum/Avg/Max ===");
        sumAvgMax(new int[]{10, 20, 30, 5});  // Sum: 65, Avg: 16.25, Max: 30
        
        System.out.println("\n=== PROBLEM 9: Count Duplicates ===");
        System.out.println(countDuplicates(new int[]{1, 2, 2, 3, 3, 3, 4}));  // 3
        
        System.out.println("\n=== PROBLEM 10: Average Positive ===");
        System.out.println(averagePositive(new int[]{1, -2, 3, -4, 5}));  // 3.0
    }
    
    // [Include all solution methods here]
}
```

---

## STUDY TIPS FOR JAVA ARRAYS

✅ **Type the code** - Don't just read it
✅ **Test in IDE** - Use IntelliJ or Eclipse
✅ **Use Arrays.toString()** - To verify results
✅ **Import java.util.Arrays** - For utility methods
✅ **Test edge cases** - Empty, single element, negatives
✅ **Remember .length** - Not .length() for arrays

Good luck on your exam! 💪
