class Solution {
    public List<Integer> majorityElement(int[] nums) {
         List<Integer> res = new ArrayList<>();
        int count1=0,count2=0,a=0,b=0;
        for(int n: nums){
            if(a==n)
                count1++;
            else if (b==n)
                count2++;
            else if(count1==0){
                count1=1;
                a=n;
            }
            else if(count2==0){
                count2=1;
                b = n;
            }
            else{
                count1--;
                count2--;
            }
        }
        System.out.println(a+" "+b);
        count1=count2=0;
        for(int n : nums){
            if(n==a)count1++;
            else if(n==b)count2++;
        }
        if(count1 > nums.length/3) res.add(a)  ;
        if(count2 > nums.length/3) res.add(b)  ;
        return res;
    }
}