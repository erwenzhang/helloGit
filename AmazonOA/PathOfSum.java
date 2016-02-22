public class PathOfSum{
  public int Solution(TreeNode root){
    if(root==null) return 0;
    if(root.left!=null&&root.right==null) return Solution(root.left)+root.val;
    if(root.right!=null&&root.left==null) return Solution(root.right)+root.val;
    return Math.min(Solution(root.left),Solution(root.left))+root.val;
  
  }
}
