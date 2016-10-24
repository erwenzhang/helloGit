public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums==null||nums.length==0) return new ArrayList<List<Integer>>();
        List<List<Integer>> rets = new ArrayList<>();
        DFS(nums,rets,new ArrayList<Integer>(),0);
        return rets;
    }
    public void DFS(int[] nums,List<List<Integer>> rets, List<Integer> ret, int index){
        if(index==nums.length) {
            rets.add(new ArrayList<Integer>(ret));
            return;
        }
        DFS(nums,rets,ret,index+1);
        ret.add(nums[index]);
        DFS(nums,rets,ret,index+1);
        ret.remove(ret.size()-1);
    }
}
