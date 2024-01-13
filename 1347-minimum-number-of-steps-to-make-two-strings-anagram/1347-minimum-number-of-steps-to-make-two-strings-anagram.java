class Solution {
    public int minSteps(String s, String t) {
        int[] a = new int[26];
        int[] b = new int[26];
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)-'a']++;
            b[t.charAt(i)-'a']++;
        }
        
        int res = 0;
        for(int i=0;i<26;i++){
            if(a[i]>b[i])
                res += a[i]-b[i];
        }
        return res;
    }
}