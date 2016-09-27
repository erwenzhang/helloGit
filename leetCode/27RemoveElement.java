public class Solution {
    /*1*/
    public int removeElement(int[] nums, int val) {
      int nonVal = 0;
      int valIn = 0;
      while(nonVal<nums.length){
          if(nums[valIn]!=val){
              valIn++;
              nonVal = valIn;
              continue;
          }
          if(nums[nonVal]==val){
              nonVal++;
              continue;
          }
        nums[valIn] = nums[nonVal];
        nums[nonVal] = val;
        valIn++;
        nonVal++;
    } 
    return valIn;
}
    /*2*/
public int removeElement(int[] A, int elem) {
  int m = 0;    
  for(int i = 0; i < A.length; i++){
      if(A[i] != elem){
          A[m] = A[i];
          m++;
      }
  }
  return m;
}
/*3*/
      public int removeElement(int[] nums, int val) {
        int p1 = 0;
        int p2 = nums.length-1;
        while(p1<=p2){
            if(nums[p1]==val){
                nums[p1] = nums[p2];
                p2--;
            }else{
                p1++;
            }
        }
        return p2+1;
    }
}
