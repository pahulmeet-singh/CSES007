//this algo measures how far an array is from being sorted. It counts the number of inversions in the array. An inversion is a pair of indices (i, j) such that i < j and arr[i] > arr[j]. The number of inversions in an array can be used to determine how "unsorted" the array is. A sorted array has 0 inversions, while a reverse sorted array has the maximum number of inversions.
public class InversionCount {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        int n = arr.length;
        int inversionCount = countInversions(arr, n);
        System.out.println("Number of inversions: " + inversionCount);
    }

    public static int countInversions(int[] arr, int n) {
        int[] temp = new int[n];
        return mergeSortAndCount(arr, temp, 0, n - 1);
    }

    private static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int mid, invCount = 0;
        if (right > left) {
            mid = (right + left) / 2;

            invCount += mergeSortAndCount(arr, temp, left, mid);
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);

            invCount += mergeAndCount(arr, temp, left, mid + 1, right);
        }
        return invCount;
    }

    private static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left; // Starting index for left subarray
        int j = mid; // Starting index for right subarray
        int k = left; // Starting index to be sorted
        int invCount = 0;

        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i); // Count inversions
            }
        }

        while (i <= mid - 1)
            temp[k++] = arr[i++];

        while (j <= right)
            temp[k++] = arr[j++];

        for (i = left; i <= right; i++)
            arr[i] = temp[i];

        return invCount;
    }
}