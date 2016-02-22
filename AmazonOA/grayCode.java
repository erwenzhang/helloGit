public static int grayCheck(byte term1,byte term2){
        byte x = (byte)(term1^term2);
        int count = 0;
        while(x!=0){
            x=(byte)(x&(x-1));
            count++;
        }
        return  count==1?1:0;
    }
