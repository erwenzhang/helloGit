public class Solution {
    
    private static class Point {
        public final int x;
        public final int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public boolean equals(Object o) {
            Point p = (Point) o;
            return x == p.x && y == p.y;
        }
        
        public int hashCode() {
            return x + y;
        }
    }
    public boolean isReflected(int[][] points) {
        if(points.length == 0) 
            return true;
        long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
        Map<Point, Integer> map = new HashMap<>();
        for(int[] point: points){
            Point p = new Point(point[0], point[1]);
            map.put(p, get(map, p)+1); 
            min = Math.min(min, point[0]);
            max = Math.max(max, point[0]);
        }
        long sum = max+min;
        for(Point p: map.keySet()) {
            Point opposite = new Point((int)(sum-p.x), p.y);
            if(get(map, opposite) == 0) {
                return false;
            }
        }
        return true;
    }
    
    private int get(Map<Point, Integer> map, Point p) {
        return map.containsKey(p)? map.get(p): 0;
    }
}
