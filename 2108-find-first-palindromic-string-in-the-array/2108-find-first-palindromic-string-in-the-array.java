class Solution {
    public String firstPalindrome(String[] words) {
        for(String str : words){
            if(isPal(str))
                return str;
        }
        return "";
    }
    
    private boolean isPal(String str){
        int n = str.length();
        int l =0 , r = n-1;
        while(l<r){
            if(str.charAt(l)!=str.charAt(r)){
                return false;
            }
            l++;r--;
        }
        return true;
    }
}