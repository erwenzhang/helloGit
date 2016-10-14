public int divide(int a,int b){
        if(a==Integer.MIN_VALUE&&b==-1||b==0) return Integer.MAX_VALUE;
        int sign = (a<=0&&b>0)||(a>=0&&b<0)?-1:1;
        long d1 = Math.abs((long)a);
        long d2 = Math.abs((long)b);
        if(d1<d2) return 0;
        int ret = 0;
        while(d1>=d2){
            int count = 1;
            long cur = d2;
            while((cur<<1)<=d1){
                count<<=1;
                cur<<=1;
            }
            d1 = d1 - cur;
            ret+=count;
        }
        return ret*sign;
    }
