class Solution {

    public String encode(List<String> strs) {

    StringBuilder builder = new StringBuilder();
    for(String s : strs){
      builder.append(s.length()).append("#").append(s);
    }

    return builder.toString();

    }

    public List<String> decode(String s) {

      List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(s.substring(i, j));
            int start = j + 1;
            result.add(s.substring(start, start + length));
            i = start + length;
        }
        return result;

    }
}
