class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int remaining,int start, List<Integer> path, List<List<Integer>> res) {
        if (remaining == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (remaining < 0) return;

        for (int i = start; i<nums.length;i++) {
            path.add(nums[i]);
            backtrack(nums, remaining - nums[i],i,path, res);
            path.remove(path.size()-1);
        }
    }
}
