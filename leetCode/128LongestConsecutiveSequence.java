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



public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        unionFound uf = new unionFound(nums.length);
        
        for(int i=0; i<nums.length; i++){
           if(map.containsKey(nums[i])) continue;
           map.put(nums[i],i);
           if(map.containsKey(nums[i]-1)){
               uf.union(i, map.get(nums[i]-1));
           }
           if(map.containsKey(nums[i]+1)){
               uf.union(i, map.get(nums[i]+1));
           }
        }
        return uf.max;
    }
    
    class unionFound{
        public int[] weight;
        public int[] parent;
        public int max;
        public unionFound(int size){
            this.weight = new int[size];
            this.parent = new int[size];
            for(int i=0; i<size; i++){
                this.parent[i] = i;
                this.weight[i] = 1;
            }
            max = 1;
        }
        
        public int findParent(int node){
            if(parent[node]!=node) return parent[node] = findParent(parent[node]);
            return node;
        }
        
        public void union(int i, int j){
            int root1 = findParent(i);
            int root2 = findParent(j);
            if(weight[root1]>=weight[root2]){
                weight[root1] += weight[root2];
                parent[root2] = root1;
                max = Math.max(weight[root1], max);
            }else{
                weight[root2] += weight[root1];
                parent[root1] = root2;
                max = Math.max(weight[root2], max);
            }
        }
    }
