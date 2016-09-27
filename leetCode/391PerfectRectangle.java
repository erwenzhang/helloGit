public class Solution {
/*Solution 1: point check*/
    public class Solution {
        public boolean isRectangleCover(int[][] rectangles) {
            int newLeft = Integer.MAX_VALUE, newRight = Integer.MIN_VALUE, newBottom = Integer.MAX_VALUE, newTop = Integer.MIN_VALUE;
            HashMap<String, Integer> map = new HashMap<>();
            for(int[] rectangle: rectangles){
                newLeft = Math.min(newLeft, rectangle[0]);
                newRight = Math.max(newRight,rectangle[2]);
                newBottom = Math.min(newBottom, rectangle[1]);
                newTop = Math.max(newTop, rectangle[3]);
                String A =rectangle[0]+" "+rectangle[1];
                String B = rectangle[2]+" "+rectangle[1];
                String C = rectangle[2]+" " + rectangle[3];
                String D = rectangle[0]+" " + rectangle[3];
                if(insertConner(A,map,1)) return false;
                if(insertConner(B,map,2)) return false;
                if(insertConner(C,map,4)) return false;
                if(insertConner(D,map,8)) return false;
            }
            int[] marks = new int[]{3,6,9,12,15};
            for(Map.Entry<String,Integer> entry:map.entrySet()){
                String[] vertexs = entry.getKey().split(" ");
                int x = Integer.parseInt(vertexs[0]);
                int y = Integer.parseInt(vertexs[1]);
                if(x>newLeft && x < newRight||y>newBottom&&y<newTop){
                boolean flag = false;
                for(int mark: marks){
                    if(entry.getValue()== mark){flag = true; break;}
                }
                if(!flag) return false;
            }
        }
        return true;
    }


    public boolean insertConner(String vertex, HashMap<String, Integer> map, int position){
        if(map.get(vertex) == null){
            map.put(vertex,position);
        }else{
            if((map.get(vertex)&position)!=0) return true;
            // to check if there is other vertex with same position
            map.put(vertex, map.get(vertex)|position);
        }
        return false;
    }

}

 /*Solution 2: point check and area check*/
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) return false;
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
    
        HashSet<String> set = new HashSet<String>();
        int area = 0;
    
        for (int[] rect : rectangles) {
            x1 = Math.min(rect[0], x1);
            y1 = Math.min(rect[1], y1);
            x2 = Math.max(rect[2], x2);
            y2 = Math.max(rect[3], y2);
        
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
        
            String s1 = rect[0] + " " + rect[1];
            String s2 = rect[0] + " " + rect[3];
            String s3 = rect[2] + " " + rect[3];
            String s4 = rect[2] + " " + rect[1];
        
            if (set.contains(s1)) {
                set.remove(s1);
            } else {
                set.add(s1);
            }
            if (set.contains(s2)) {
                set.remove(s2);
            } else {
                set.add(s2);
            }
            if (set.contains(s3)) {
                set.remove(s3);
            } else {
                set.add(s3);
            }
            if (set.contains(s4)) {
                set.remove(s4);
            } else {
                set.add(s4);
            }
          }
    
    if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2) || set.size() != 4) return false;
    
    return area == (x2-x1) * (y2-y1);
}

}
