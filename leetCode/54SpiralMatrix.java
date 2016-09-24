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
        int col = -1;
        int row = 0;
        while(len[lenChoose%2]!=0){
            for(int i = 0; i < len[lenChoose%2]; i++){
                row = row+diff[1][diffChoose%4];
                col = col+diff[0][diffChoose%4];
                result.add(matrix[row][col]);
            }
            len[lenChoose%2]--;
            lenChoose++;
            diffChoose++;
        }
        return result;
    }
}
