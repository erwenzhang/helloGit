public class Solution {
      public boolean verifyPreorder(int[] preorder){
    	int min = Integer.MIN_VALUE;
    	Stack<Integer> stack = new Stack();
        for(int i = 0;i<preorder.length;i++){
        	if(preorder[i]<min) return false;
        	while(!stack.isEmpty()&&preorder[i]>stack.peek())
        		min=stack.pop(); // min is the root of the subtree,no further node should be smaller than it
            
        	stack.push(preorder[i]);
        }
        return true;
     }
}
