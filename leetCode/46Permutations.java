public class Solution {
    public List<List<Integer>> permute(int[] array){
	    if(array==null||array.length == 0) return null;
            int len = array.length;
	    List<List<Integer>> permutations = new ArrayList<>();
	    List<Integer> permutation = new ArrayList<>();
	    boolean[] visited = new boolean[len];
	    generate(permutations,array,0,permutation,visited);	
	    return permutations;

    }
    public void generate(List<List<Integer>> permutations,int[] array,int index,List<Integer> permutation,boolean[] visited){
    	if(index==array.length){
            List<Integer> tmp = new ArrayList<>(permutation);
            permutations.add(tmp);
            return;
        }
    	for(int i = 0;i<array.length;i++){
    	    if(visited[i]) continue;
            permutation.add(array[i]);
            visited[i] = true;
    	    generate(permutations,array,index+1,permutation,visited);
    	    permutation.remove(index);
    	    visited[i] = false;
        }
    }
}
