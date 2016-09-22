public class Solution {
    private class ResultType{
        int path;
        int maxPath;
        public ResultType(int path, int maxPath){
            this.path = path;
            this.maxPath = maxPath;
        }
    }

    public int maxPathSum(TreeNode root){
        ResultType result = helper(root);
        return result.maxPath;
    }

    public ResultType helper(TreeNode root){
        if(root == null) return new ResultType(0, Integer.MIN_VALUE);
        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);
        int leftTree = leftResult.path;
        int rightTree = rightResult.path;
        int path = Math.max(leftTree+root.val, root.val+rightTree);
        path = Math.max(0, path);
        int maxPath = Math.max(leftResult.maxPath,rightResult.maxPath);
        maxPath = Math.max(maxPath, leftTree+root.val+rightTree);
        return new ResultType(path, maxPath);
    }
}
