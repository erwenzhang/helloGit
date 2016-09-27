public class Solution {
    public int removeDuplicates(int[] nums){
        if(nums == null||nums.length == 0) return 0;
        int newP = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[newP]!=nums[i]){
                nums[++newP] = nums[i];
            }
        } 
        return newP+1;  
    }
}
