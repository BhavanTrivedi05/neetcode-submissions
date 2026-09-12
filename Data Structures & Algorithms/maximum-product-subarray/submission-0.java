class Solution {
    public int maxProduct(int[] nums) {
        int best = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];
        for (int i = 1;i<nums.length;i++){
            int n = nums[i];
            int tempMax = curMax;
            curMax = Math.max(n, Math.max(curMax*n, curMin*n));
            curMin = Math.min(n, Math.min(tempMax*n, curMin*n));
            best = Math.max(best,curMax);
        }
        return best;
    }
}
