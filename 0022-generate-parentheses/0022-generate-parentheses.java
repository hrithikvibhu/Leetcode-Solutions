class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res,n,n,"");
        return res;
    }
    
    public void helper(List<String> res , int l , int r , String s){
        if(l==0 && r==0) {
            res.add(s);
            return;
        }
        if(l>r)
            return;
        if(l>0)
            helper(res,l-1,r,s+"(");
        if(r>l)
            helper(res,l,r-1,s+")");
    }
}