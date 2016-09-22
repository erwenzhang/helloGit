public class Solution {
    private ListNode list;
    public TreeNode sortedListToBST(ListNode head){
        int len = 0;
        ListNode p = head;
        while(p!=null){
            p = p.next;
            len++;
        }  
        list = head;
        return buildBST(0, len - 1); 
    }

    public TreeNode buildBST(int start, int end){
        if(start>end) return null;
        int mid = (start+end)/2;
        TreeNode leftTree = buildBST(start, mid-1);
        TreeNode parent = new TreeNode(list.val);
        list = list.next;
        parent.left = leftTree;
        parent.right = buildBST(mid+1, end);
        return parent;
    }
}
