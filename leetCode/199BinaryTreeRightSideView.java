public class Solution {
    public List<Integer> rightSideView(TreeNode root){
    	LinkedList<Integer> rets = new LinkedList<>();
    	LinkedList<Integer> needed_level = new LinkedList<>();
    	needed_level.add(0);
    	helper(root,rets,0,needed_level);
	    return rets;
    }

    public void helper(TreeNode root, LinkedList<Integer> rets,int cur_level,LinkedList<Integer> needed_level){
        if(root==null)
    		return;
    	if(needed_level.getFirst().equals(cur_level)){
        	rets.add(root.val);
        	needed_level.add(needed_level.getFirst()+1);
        	needed_level.removeFirst();
        }
    	helper(root.right,rets,cur_level+1,needed_level);
    	helper(root.left,rets,cur_level+1,needed_level);	
    }
}
