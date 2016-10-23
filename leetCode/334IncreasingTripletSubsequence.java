public boolean increasingTriplet(int[] nums) {
        int big = Integer.MAX_VALUE;
        int small = Integer.MAX_VALUE;
        for(int num:nums){
            if(num <= small){
                small = num;
            }else if(num <= big){
                big = num;
            }else{
                return true;
            }
        }
        return false;
    }
