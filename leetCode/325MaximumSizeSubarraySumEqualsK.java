/*Sol 1, compute accumulat sum first, then use two sum sol, update map only one time*/
public int maxSubArrayLen(int[] nums, int k) {
        if(nums==null||nums.length==0) return 0;
        for(int i = 1; i < nums.length; i++){
            nums[i] += nums[i-1];
        }
        int len = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==k){len = Math.max(len,i+1);}
            if(map.containsKey(nums[i])){
                len = Math.max(len, i - map.get(nums[i]));
            }
            if(map.get(k+nums[i])==null)
                map.put(k+nums[i], i);
        }
        return len;
    }
 
 /*Sol 2, one for loop, compute accumulate sum and find subarray at the same time*/
 public int maxSubArrayLen(int[] nums, int k) {
    if(nums==null||nums.length==0) return 0;   
    int len = 0;
    int sum = 0;
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(0,-1);
    for(int i = 0; i < nums.length; i++){
       sum+= nums[i];
       len = Math.max(len, i - map.getOrDefault(sum-k,i) );
       map.putIfAbsent(sum, i);
    }
    return len;
}
