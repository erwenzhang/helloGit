/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root==null) return new ArrayList<List<Integer>>();
        List<List<Integer>> rets = new ArrayList<>();
        DFS(root, rets);
        return rets;
    }
    
    public int DFS(TreeNode node, List<List<Integer>> rets){
        if(node==null) return -1;
        int l = DFS(node.left,rets);
        int r = DFS(node.right,rets);
        int tmp = Math.max(l,r)+1;
        if(rets.size()<tmp+1)
            rets.add(new ArrayList<Integer>());
        rets.get(tmp).add(node.val);
        return tmp;
    }
}
