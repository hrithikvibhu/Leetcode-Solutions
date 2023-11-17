class Solution {
    public List<Integer> partitionLabels(String s) {
        int l=0,r=0;
        int n = s.length();
        int[] map = new int[26];
        for(int i=0;i<n;i++){
            map[s.charAt(i)-'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int prev = -1 , maxPart = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            maxPart = Math.max(map[c-'a'] , maxPart);
            if(maxPart == i){
                res.add(maxPart-prev);
                prev = maxPart;
            }
        }
        return res;
    }
}