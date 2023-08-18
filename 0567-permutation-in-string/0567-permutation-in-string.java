class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for(char c : s1.toCharArray()){
            count1[c-'a']++;
        }
        
        int l=0,r=0,n=s2.length();
        while(r<n){
            count2[s2.charAt(r)-'a']++;
            if(r-l+1 == s1.length()){
                if(Arrays.equals(count1,count2)) 
                    return true;
                count2[s2.charAt(l)-'a']--;
                l++;
            }
            r++;
        }
        return false;
    }
    
}