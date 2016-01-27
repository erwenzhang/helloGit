/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n){
	    if(n<2) return -1;
	    boolean[] flag = new boolean[n];
	    for(int i = 0;i<n;i++){
	        if(flag[i]) continue;
	        for(int j = 0; j<n;j++){
	            if(i==j) continue;
	            if(knows(i,j)){
	                flag[i] = true;
	                break;
	            }else{
	                flag[j] = true;
	            }
	            if(knows(j,i)){
	                flag[j] = true;
	            }else{
	                flag[i] = true;
	                break;
	            }
	        }
	        if(!flag[i]) return i;
	    }
        return -1;
    }
}
