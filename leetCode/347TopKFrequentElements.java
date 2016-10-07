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
