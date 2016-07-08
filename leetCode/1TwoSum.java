public class Solution {
   public int[] twoSum(int[] nums,int target){
    	int[] index = new int[2];
	Map<Integer,Integer> map = new HashMap<>();
     	for(int i = 0;i<nums.length;i++){
    	    if(map.containsKey(nums[i])){
    		index[0] = map.get(nums[i]);
    		index[1] = i;
    		return index;	
            }else{
            	map.put(target-nums[i],i);
            }
        }
	    return index;
    }
    
}

public class Solution{
  public int[] twoSum(int[] nums, int target){
     Map<Integer,Integer> map = new HashMap<>();
     int[] result = new int[2];
     for(int i = 0;i<nums.length;i++){
       if(map.get(nums[i])!=null){
          result[0]=map.get(nums[i]);
          result[1]=i;
          return result;
       }
       map.put(target-nums[i],i);
     }
     return result;
  }
  
}

