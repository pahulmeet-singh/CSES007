// Problem- counting longest trails of 1s in a number

public class trailOfOnes {
    public static void main(String[] args) {
        int n = 29; // Example number (binary: 11101)
        int longestTrail = countLongestTrailOfOnes(n);
        System.out.println("The longest trail of 1s in " + n + " is: " + longestTrail);
    }

    public static int countLongestTrailOfOnes(int n) {
        int maxCount = 0;
        int currentCount = 0;

        while (n > 0) {
            if ((n & 1) == 1) { // Check if the least significant bit is 1
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0; // Reset count if we encounter a 0
            }
            n >>= 1; // Right shift n to check the next bit
        }

        return maxCount;
    }
    
}
