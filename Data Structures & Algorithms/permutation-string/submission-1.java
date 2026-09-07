class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        for (char x : s1.toCharArray()) {
            s1Count[x - 'a']++;
        }

        int needed = 0; // TODO 1: how many distinct letters does s1 actually have?

        for (int j : s1Count) {
            if (j > 0) {
                needed++;
            }
        }

        int matches = 0;
        int left = 0;

        for (int right = 0; right < s2.length(); right++) {
            char addChar = s2.charAt(right);
            // TODO 2: add addChar into windowCount, update matches
            // (you already wrote this part correctly last time)
            windowCount[addChar - 'a']++;

            if(windowCount[addChar - 'a'] == s1Count[addChar - 'a'] + 1){
                matches--;
//                windowCount[addChar - 'a']--;
            }else if(windowCount[addChar - 'a'] == s1Count[addChar - 'a']){
                matches++;
            }

            // TODO 3: if window has grown past s1.length(), shrink from the left
            // (remove s2.charAt(left) from windowCount, update matches, then left++)

            while(right - left + 1 > s1.length()){
                char removeChar = s2.charAt(left);
                if (windowCount[removeChar - 'a'] == s1Count[removeChar - 'a']) {
                    matches--; // was matching, about to lose it
                }
                windowCount[removeChar - 'a']--;
                if (windowCount[removeChar - 'a'] == s1Count[removeChar - 'a']) {
                    matches++; // dropped down into matching
                }
                left++;
            }

            // TODO 4: check if matches == needed, and if so, return true

            if(matches == needed) return true;
        }

        return false;
    }
}
