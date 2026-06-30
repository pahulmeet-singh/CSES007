/* problem- use XOR to find a missing element in a sequence; count set bits efficiently; find the kth bit of a number; find the maximum AND value of two numbers in an array; count the longest trail of 1s in a number; linear search questions

idea: XOR of identical numbers cancels out. If an array contains all numbers from 1...n except one, XORing all indices and array elements yields the missing number.

XOR Trick for missing numbers:
    - XOR of a number with itself is 0: a^a=0
    - XOR of a number with 0 is the number itself: a^0=a
    - XOR is commutative and associative: a^b^c = c^a allowing it to cancel duplicates regardless of order
    - 
*/
public class missingNumber {
    
}
