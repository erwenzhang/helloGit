public class Solution {
   

public int hIndex(int[] citations){
	Arrays.sort(citations);
	int hIndex = citations.length;
	for(int i = 0;i<citations.length;i++){
		if(citations[i]<hIndex)
			hIndex--;
		else{
	        break;
        }
    }
    return hIndex;
 }

}


  public int hIndex(int[] citations) {
      if(citations == null) return 0;
      Arrays.sort(citations);
      for(int i = 0 ; i < citations.length; i++){
          if(citations[i] >= citations.length - i){
               return citations.length - i;
          }
      }   
      return 0;     
  }
