class Solution {
    public String largestGoodInteger(String num) {
        int res = Integer.MIN_VALUE;
        for(int i=2;i<num.length();i++){
            if(num.charAt(i) == num.charAt(i-1) && num.charAt(i) == num.charAt(i-2)){
                int n = num.charAt(i)-'0';
                int good = 100*n + 10*n + n;
                // System.out.println(num.charAt(i));
                res = Math.max(res , good);
            }
        }
        if(res!=Integer.MIN_VALUE){
            if(res!=0) return String.valueOf(res);
            else return "000";
        }
        else
            return "";
    }
}