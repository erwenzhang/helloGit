public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0,j=s.length()-1;
        while(i<j){
        	while(!(Character.isLetterOrDigit(s.charAt(j)))){
        		  j--;
            }
            while(!(Character.isLetterOrDigit(s.charAt(i)))){
            	i++;
            }
            if(Character.toLowerCase(s.charAt(i))!= Character.toLowerCase(s.charAt(j)))
            	return false;
            j--;
            i++;
        }
        return true;        
    }
}
