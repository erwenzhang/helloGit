public class NumArray {
    private class SegmentTreeNode{
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;
        public SegmentTreeNode(int start, int end){
            this.start = start;
            this.end = end;
            this.sum = 0;
            this.left = null;
            this.right = null;
        }
    }   
    SegmentTreeNode root = null;
    public NumArray(int[] nums) {
        root = buildTree(nums,0,nums.length-1);
    }
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if (start == end) {
                ret.sum = nums[start];
            } else {
                int mid = start  + (end - start) / 2;
                ret.left = buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }
    void update(int i, int val) {
        updateTree(root,i, val);
    }
    void updateTree(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                updateTree(root.left, pos, val);
            } else {
                updateTree(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root,i,j);
    }
    public int sumRange(SegmentTreeNode root, int start, int end){
        if (root.end <= end && root.start >= start) {
            return root.sum;
        }
        if(root==null||root.end<start||root.start>end) return 0;
        int left = sumRange(root.left, start, end);
        int right = sumRange(root.right, start, end);
        return left + right;
    }
}

