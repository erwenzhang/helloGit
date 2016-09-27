public class Solution {
    public int[][] reconstructQueue(int[][] people){
        Arrays.sort(people, new Comparator<int[]>(){
            @Override
            public int compare(int[] p1, int[] p2){
                return p2[0]!=p1[0]?(p2[0] - p1[0]):(p1[1]-p2[1]);
            }
        });
        List<int[]> resList = new LinkedList<>();
        for(int[] p: people){
            resList.add(p[1],p);
        }
        return resList.toArray(new int[people.length][]);
    }
}
