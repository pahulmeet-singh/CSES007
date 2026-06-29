//binary search for strings



public class BinarySearchStrings {
    public static void main(String[] args) {
        String[] arr = {"apple", "banana", "cherry", "date", "fig", "grape"};
        String target = "cherry";
        int result = binarySearch(arr, target, 0, arr.length - 1);
        
        if (result != -1) {
            System.out.println("target found at index: " + result);
        } else {
            System.out.println("target not found in the array.");
        }
    }

    public static int binarySearch(String[] arr, String target, int left, int right) {
        if (left > right) {
            return -1; // Target not found
        }
        
        int mid = left + (right - left) / 2;
        
        int comparison = arr[mid].compareTo(target);
        
        if (comparison == 0) {
            return mid; // Target found
        } else if (comparison < 0) {
            return binarySearch(arr, target, mid + 1, right); // searching in the right half
        } else {
            return binarySearch(arr, target, left, mid - 1); // searching in the left half
        }
    }
}
