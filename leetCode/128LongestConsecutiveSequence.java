public class Solution {
    public int longestConsecutive(int[] nums) {
          HashMap<Integer, Integer> map = new HashMap<>();
          int longest = Integer.MIN_VALUE;
          for(int num : nums){
               if(map.containsKey(num)){
                 continue;
               }
               int next = num + 1;
               int last = num - 1;
               int left = (map.containsKey(last))?map.get(last):0;
               int right = (map.containsKey(next))?map.get(next):0;
               longest = Math.max(longest,left+right+1);
               map.put(num,left+right+1);
               map.put(num-left,left+right+1);
               map.put(num+right,left+right+1);       
         }   
         return longest;    
    }
}
