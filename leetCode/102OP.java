public List<List<Integer>> levelOrder(TreeNode root){
	    List<List<Integer>> rets = new ArrayList<>();
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.add(root);
	    while(!queue.isEmpty()){
		    int size  = queue.size();
		    List<Integer> level = new ArrayList<>();
		    for(int i = 0;i<size;i++){
			    TreeNode tmp = queue.poll();
			    if(tmp==null) continue;
                level.add(tmp.val);
                queue.add(tmp.left);
                queue.add(tmp.right);
            }
            if(level.size()!=0)
                rets.add(level);
        }
        return rets;
  }
