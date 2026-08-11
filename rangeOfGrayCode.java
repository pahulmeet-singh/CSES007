//problem: print the range of gray codes when the user enters the range values.
public class rangeOfGrayCode {
    public static void main(String[] args) {
        int start = 0; // Starting value of the range
        int end = 15;  // Ending value of the range

        System.out.println("Gray codes in the range [" + start + ", " + end + "]:");
        for (int i = start; i <= end; i++) {
            int grayCode = binaryToGray(i);
            System.out.println("Binary: " + i + " -> Gray Code: " + grayCode);
        }
    }

    public static int binaryToGray(int n) {
        return n ^ (n >> 1); // XOR the number with itself right-shifted by 1
    }
}