/*Sol1 use map to store buildings for each critical point*/
public List<int[]> getSkyline(int[][] buildings) {
        Map<Integer, List<int[]>> cps = new TreeMap<>(); // ordered by the critical points
        for(int[] b : buildings) {
            cps.putIfAbsent(b[0], new LinkedList<>());
            cps.putIfAbsent(b[1], new LinkedList<>());
            cps.get(b[0]).add(b));
            cps.get(b[1]).add(b));
        }

        // heap for the currently active buildings        
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>(){
           public int compare(int[] b1, int[] b2) {
               return Integer.compare(b2[2], b1[2]);
           } 
        });

        List<int[]> res = new ArrayList<>();
        // iterate from left to right over the critical points
        for(Map.Entry<Integer, List<int[]>> entry : cps.entrySet()) {
            int c = entry.getKey();
            List<int[]> bs = entry.getValue();
            
            for(int[] b : bs) {
                if(c == b[0]) { // this critical point is a left edge of building `b`
                    heap.add(b);
                } else { // right edge， previously added to this heap, 
                    heap.remove(b);
                }
            }
            
            if(heap.isEmpty()) {
                // the heap is empty, so the skyline is 0
                res.add(new int[] { c, 0 });
            } else {
                int h = heap.peek()[2];
                if(res.isEmpty() || res.get(res.size() - 1)[1] != h) {
                    // only add the highest rectangle if it different than before
                    res.add(new int[] { c,  h });
                }
            }
        }
        
        return res;
    }
    
/*Sol2, use list to store height*/  
public List<int[]> getSkyline(int[][] buildings){
    List<int[]> heights = new ArrayList<>();
    for(int[] building:buildings){
        heights.add(new int[]{building[0],-building[2]});
        heights.add(new int[]{building[1],building[2]});
    }
    Collections.sort(heights, new Comparator<int[]>(){
         public int compare(int[] a, int[] b){
             if(a[0]!=b[0]) return a[0]-b[0];
             return a[1]-b[1];
         }
     });
     
     PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) ->(b-a));
     pq.add(0);
     int pre = 0;
     List<int[]> rets = new ArrayList<>();
     for(int[] height:heights){
         if(height[1]<0){
             pq.add(-height[1]);
         }else{
             pq.remove(height[1]);
         }
         if(pre!=pq.peek()){
             pre = pq.peek();
             rets.add(new int[]{height[0],pre});
         }
     }
     return rets;
}
