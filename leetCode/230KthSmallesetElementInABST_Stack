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
    public int kthSmallest(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        int count = 1;
        while(!stack.isEmpty()){
            if(k == count){
                break;
            }
            count++;
            TreeNode tmpRoot = stack.pop().right;
            while(tmpRoot!=null){
                stack.push(tmpRoot);
                tmpRoot = tmpRoot.left;
            }
        }
        return stack.pop().val;
    }
}
