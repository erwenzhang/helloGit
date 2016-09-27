public class DeleteTreeNodes{
    public List<TreeNode> deleteTreeNodes(TreeNode root, int[] vals){
        ArrayList<TreeNode> roots = new ArrayList<>();
        if(root==null||vals==null||vals.length ==0) {
            return roots;
         }
         HashSet<Integer> set = new HashSet<>();
         for(int val:vals) set.add(val);
         root = helper(roots, root, set);
         if(root!=null) roots.add(root);
         return roots;
     }

    public TreeNode helper(List<TreeNode> roots, TreeNode root, HashSet<Integer> set){
         if(root == null) return root;
         root.left = helper(roots, root.left, set);
         root.right = helper(roots, root.right, set);
         if(set.contains(root.val)){  
         if(root.left!=null){
            roots.add(root.left);
         }
         if(root.right!=null){
            roots.add(root.right);
         }
         return null;
         }
         return root;
     }
}
