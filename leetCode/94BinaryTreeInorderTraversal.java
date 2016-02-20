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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rets = new ArrayList<>();
        if(root==null) return rets;
        rets.addAll(inorderTraversal(root.left));
        rets.add(root.val);
        rets.addAll(inorderTraversal(root.right));
        return rets;
    }
    
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> rets = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(root!=null||!st.isEmpty()){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            rets.add(root.val);
            root = root.right;
        }
        return rets;
    }

}
