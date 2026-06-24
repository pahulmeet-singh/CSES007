public class prefixsum {
    public static void main(String[] args) {
        int nums[]={2,4,8,9,11};

        System.out.println("Prefix sums:");
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            System.out.println(sum);
        }

        System.out.println("Suffix sums:");
        int[] suffix = new int[nums.length];
        int suffixSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            suffixSum += nums[i];
            suffix[i] = suffixSum;
        }

        for (int i = 0; i < suffix.length; i++) {
            System.out.println(suffix[i]);
        }
    }
}
     