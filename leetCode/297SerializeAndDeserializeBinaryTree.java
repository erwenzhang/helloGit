public class Codec{
    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        DFS(root,sb);
        return sb.toString();
    }

    public void DFS(TreeNode root, StringBuilder sb){
        if(root==null) {sb.append("null "); return;}
        sb.append(root.val).append(' ');
        DFS(root.left,sb);
        DFS(root.right,sb);
    }
    public TreeNode deserialize(String data){
        if(data==null) return null;
        if(data.isEmpty()) return null;
        String[] elements = data.split(" ");
        return DFS2(elements, new int[]{0});
    }

    public TreeNode DFS2(String[] elements, int[] index){
        if(index[0]>=elements.length) return null;
        String val = elements[index[0]++];
        if(val.equals("null")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = DFS2(elements,index);
        root.right = DFS2(elements,index);
        return root;
    }

}
