public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null||matrix.length == 0 ||matrix[0].length == 0) return result;
        int[][] diff = {{1,0,-1,0},{0,1,0,-1}};
        int xLen = matrix[0].length;
        int yLen = matrix.length;
        int[] len = new int[]{xLen, yLen-1};
        int lenChoose = 0;
        int diffChoose = 0;
        int x = -1;
        int y = 0;
        while(len[lenChoose%2]!=0){
            for(int i = 0; i < len[lenChoose%2]; i++){
                y = y+diff[1][diffChoose%4];
                x = x+diff[0][diffChoose%4];
                result.add(matrix[y][x]);
            }
            len[lenChoose%2]--;
            lenChoose++;
            diffChoose++;
        }
        return result;
    }
}
