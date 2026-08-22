class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

    Map<Integer,Integer> freq = new HashMap<>();
    for(int n : nums){
      freq.put(n,freq.getOrDefault(n,0)+1);
    }

    for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
      pq.offer(entry);
      if(pq.size() > k){
        pq.poll();
      }
    }
    int[] res = new int[k];
    for(int i = 0; i < k; i++){
      res[i] = pq.poll().getKey();
    }

    return res;
        
    }
}
