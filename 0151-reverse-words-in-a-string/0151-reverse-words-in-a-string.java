class Solution {
    public String reverseWords(String str) {
        // List<Character> list = new ArrayList<>();
        str = str.trim();
        StringBuilder sb = new StringBuilder();
        String[] s = str.split(" ");
        for(int i=s.length-1;i>=0;i--){
            if(s[i]!=""){
                sb.append(s[i].trim()).append(" ");
            }
        }
        String res = sb.toString();
        return res.substring(0,res.length()-1);
        // return " ";
    }
}