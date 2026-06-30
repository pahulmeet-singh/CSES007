public class CountSetBits {
    public static void main(String[] args) {
        int n = 5; // Example number
        int count = countSetBits(n);
        System.out.println("Number of set bits in " + n + " is: " + count);
    }

    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1; // Increment count if the least significant bit is set
            n >>= 1; // Right shift n to check the next bit
        }
        return count;
    }
}

