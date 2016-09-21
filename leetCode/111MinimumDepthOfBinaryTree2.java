public class Solution {
    public int minDepth(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 1;
        queue.add(root);
        TreeNode rightMost = root;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left==null&&node.right==null) break;
            if(node == rightMost){
                depth++;
                rightMost = node.right!=null?node.right:node.left;
            }
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
        return depth;
    }
}
