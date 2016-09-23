public class HitCounter{
	  int[] hits;
    int[] timeStamps;
    public HitCounter(){
        hits = new int[300];
        timeStamps = new int[300];
    }
    public int getHits(int timeStamp){
        int res = 0;
        for(int i = 0; i < 300; i++){
            if(Math.abs(timeStamps[i] - timeStamp) < 300)
                res += hits[i];
        }  
        return res;
     }
    public void hit(int timeStamp){
        int index = timeStamp%300;
        if(timeStamps[index]==timeStamp){
            hits[index] += 1;
        }else{
            hits[index] = 1;
            timeStamps[index] = timeStamp;
        }
    }
}

public class HitCounter{
	  LinkedList<Integer> recorder;
	  public HitCounter(){
		  recorder = new LinkedList<>();
	  }

	  public int getHits(int timeStamp){
		  int timeBound = timeStamp - 300 < 0?0:timeStamp-300;
		  while(!recorder.isEmpty()&&recorder.peek()<=timeBound){
			  recorder.remove();
		  }
		  return recorder.size();
	  }
	  
	  public void hit(int timeStamp){
		  recorder.add(timeStamp);
	  }
}
