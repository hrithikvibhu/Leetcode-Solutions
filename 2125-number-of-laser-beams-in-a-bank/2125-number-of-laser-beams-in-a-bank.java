class Solution {
    public int numberOfBeams(String[] bank) {
        int res = 0;
        int prev = 0;
        boolean single = false;
        for(int i=0;i<bank.length;i++){
            int ones = count(bank[i]);
            if(ones ==0)
                continue;
            if(i>0){
                if(ones >0) single = true;
                res += prev*ones;
            }
            prev = ones;
        }
        return single==true ? res : 0;
    }
    
    public int count(String str){
        int res = 0;
        for(char c : str.toCharArray()){
            if(c=='1')
                res++;
        }
        return res;
    }
}