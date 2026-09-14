class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;


        if(nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            return Math.min(nums[0],nums[1]);
        }

        if(nums.length == 3){
            return Math.min(nums[0], Math.min(nums[1], nums[2]));
        }


        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
