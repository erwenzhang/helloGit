public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root){
        TreeNode p = root, parentRight = null, parent = null;
        while(p!=null){
            TreeNode left = p.left;
            p.left = parentRight;
            parentRight = p.right;
            p.right = parent;
            parent = p;
            p = left;
        }
        return parent;
   }
}
