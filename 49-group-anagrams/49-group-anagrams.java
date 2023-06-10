class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String s1 = new String(c);
            if(map.containsKey(s1)){
                map.get(s1).add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(s1,list);
            }
        }
        
        for(List<String> s : map.values()){
            result.add(s);
        }
        return result;
    }
}