/// Palindrome number check
//-------------------------half reversal method(most optimized) --------------------
// - instead of reversing the whole number, reverse only half the digits and compare.
// - example for 1221, reverse last half->12, compare it with the first half->12
// - this avoid overflow for very large numbers and is slightly faster

public class Palindrome {
    public static void main(String[] args) {
        int num = 12321;
        if (isPalindrome(num)) {
            System.out.println(num + " is a palindrome.");
        } else {
            System.out.println(num + " is not a palindrome.");
        }
    }

    public static boolean isPalindrome(int x) {
        // Negative numbers and numbers ending with 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // For even length numbers, x should equal reversedHalf
        // For odd length numbers, we can ignore the middle digit by reversedHalf/10
        return x == reversedHalf || x == reversedHalf / 10;
    }
}