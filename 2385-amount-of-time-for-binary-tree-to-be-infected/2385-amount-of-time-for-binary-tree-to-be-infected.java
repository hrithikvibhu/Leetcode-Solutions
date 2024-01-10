/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, List<Integer>> node_map = new HashMap<>();
    int infected ;
    int s ;
    public int amountOfTime(TreeNode root, int start) {
        s = start;
        buildMap(root);
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        q.offer(infected);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int popped = q.poll();
                set.add(popped);
                for(int child : node_map.get(popped)){
                    if(!set.contains(child))
                        q.offer(child);
                }
            }
             if(q.size()>0) ans++;
        }
        return ans;
    }
    
    public void buildMap(TreeNode root){
        if(root==null)
            return;
        if(root.val == s)
            infected = root.val;
        node_map.putIfAbsent(root.val , new ArrayList<>());
        
        if(root.left==null && root.right==null)
            return;
        
        if(root.left!=null){
            node_map.putIfAbsent(root.left.val , new ArrayList<>());
            node_map.get(root.left.val).add(root.val);
            node_map.get(root.val).add(root.left.val);
        }
        if(root.right!=null){
            node_map.putIfAbsent(root.right.val , new ArrayList<>());
            node_map.get(root.right.val).add(root.val);
            node_map.get(root.val).add(root.right.val);
        }
        buildMap(root.left);
        buildMap(root.right);
    }
}