/*Sol1 priority queue, O(nlogn)*/  
public class Solution {
public List<Integer> topKFrequent(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.get(num)==null){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer,Integer> entry1, Map.Entry<Integer,Integer> entry2){
                return entry2.getValue()-entry1.getValue();
            }
        });

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(entry);
        }

        List<Integer> ret = new ArrayList<Integer>();

        while (k-->0){
            ret.add(pq.poll().getKey());
        }
        return ret;
    }
}

/*Sol2 bucket sort*/
public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums==null || nums.length==0) return new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, 0);
            }
            map.put(num, map.get(num)+1);
        }
        
        List<Integer>[] buckets = new List[nums.length+1];
        for(Map.Entry<Integer, Integer> item : map.entrySet()){
            int frequent = item.getValue();
            if(buckets[frequent]==null) buckets[frequent] = new ArrayList<>();
            buckets[frequent].add(item.getKey());
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i=buckets.length-1; i>=0 && result.size()<k; i--){
            if(buckets[i]!=null) result.addAll(buckets[i]);
        }
        return result;
   }
