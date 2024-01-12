class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int[] map = new int[n];
        for(int i=0;i<n;i++){
            if(isVowel(s.charAt(i)))
                map[i]++;
            
            if(i>0)
                map[i] += map[i-1];
            System.out.print(map[i]);
        }
        int mid = (n-1)/2;
        if(map[mid]==map[n-1]-map[mid])
            return true;
        return false;
    }
    
    boolean isVowel(char ch) {
        // Convert the character to lowercase for case-insensitive checking
        ch = Character.toLowerCase(ch);

        // Check if the character is a vowel
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}