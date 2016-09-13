public class Solution {
    public List<List<Integer>> permute(int[] array){
	    if(array==null||array.length == 0) return null;
        int len = array.length;
	    List<List<Integer>> permutations = new ArrayList<>();
	    List<Integer> permutation = new ArrayList<>();
	    boolean[] flag = new boolean[len];
	    generate(permutations,array,0,permutation,flag);	
	    return permutations;

    }
    public void generate(List<List<Integer>> permutations,int[] array,int index,List<Integer> permutation,boolean[] flag){
    	if(index==array.length){
            List<Integer> tmp = new ArrayList<>(permutation);
            permutations.add(tmp);
            return;
        }
    	for(int i = 0;i<array.length;i++){
    	    if(flag[i]) continue;
          permutation.add(array[i]);
          flag[i] = true;
    	    generate(permutations,array,index+1,permutation,flag);
    	    permutation.remove(index);
    	    flag[i] = false;
        }
    }
}
