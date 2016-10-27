public int closestValue(TreeNode root, double target) {
        if(root==null) return 0;
        double min = Double.MAX_VALUE;
        int val = 0;
        while(root!=null){
            if(min>=Math.abs(root.val-target)){
                min = Math.abs(root.val-target);
                val = root.val;
            }
            if(root.val<target){
                root = root.right;
            }else{
                root = root.left;
            }
        }
        return val;
}
