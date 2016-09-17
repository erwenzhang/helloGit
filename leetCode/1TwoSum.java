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
	    throw IllegalArgumentException("No two sum solution.");
    }
}
