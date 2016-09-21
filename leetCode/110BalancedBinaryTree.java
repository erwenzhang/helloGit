    public boolean isBalanced(TreeNode root){
	    return helper(root)!=-1;
    }
    public int helper(TreeNode root){
    	if(root==null) return 0;
    	int l_res = helper(root.left);
    	int r_res = helper(root.right);
    	if(l_res==-1||r_res==-1||Math.abs(l_res-r_res)>1) return -1;
    	return Math.max(l_res,r_res)+1;
    }
