public class leetcode1480 {
    public int[] runningSum(int[] nums) {
        int x=0;
        for(int i=0;i<nums.length;i++){
            x+=nums[i]; //here i am adding the current element to the sum of previous elements
            nums[i]=x; //here i am replacing the current element with the sum of previous elements and current element
        }
        return nums;
    }
}
