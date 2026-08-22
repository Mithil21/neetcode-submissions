class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int n : nums){
          freq.put(n,freq.getOrDefault(n,0)+1);
        }

        for(Map.Entry<Integer,Integer> e : freq.entrySet()){
          if(e.getValue() > 1){
            return true;
          }
        }
        return false;
  }
}