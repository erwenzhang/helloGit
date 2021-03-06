//heap k*logk
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        int bound = matrix.length < k ? matrix.length : k;
        for(int j = 0; j < bound; j++)  {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        
        for(int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if(t.x == n-1) continue;
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo (Tuple that) {
        return this.val - that.val;
    }
}


//binary serach nlog(n)log(n)?? or nlogn
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null||matrix.length==0) return 0;
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n-1][n-1];
        while(lo<hi){
            int mid = (lo+hi)>>1;
            int count = 0;
            for(int i = 0; i < n; i++){
                int loR = 0;
                int hiR = n; // be careful
                while(loR<hiR){
                    int midR = (loR+hiR)>>1;
                    if(matrix[i][midR]>mid){
                        hiR = midR; // be careful
                    }else{
                        loR = midR + 1;
                    }
                }
                count += loR;
            }
            if(count<k){
                lo = mid+1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }
}
