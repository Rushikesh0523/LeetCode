class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0;
        return dfs(nums, S, 0, 0, 0);
    }
    private int dfs(int[] nums, int S, int index, int cur, int start){
        if(index == nums.length){
            return cur == S ? 1 : 0;
        }else{
            return dfs(nums, S, start + 1, cur + nums[start], start + 1)
                    + dfs(nums, S, start + 1, cur - nums[start], start + 1);
        }
    }
}