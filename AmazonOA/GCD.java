public class GCD{
    public int Solution(int[] array){
        if(array==null||array.length==0) return 0;
        int gcd = array[0];
        for(int i=1;i<array.length;i++){
            gcd = helper(gcd,array[i]);
        }
        return gcd;
    }
    public int helper(int x,int y){
        if(x==0||y==0) return 0;
        while(x!=0&&y!=0){
            if(y>x){
                x^=y;
                y^=x;
                x^=y;
            }
            int tmp =x%y;
            x = y;
            y = tmp;
        }
        return x+y;
    }
}
