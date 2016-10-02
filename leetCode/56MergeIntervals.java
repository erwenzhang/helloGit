 public List<Interval> merge(List<Interval> intervals) {
        List<Interval> rets = new ArrayList<>();
        if(intervals==null||intervals.isEmpty()) return rets;
        Collections.sort(intervals,new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                return a.start!=b.start?a.start-b.start:a.end-b.end;
            }
        }); 
        Interval pre = intervals.get(0);
        int start = pre.start;
        int end = pre.end;
        for(int i = 1; i < intervals.size();i++){
            Interval cur = intervals.get(i);
            if(end>=cur.start){
                end = Math.max(end,cur.end);
            }else{
                rets.add(new Interval(start,end)); 
                start = cur.start;
                end = cur.end;
            }   
        }
        rets.add(new Interval(start,end));
        return rets;
}
