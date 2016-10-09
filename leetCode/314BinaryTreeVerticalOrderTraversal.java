/*Sol1, BFS, TreeMap, two loops*/

public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> rets = new ArrayList<>();
        Map<Integer,List<Integer>> map = new TreeMap<>();
        if(root==null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        queue.add(root);
        levels.add(0);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int level = levels.poll();
            if(!map.containsKey(level)){
                List<Integer> ret = new ArrayList<Integer>();
                map.put(level, ret);
            }
            map.get(level).add(node.val);
            if(node.left!=null){
                queue.add(node.left); levels.add(level-1);
            }
            if(node.right!=null){
                queue.add(node.right); levels.add(level+1);
            }
        }
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            rets.add(entry.getValue());
        }
        return rets;
    }

/*Optimal, Sol2, BFS, HashMap, one loop*/
public List<List<Integer>> verticalOrder(TreeNode root) {
        LinkedList<List<Integer>> rets = new LinkedList<>();
        if(root==null) return rets;
        Map<Integer,List<Integer>> m = new HashMap<>();
        Queue<Object> q = new LinkedList<>();
        q.add(root);
        q.add(0);
        while(!q.isEmpty()){
    	    TreeNode node = (TreeNode)q.poll();
    	    int index = (Integer)q.poll();
    	    if(m.get(index)==null){ 
    	            LinkedList tmp = new LinkedList<>();
    	            m.put(index,tmp);
    	            if(index>0) rets.add(tmp); // very clever
    	            else rets.addFirst(tmp); 
    	    }
            m.get(index).add(node.val);
    	    if(node.left!=null) {q.add(node.left);q.add(index-1);}
    	    if(node.right!=null){ q.add(node.right);q.add(index+1);}
        }
        return rets;
 }
