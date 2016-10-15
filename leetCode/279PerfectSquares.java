  public int numSquares(int n){
        int[] count = new int[n+1];
        for(int i = 0; i <= n; i++){
            count[i] = i;
        }
        for(int i = 1; i <= n; i++){
             int square = (int)Math.sqrt(i);
             if(i == square*square){
                 count[i] = 1;
                 continue;
             }
             
             for(int j = 1; j<= square; j++){
                int add = i - j*j;
                count[i] = Math.min(count[add]+1,count[i]);
             }
        }
        return count[n];
    }
