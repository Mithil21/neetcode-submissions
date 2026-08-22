class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

    int[][] newArray = new int[intervals.length + 1][2];

    for (int i = 0; i < intervals.length; i++) {
        newArray[i] = intervals[i];
    }

    newArray[intervals.length] = newInterval;

    Arrays.sort(newArray, (a, b) -> Integer.compare(a[0], b[0]));

    List<int[]> result = new ArrayList<>();

    int[] curr = newArray[0];
    result.add(curr);

    for (int i = 1; i < newArray.length; i++) {
        int[] next = newArray[i];

        if (curr[1] >= next[0]) {
            curr[1] = Math.max(curr[1], next[1]);
        } else {
            curr = next;
            result.add(curr);
        }
    }

    return result.toArray(new int[result.size()][]);
}
}
