class KthLargest {
    int k;
    List<Integer> list;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }
    }
    
    public int add(int val) {
        list.add(val);
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       for(int x : list){
           minHeap.offer(x);
           if(minHeap.size() > k){
               minHeap.poll();
           }
       }
        return minHeap.isEmpty() ? 0 : minHeap.peek();
    }
}
