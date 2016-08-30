public int longestConsecutive(TreeNode root) { 
    if(root == null) return 0;   
    return traverse(root, root.val+1, 0);      
}

public int traverse(TreeNode root, int target, int len){
  if(root == null) return len;
  int tmpLen;
  if(root.val == target){
        tmpLen = Math.max(traverse(root.right,root.val+1,len+1), traverse(root.left,root.val+1,len+1));
  }else{
        tmpLen = Math.max(traverse(root.right,root.val+1,1), traverse(root.left,root.val+1,1));
  }
  return Math.max(tmpLen,len);
}
