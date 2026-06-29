//Linear Search Implementation. finding all the occurrences of a target element in an array:
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 5, 2};
        int target = 2;
        int[] result = linearSearch(arr, target);
        
        if (result.length > 0) {
            System.out.print("Target found at indices: ");
            for (int index : result) {
                System.out.print(index + " ");
            }
        } else {
            System.out.println("Target not found in the array.");
        }
    }

    public static int[] linearSearch(int[] arr, int target) {
        // Count occurrences of the target
        int count = 0;
        for (int num : arr) {
            if (num == target) {
                count++;
            }
        }

        // If no occurrences found, return an empty array
        if (count == 0) {
            return new int[0];
        }

        // Store indices of occurrences
        int[] indices = new int[count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                indices[index++] = i;
            }
        }

        return indices;
    }
}



/*core FAANG style linear search questions:
1. Given an array of integers, find the first occurrence of a target element and return its index. If the target is not found, return -1.
2. Given an array of integers, find the last occurrence of a target element and return its index. If the target is not found, return -1.
3. Given an array of integers, count the number of occurrences of a target element and return the count.
4. Given an array of integers, find all the indices of a target element and return them in an array. If the target is not found, return an empty array.
5. Given an array of integers, check if a target element exists in the array and return true or false.
6. Given an array of integers, find the index of the first element that is greater than a target value. If no such element exists, return -1.
7. Given an array of integers, find the index of the last element that is less than a target value. If no such element exists, return -1.
8. Given an array of integers, find the index of the first element that is equal to or greater than a target value. If no such element exists, return -1.
9. Given an array of integers, find the index of the last element that is equal to or less than a target value. If no such element exists, return -1.
10. Given an array of integers, find the index of the first element that is a multiple of a target value. If no such element exists, return -1.
11. Given an array of integers, find the index of the last element that is a multiple of a target value. If no such element exists, return -1.
12. Given an array of integers, find the index of the first element that is a prime number. If no such element exists, return -1.
13. Given an array of integers, find the index of the last element that is a prime number. If no such element exists, return -1.
14. Given an array of integers, find the index of the first element that is a perfect square. If no such element exists, return -1.
15. Given an array of integers, find the index of the last element that is a perfect square. If no such element exists, return -1.
16. Given an array of integers, find the index of the first element that is a Fibonacci number. If no such element exists, return -1.
17. Given an array of integers, find the index of the last element that is a Fibonacci number. If no such element exists, return -1.
18. Given an array of integers, find the index of the first element that is a palindrome number. If no such element exists, return -1.
19. Given an array of integers, find the index of the last element that is a palindrome number. If no such element exists, return -1.
20. Given an array of integers, find the index of the first element that is a perfect cube. If no such element exists, return -1.
21. Given an array of integers, find the index of the last element that is a perfect cube. If no such element exists, return -1.
22. Given an array of integers, find the index of the first element that is a power of two. If no such element exists, return -1.
23. Given an array of integers, find the index of the last element that is a power of two. If no such element exists, return -1.*/