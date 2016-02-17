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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        LinkedList<List<Integer>> rets = new LinkedList<>();
        if(root==null) return rets;
        Map<Integer,List<Integer>> m = new HashMap<>();
        Queue<Object> q = new LinkedList<>();
        q.add(root);
        q.add(0);
        while(!q.isEmpty()){
    	    int size = q.size();
    	    for(int i = 0;i<size;i+=2){
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
        }
        return rets;
    }
}
