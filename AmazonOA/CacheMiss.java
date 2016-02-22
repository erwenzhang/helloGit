import java.util.LinkedList;
import java.util.List;

public class CacheMiss{
    public int Solution(int[] key,int size){
        if(key==null||key.length==0) return 0;
        List<Integer> cache = new LinkedList<Integer>();
        int count = 0;
        for(int i=0;i<key.length;i++){
            if(cache.contains(key[i]))
                cache.remove(new Integer(key[i]));
            else{
                  count++;
                  if(cache.size()==size){
                    cache.remove(0);
                  }
            }
            cache.add(key[i]);
        }
        return count;
    }
}
