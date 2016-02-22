public class Solution{
    public boolean isSubTree(TreeNode T1,TreeNode T2){
        if(T2==null) return true;
        if(T1==null) return false;
        if(T1.val==T2.val) return isSameTree(T1,T2);
        else return isSubTree(T1.left,T2)||isSubTree(T1.right,T2);
    }
    public boolean isSameTree(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null) return true;
        if(t1==null||t2==null) return false;
        if(t1.val!=t2.val) return false;
        return isSameTree(t1.right,t2.right)&&isSameTree(t1.left,t2.left);
    }
}
