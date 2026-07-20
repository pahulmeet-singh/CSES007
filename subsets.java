import java.util.ArrayList;
import java.util.List;

public class subsets {
    public static void main(String[] args) {
        subsets obj = new subsets();
        int[] nums = {1, 2, 3};
        System.out.println(obj.new Solution().subsets(nums));
    }

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            backtrack(ans, new ArrayList<>(), nums, 0);
            return ans;
        }

        private void backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] nums, int start) {
            ans.add(new ArrayList<>(tempList));
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(ans, tempList, nums, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
