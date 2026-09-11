class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        int farthest = 0;
        for(;i < nums.length; i++){
            if(i > farthest){
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);
        }

        return true;
    }
}
