public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        permute(permutations,visited,nums,new ArrayList<Integer>());
        return permutations;
    }

    public void permute(List<List<Integer>> permutations, boolean[] visited, int[] nums, List<Integer> permutation){
        if(permutation.size()==nums.length){
            permutations.add(new ArrayList<Integer>(permutation));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            if(i>0&&nums[i-1]==nums[i]&&!visited[i-1]) continue;
            visited[i] = true;
            permutation.add(nums[i]);
            permute(permutations,visited,nums,permutation);
            visited[i] = false;
            permutation.remove(permutation.size()-1);
        }
    }
}
