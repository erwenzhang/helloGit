public class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();
            if(matrix == null||matrix.length == 0||matrix[0].length == 0) return result;
            int x = 0;
            int y = 0;
            int round = 1;
            int count = 0;
            int direction = 0;
            int num = matrix.length * matrix[0].length;
            while(count < num){
                count++;
                result.add(matrix[y][x]);
                switch (direction){
                    case 0:
                        x++;
                        if(x == matrix[0].length){ x--; y++;}
                        break;
                    case 1:
                        y++;
                        break;
                    case 2:
                        x--;
                        break;
                    default:
                        y--;
                        break;
                }
                if(y - round == 0&& direction == 3){
                    round++;
                    direction = (direction + 1)%4;
                }else if((x + round >= matrix[0].length &&direction==0) || (x - round < 0&&direction == 2) ||(y + round >= matrix.length&&direction==1)){
                    direction = (direction + 1)%4;
                }
        }
        return result;
    }
}
