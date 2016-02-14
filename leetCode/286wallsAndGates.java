public class Solution {
    public void wallsAndGates(int[][] rooms){
	    for(int i = 0;i<rooms.length;i++){
		    for(int j = 0;j<rooms[0].length;j++){
				    if(rooms[i][j]==0) update(i,j,rooms,0);
            }
        }
    }

    public void update(int i,int j,int[][] rooms,int dis){
    	if(i<0||i==rooms.length||j<0||j==rooms[0].length||rooms[i][j]<dis) return;
        rooms[i][j] = dis;
        update(i,j-1,rooms,dis+1);
        update(i-1,j,rooms,dis+1);
        update(i+1,j,rooms,dis+1);
        update(i,j+1,rooms,dis+1);
    }
    
}
