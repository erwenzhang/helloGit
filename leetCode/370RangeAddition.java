public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        for(int[] update : updates){
            nums[update[0]] += update[2];
            if(update[1]+1<length) nums[update[1]+1]-=update[2];
        }
        
        for(int i=1; i<nums.length; i++){
            nums[i] = nums[i-1]+nums[i];
        }       
        return nums;
    }
}
