class Solution {
    public void helper(int[] candidate, int target, int idx, List<Integer> comb, List<List<Integer>> res){
        if(target < 0){
            return;
        }

        if(target == 0){
            res.add(new ArrayList<>(comb));
        }

        for(int i = idx; i < candidate.length; i++){
            if(i > idx && candidate[i] == candidate[i - 1]){
                continue;  //skip
            }

            if(candidate[i] > target){
                break;
            }

            comb.add(candidate[i]);
            helper(candidate, target - candidate[i], i + 1, comb, res);
            comb.remove(comb.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        helper(candidates,target,0,new ArrayList<>(), res);
        return res;
    }
}
