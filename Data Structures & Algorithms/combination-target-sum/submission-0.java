class Solution {
public void helper(List<List<Integer>> res, int target, int[] nums, int index, int total, List<Integer> comb){

        if(total == target){
            res.add(new ArrayList<>(comb));
            return;
        }

        if(total > target || index >= nums.length){
            return;
        }

        comb.add(nums[index]);
        helper(res,target, nums, index, total + nums[index], comb);
        comb.remove(comb.size() - 1);
        helper(res,target, nums,index + 1, total, comb);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, target, nums, 0, 0, new ArrayList<>());
        return result;
    }
}
