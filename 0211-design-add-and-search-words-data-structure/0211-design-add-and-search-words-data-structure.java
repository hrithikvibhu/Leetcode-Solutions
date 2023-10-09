class WordDictionary {

    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a']==null)
                curr.children[c-'a'] = new Node();
            
                curr = curr.children[c-'a'];    
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return helper(root,word);
    }
    
    public boolean helper(Node root, String word){
        Node curr= root;
        for( int i=0;i<word.length();i++){
            if(word.charAt(i)=='.'){
                for(Node child : curr.children){
                    if(child!=null && helper(child,word.substring(i+1)))
                       return true;
                }
                return false;
            }
                curr = curr.children[word.charAt(i)-'a'];
         
                if(curr == null) return false;
            
        }
        return curr.isWord;
    }
    
    public class Node{
        Node[] children = new Node[26];
        boolean isWord = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */