class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groupMap = new HashMap<>();

        for(String s : strs){
          char[] arr = s.toCharArray();

          Arrays.sort(arr);

          String newStr = new String(arr);
          if(groupMap.containsKey(newStr)){
            List<String> anagrams = groupMap.get(newStr);
            anagrams.add(s);
            groupMap.put(newStr,anagrams);
          }else{
            List<String> anagrams = new ArrayList<>();
            anagrams.add(s);
            groupMap.put(newStr,anagrams);
          }
        }

        List<List<String>> result = new ArrayList<>();
        result.addAll(groupMap.values());

        return result;
    }
}
