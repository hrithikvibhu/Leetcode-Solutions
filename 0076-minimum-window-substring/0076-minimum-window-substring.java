class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int l=0,r=0,count=m;
        int[] map = new int[128];
        String res = "";
        for(char c : t.toCharArray())
            map[c]++;
        
        int min = Integer.MAX_VALUE;
        int start=0;
        
        while(r<n){
            if(map[s.charAt(r)]>0)
                count--;
            map[s.charAt(r)]--;
            while(count==0){
                if(r-l<min){
                    min = r-l;
                    start = l;
                }
                map[s.charAt(l)]++;
                if(map[s.charAt(l)]>0)
                    count++;
                l++;
            }
            r++;
        }
        return min==Integer.MAX_VALUE?"":s.substring(start,start+min+1);
    }
}