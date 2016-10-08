public class NumMatrix{
    private int[][] matrix;
    private int[][] BIT; 
    public NumMatrix(int[][] matrix){
        int m = matrix.length;
        if(m==0) return;
        int col = matrix[0].length;
        this.matrix = new int[m][col];
        this.BIT = new int[m+1][col+1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < col; j++){
                update(i,j,matrix[i][j]);
            } 
        }
    }

    public void update(int row, int col, int val){
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        int i = row + 1;
        int j = col + 1;
        while(i < BIT.length){
            updateRow(i,j,diff);
            i += i&-i;
        }
    }

    public void updateRow(int row, int col, int val){
        int j = col;
        while(j<BIT[0].length){
            BIT[row][j] += val;
            j+= j&-j;  
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2){
        return getSum(row2+1,col2+1) - getSum(row1,col2+1)-getSum(row2+1,col1)+getSum(row1,col1); 
    }

    public int getSum(int row, int col){
        int sum = 0;
        while(row>0){
            sum+=sumRow(row, col);
            row -= row&-row;
        }
       return sum;
   }

    public int sumRow(int row, int col){
        int sum = 0;
        while(col>0){
            sum += BIT[row][col];
            col -= col&-col;   
        }
        return sum;
    }
}
