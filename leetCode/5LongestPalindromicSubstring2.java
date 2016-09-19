public class Solution {
    public String longestPalindrome(String str){
	int n = 2*str.length()-1;
	int index=0;
	int longest=0;
	for(int i = 0;i<n;i++){
	    int len = lengthPalindrome(i, str);
            if(len > longest){
	        index = i;
	        longest = len;
            }
        }
        if(longest%2==1)
            return str.substring(index/2-longest/2,index/2+longest/2+1);
        else{
            return str.substring((index+1)/2-longest/2,(index+1)/2+longest/2);}
    }
    public int lengthPalindrome(int i, String str){
	    int left;
	    int right;
        if(i%2==0){
            left = i/2;
        	right = left;
        }else{
        	left = i/2;
        	right =left + 1;
        }
        while(left>=0&&right<str.length()&&str.charAt(left)==str.charAt(right)){
        		left--;
        		right++;
        }
        return right-left-1;
    }
}
