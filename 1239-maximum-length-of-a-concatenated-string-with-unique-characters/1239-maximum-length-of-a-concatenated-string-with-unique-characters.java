class Solution {
    int n;
    int res = 0;
    List<String> ss = new ArrayList<>();
    public int maxLength(List<String> arr) {
        n = arr.size();
        helper(0,arr,"");
        return res;
    }
    
    private void helper(int index , List<String> arr , String str){
        if(res<str.length())
            res = str.length();
        
        for(int i=index;i<arr.size();i++){
            if(!isUnique(str,arr.get(i)))
                continue;
            helper(i+1,arr,str+arr.get(i));
        }
        
    }
    
    private boolean isUnique(String currentString, String newString){
        boolean[] array = new boolean[26]; // less memory than int[]
        for (int i = 0; i < newString.length(); i++) {
            char c = newString.charAt(i); // look up c once
            if (array[c -'a'] || currentString.indexOf(c) != -1) return false; // faster than .contains which throws an error without String concatenation ( +"" )
            array[c -'a'] = true;
        }
        return true;
    }
}