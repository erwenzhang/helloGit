public class Solution {
    public boolean isValidBST(TreeNode root){
        return visit(root, null, null);
    }

    public boolean visit(TreeNode node, Integer low, Integer high){
        if(node == null) return true;
        return (low==null||node.val>low)&&(high==null||node.val<high)&&visit(node.left, low, node.val)&&visit(node.right, node.val, high);
    }
}
