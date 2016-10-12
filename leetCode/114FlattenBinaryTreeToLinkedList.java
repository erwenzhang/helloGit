    private TreeNode pre;
    public void flatten(TreeNode root) {
        if(root==null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    //o(n),space: o(height)
    public void flatten2(TreeNode root) {
        flatten2Help(root,null);
    }
    public TreeNode flatten2Help(TreeNode root, TreeNode pre){
        if(root==null) return pre;
        TreeNode right = flatten2Help(root.right, pre);
        TreeNode left = flatten2Help(root.left, right);
        root.left = null;
        root.right = left;
        return root;
    }

    //o(n), space: o(height)
    public void flatten1(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!= null) stack.push(cur.left);
            if(!stack.isEmpty()) cur.right = stack.peek();
            cur.left = null;
        }
    }
