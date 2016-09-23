/*Top Down*/
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

/*Bottom Up*/
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root){
        return dfs(root, null);
    }
    public TreeNode dfs(TreeNode left, TreeNode parent){
        if(left == null) return parent;
        TreeNode root = dfs(left.left, left);
        left.left = (parent==null)?parent:parent.right;
        left.right = parent;
        return root	;
    }
}
