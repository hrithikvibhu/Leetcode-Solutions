class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        for(String p : path.split("/")){
            if(!s.isEmpty() && p.equals(".."))
                s.pop();
            else if (!p.equals(".") && !p.equals("..") && !p.equals(""))
                s.push(p);
        }
        return "/"+String.join("/",s);
    }
}