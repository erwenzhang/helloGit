public class TwoSum{
  HashMap<Integer,Integer> map = new HashMap<>();
    // Add the number to an internal data structure.
	public void add(int x){
		Integer tmp = map.get(x);
		map.put(x,tmp==null?1:tmp+1);
	    
	}
    public boolean find(int target){
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
    	    int val = target - entry.getKey();
    	    if(val == entry.getKey()){
                if(entry.getValue()>=2) return true;
            }else if(map.containsKey(val)){
    	                return true;
           }
        }	
	return false;
    }
}




// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
