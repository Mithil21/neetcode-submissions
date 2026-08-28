class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        if(stones == null) return 0;

        if(stones.length == 1) return stones[0];

        for(int stone : stones){
            queue.offer(stone);
        }

        while(queue.size() > 1){
            int a = queue.poll();
            int b = queue.poll();

            if(a != b){
                queue.offer(a - b);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
