class Solution {
    public int characterReplacement(String s, int k) {
    int left = 0, maxLen = 0, maxFreq = 0;
    Map<Character, Integer> freqMap = new HashMap<>();

    // Using a for-loop naturally increments our right pointer
    for (int right = 0; right < s.length(); right++) {
        char rightChar = s.charAt(right);
        
        // 1. Add the new character to our map
        freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
        
        // 2. Update our running maximum frequency
        maxFreq = Math.max(maxFreq, freqMap.get(rightChar));
        
        // 3. Check if the current window size minus maxFreq exceeds k
        // If it does, the window is invalid and we must shrink from the left
        while ((right - left + 1) - maxFreq > k) {
            char leftChar = s.charAt(left);
            freqMap.put(leftChar, freqMap.get(leftChar) - 1);
            left++;
        }
        
        // 4. Now that the window is valid, check if it's the longest we've seen
        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}
}
