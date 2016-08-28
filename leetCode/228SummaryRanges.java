public class SummaryRanges{
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        if(nums==null||nums.length==0) return null;
        int lo = nums[0];
        int hi = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i]==hi+1){
                hi = nums[i];
                continue;  
            } 
            summary.add(generateRanges(lo,hi));
            lo = nums[i];
            hi = nums[i];   
        }      
        summary.add(generateRanges(lo,hi));
        return summary;      
   }
   
   public String generateRanges(int lo, int hi){
       return (lo==hi)?String.valueOf(lo):String.format(“%d->%d”,lo,hi);
   }
}
