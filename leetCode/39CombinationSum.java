public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
      List<List<Integer>> result = new ArrayList<>();
      if(candidates==null||candidates.length == 0) return result;
      Arrays.sort(candidates);
      dfs(candidates, 0, target, result, new ArrayList<>());
      return result;
    }

    public void dfs(int[] candidates, int index, int target, List<List<Integer>> result,List<Integer> path){
      if(target < 0) return;
      if(target == 0){ result.add(new ArrayList<>(path)); return;}
      for(int i = index ; i < candidates.length; i++){
        path.add(candidates[i]);
        dfs(candidates, i, target-candidates[i],result,path);
        path.remove(path.size()-1);
      }
    }
}
