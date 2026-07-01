// problem: convert binary to gray code and gray code to binary
// graycode is a binary numeral system where two successive values differ in only one bit
public class grayCode {
    public static void main(String[] args) {
        int n = 10; // Example number
        int gray = binaryToGray(n);
        System.out.println("Binary: " + n + " -> Gray Code: " + gray);

        int binary = grayToBinary(gray);
        System.out.println("Gray Code: " + gray + " -> Binary: " + binary);
    }
    public static int binaryToGray(int n) {
        return n ^ (n >> 1); // XOR the number with itself right-shifted by 1
    }
    public static int grayToBinary(int gray) {
        int binary = 0;
        for (; gray > 0; gray >>= 1) {
            binary ^= gray; // XOR the current gray value with the accumulated binary value
        }
        return binary;
    }
}
