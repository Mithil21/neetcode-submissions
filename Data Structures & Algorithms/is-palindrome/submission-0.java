class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        String[] arr = s.split(" ");

        for(String str : arr){
            builder.append(str);
        }

        int left = 0, right = builder.length() - 1;

        while(left <= right){
            if(builder.charAt(left) != builder.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
