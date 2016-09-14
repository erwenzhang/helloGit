   public List<List<Integer>> uniqueInnerList(List<Integer> nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(Integer num : nums){
            Integer val = map.get(num);
            map.put(num,val==null?1:val+1);
        }
        List<List<Integer>> results = new ArrayList<>();
        while(true){
            List<Integer> result = new ArrayList<>();
            Iterator<Integer> it = map.keySet().iterator();
            while(it.hasNext()){
                Integer key = it.next();
                if(map.get(key)==0) continue;
                result.add(key);
                map.put(key,map.get(key)-1);
            }
            if (result.size()==0)
                break;
            results.add(result);
        }
        return results;
    }
