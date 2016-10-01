public class Solution {
    public int sumOfLeftLeaves(TreeNode root){
        if(root == null) return 0;
        return sumOfLeftLeaves(root.right,1)+sumOfLeftLeaves(root.left,0);
    }

    public int sumOfLeftLeaves(TreeNode root, int flag){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) {
        if(flag==0)
             return root.val;
        else 
             return 0;
        }
        int cur = 0;
        if(root.left!=null) cur+=sumOfLeftLeaves(root.left,0);
        if(root.right!=null) cur+=sumOfLeftLeaves(root.right,1);
        return cur;
    }
}
