// find out the largest possible digit that can be made using array elements
//     > given array:[3,30,34,5,9]
//     largest possible number: 9534330
public class largestNumber {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        String result = largestNumber(nums);
        System.out.println(result);
    }

    public static String largestNumber(int[] nums) {
        // Convert the array of integers to an array of strings
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort the array of strings based on custom comparator
        java.util.Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is "0", return "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build the largest number by concatenating the sorted strings
        StringBuilder largestNum = new StringBuilder();
        for (String str : strNums) {
            largestNum.append(str);
        }

        return largestNum.toString();
    }
}