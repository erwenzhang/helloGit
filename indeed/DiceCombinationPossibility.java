    // backtrace
    int count;
    public float computePossibility(int dice, int target) {
        int total = (int) Math.pow(6,dice);
        helper(target,0,dice, 0);
        return (float)count/total;
    }

    public void helper(int target, int trial, int dice, int sum) {
        if(trial == dice) {
            if(target == sum)
                count++;
            return;
        }
        for(int i = 1; i<=6; i++) {
            helper(target, trial+1, dice, sum+i);
        }
    }
    
    
    //DP
    public float computePossibility(int dice, int target){
        int total = (int)Math.pow(6,dice);
        int[][] dp = new int[dice+1][target+1];

        for(int i = 1;i<=Math.min(target,6);i++){
            dp[1][i] = 1;
        }
        for(int i = 2; i <= dice; i++){
            for(int j = 1; j <= target; j++){
                for(int k = 1;k<j&&k<=6;k++){ //k is the value of 1st dice
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        return (float)dp[dice][target]/total;
    }
