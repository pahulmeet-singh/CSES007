/*pseudocode
function iskthbitset(n,k):
mask=1<<k
if(n & mask) != 0:
    return true
else:
    return false
    */
public class kthBit {
    public static void main(String[] args) {
        int n = 5; // Example number
        int k = 1; // Example bit position (0-indexed)
        
        boolean isSet = isKthBitSet(n, k);
        
        if (isSet) {
            System.out.println("bit " + k + " of " + n + " is set.");
        } else {
            System.out.println("bit " + k + " of " + n + " is not set.");
        }
    }

    public static boolean isKthBitSet(int n, int k) {
        int mask = 1 << k; // Create a mask by left-shifting 1 by k positions
        return (n & mask) != 0; // Check if the kth bit is set
    }
}
