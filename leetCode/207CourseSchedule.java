public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<=1) return true;
        ArrayList<HashSet<Integer>> edges = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++)
            edges.add(new HashSet<Integer>());
        for(int[] prerequisite:prerequisites){
            edges.get(prerequisite[0]).add(prerequisite[1]);
        }

        for(int i = 0; i < numCourses; i++){
            if(edges.get(i).size()!=0)
                if(!dfs(edges,i,visited)) return false;
        }
        return true;
    }

    public boolean dfs(ArrayList<HashSet<Integer>> edges,int node, boolean[] visited){
        if(visited[node]) return false;
        visited[node] = true;// important !!!
        while(!edges.get(node).isEmpty()){
            int j = edges.get(node).iterator().next();
            if(!dfs(edges,j,visited)) return false;
            edges.get(node).remove(j);
        }
        visited[node] = false; //important!!!
        return true;
    }
