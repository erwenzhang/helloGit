public class Solution {
    public int minCostII(int[][] costs) {
        if(costs==null||costs.length==0) return 0;
        int min = -1, minSec = -1;
        for(int i = 0; i < costs.length;i++){
            int lastMin = min, lastSec = minSec;
            min = -1; minSec = -1;
            for(int j = 0; j < costs[0].length; j++){
                 if(j!=lastMin){
                     costs[i][j]+=lastMin<0?0:costs[i-1][lastMin];
                 }else{
                      costs[i][j]+=lastSec<0?0:costs[i-1][lastSec];   
                 }
                 
                 if(min<0||costs[i][j]<costs[i][min]){
                     minSec = min; min = j;
                 }else if(minSec<0||costs[i][j]<costs[i][minSec]){
                     minSec = j;
                 }
            }   
        }
        return costs[costs.length-1][min];
    }
}
