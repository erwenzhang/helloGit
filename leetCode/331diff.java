public class Solution {
    public boolean isValidSerialization(String preorder){
    	if(preorder == null||preorder.length()== 0)     
            return true;
      String[] array = preorder.split(",");
      int diff = 1;
      for(String tmp:array){
    	   if(--diff<0) return false;
    	   if(!tmp.equals("#")) diff+=2;
      }
    return diff==0;
	}
}
