class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder str = new StringBuilder();
        for(String word : words){
            char[] c = word.toCharArray();
            for(int i=c.length-1;i>=0;i--){
                str.append(String.valueOf(c[i]));
            } 
            str.append(" ");
        }
        String res = str.toString();
        return res.substring(0,res.length()-1);
    }
}