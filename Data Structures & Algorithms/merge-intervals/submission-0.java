class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] curr = intervals[0];
        list.add(curr);

        for(int i = 1; i < intervals.length; i++){
            int[] next = intervals[i];

            if (curr[1] >= next[0]) {   // Overlapping
    curr[1] = Math.max(curr[1], next[1]);
} else {                    // No overlap
    curr = next;
    list.add(curr);
}
        }
        return list.toArray(new int[0][]);
    }
}
