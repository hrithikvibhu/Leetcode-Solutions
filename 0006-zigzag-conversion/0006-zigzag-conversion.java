class Solution {
    public String convert(String s, int n) {
        StringBuilder[] sb= new StringBuilder[n];
        for(int i=0;i<n;i++)
            sb[i] = new StringBuilder();
        
        int i=0;
        int len = s.toCharArray().length;
        char[] c = s.toCharArray();
        while(i < len){
            for(int j=0;j<n && i<len;j++)
                sb[j].append(c[i++]);
            for(int j=n-2;j>0 && i<len;j--)
                sb[j].append(c[i++]);
        }
        
        for(int j=1;j<n;j++)
            sb[0].append(sb[j].toString());
        
        return sb[0].toString();
    }
}