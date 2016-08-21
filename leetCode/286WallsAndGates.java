public class Solution{
    public void wallsAndGates(int[][] rooms){
        if(rooms==null){
            return;
        }

    LinkedList<int[]> gates = new LinkedList<int[]>();
    
    /** Traverse all nodes and store all gates. */
    for(int i = 0;i<rooms.length;i++){
        for(int j = 0; j<rooms[0].length;j++){
            if(rooms[i][j]==0)
               gates.add(new int[]{i,j});
        }
    }

    int[][] diffs = new int[][]{{-1,0,1,0},{0,-1,0,1}};
    while(!gates.isEmpty()){
        int[] gate = gates.remove();
        for(int i = 0;i<diffs[0].length;i++){
            int newR = gate[0]+diffs[0][i];
            int newC = gate[1]+diffs[1][i];
            if(newR<0||newR==rooms.length||newC<0||newC==rooms[0].length||rooms[newR][newC]<rooms[gate[0]][gate[1]]+1)
                continue;
            rooms[newR][newC]=rooms[gate[0]][gate[1]]+1;
            gates.add(new int[]{newR,newC});
        }
    }
  }
}
