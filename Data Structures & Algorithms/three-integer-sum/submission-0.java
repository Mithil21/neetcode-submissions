class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);

    int left = 1, right = nums.length - 1;
    List<List<Integer>> result = new ArrayList<>();

    for(int k = 0; k < nums.length;k++){
      if(k > 0 && nums[k] == nums[k - 1]){
        continue;
      }
      left = k + 1;
      right = nums.length - 1;
      while(left < right){
        int sum = nums[k] + nums[left] + nums[right];
        if(sum == 0){
          result.add(Arrays.asList(nums[k], nums[left], nums[right]));

          left++;
          right--;

          while(left < right && nums[left - 1] == nums[left]) left++;
          while(left < right && nums[right + 1] == nums[right]) right--;
        } else if(sum < 0){
          left++;
        }else {
          right--;
        }
      }
      }
    return result;


    }
}
