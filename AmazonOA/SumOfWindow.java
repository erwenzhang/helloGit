public class SumOfWindow{
    public int[] Solution(int[] array,int k){
        if(array==null||array.length==0||array.length<k||k<=0) return null;
        int[] ret = new int[array.length-k+1];
        for(int i = 0;i<k;i++){
            ret[0] += array[i];
        }
        for(int i=1;i<array.length;i++){
            ret[i] = ret[i-1]-array[i-1]+array[k+i-1];
        }
        return ret;
    }
}
