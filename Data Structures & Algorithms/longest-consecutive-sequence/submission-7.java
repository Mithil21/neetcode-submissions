class Solution {
    public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    Set<Integer> set = new HashSet<>();
    for (int num : nums) set.add(num);

    int maxSize = 0;

    for (int num : set) {
        if (!set.contains(num - 1)) { // only start counting here
            int length = 1;
            int current = num;
            while (set.contains(current + 1)) {
                current++;
                length++;
            }
            maxSize = Math.max(maxSize, length);
        }
    }

    return maxSize;
}
}
