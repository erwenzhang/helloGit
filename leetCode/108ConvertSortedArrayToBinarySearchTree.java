public class Solution {
    public TreeNode sortedArrayToBST(int[] nums){
        return buildBST(nums, 0, nums.length - 1);
    }

    public TreeNode buildBST(int[] nums, int lo, int hi){
        if(lo>hi) return null;
        if(lo==hi) return new TreeNode(nums[lo]);   
        int mid = lo + (hi - lo)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, lo, mid - 1);
        root.right = buildBST(nums, mid+1, hi);
        return root;
    }
}
