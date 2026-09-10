class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // set up result and current, call backtrack, return result
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(nums, 0, current, result);
        return result;
    }


    public void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> res){
        res.add(new ArrayList<>(current));

        for(int i = index; i < nums.length; i++){
            current.add(nums[i]);
            backtrack(nums, i + 1, current, res);
            current.remove(current.size() - 1);
        }
    }
}
