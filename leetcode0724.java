public class leetcode0724 {
    public int pivotIndex(int[] nums){
        int lsum[]=new int[nums.length];
        int rsum[]=new int[nums.length];

        lsum[0]=0;
        for(int i=0;i<nums.length;i++){
            lsum[i]=lsum[i-1]+nums[i-1];
        }

        rsum[nums.length]=0;
        for(int i=nums.length-2;i>=0;i--){
            rsum[i]=rsum[i+1]+nums[i+1];
        }

        for(int i:nums){
            if(lsum[i]==rsum[i]){
                return i;
            }
        }
        return -1;
    }
}

