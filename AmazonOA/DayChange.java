import java.util.Arrays;

public class DayChange{
    public int[] solution(int[] days,int n){
        if(days==null||n<=0) return days;
        int len = day.length;
        int[] ret = new int[len+2];
        ret[0] = ret[len+1]=0;
        int pre = ret[0];
        for(int i=1;i<len+1;i++)
            ret[i] = days[i-1];
        for(int i=0;i<n;i++){
            for(int j=1;j<len+1;j++){
                int tmp = ret[j];
                ret[j] = pre^ret[j+1];
                pre = tmp;
            }
        }
        return Arrays.copyOfRange(ret,1,len+1);
    }
}
