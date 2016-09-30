public List<List<Integer>> threeSum(int[] nums){
  List<List<Integer>> result = new ArrayList<>();
  if(nums == null || nums.length < 3) return result;
  Arrays.sort(nums);
  int len = nums.length;
  for(int i = 0; i < len; i++) {
      if(i > 0 && nums[i] == nums[i - 1]) continue;        // Skip same results
      int target = 0 - nums[i];
      int j = i + 1, k = len - 1;
      while(j < k) {
        if(nums[j] + nums[k] == target) {
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                while(j < k && nums[j] == nums[j + 1]) j++;  // Skip same results
                while(j < k && nums[k] == nums[k - 1]) k--;  // Skip same results
                j++; k--;
        } else if(nums[j] + nums[k] < target) {
                j++;
        } else {
                k--;
        }
      }
    }
  return result;
}

// Solution2, without sorting, using HashMap,
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length<3) return res;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.containsKey(num)?map.get(num)+1:1);
        }
        HashSet<Integer> set = new HashSet<>(map.keySet());
        for(int item : set){
            map.put(item, map.get(item)-1);
            if(map.get(item)==0) map.remove(item);
            helper(res, -item, map);
            map.remove(item);
        }
        return res;
    }
    public void helper(List<List<Integer>> res, int target,HashMap<Integer,Integer> map){
        Set<Integer> visited = new HashSet<>();
        for(int item:map.keySet()){
            visited.add(item);
            if(item== target - item&&map.get(item)>=2||item!=target-item&&map.containsKey(target-item)&&!visited.contains(target-item)){
                res.add(Arrays.asList(-target,item, target - item));
            }
        }
     }
}
