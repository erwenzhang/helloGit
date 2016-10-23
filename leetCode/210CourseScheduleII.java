static class Course{
        int val;
        int degree;
        ArrayList<Course> nextCourses = new ArrayList<>();
        public Course(int v){
            val = v;
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites==null||numCourses==0) return new int[0];
        Course[] courses = new Course[numCourses];

        //construct graph
        for(int[] prerequisite:prerequisites){
            int from = prerequisite[1];
            int to = prerequisite[0];
            if(courses[from]==null) courses[from]=new Course(from);
            if(courses[to]==null) courses[to]=new Course(to);
            courses[from].nextCourses.add(courses[to]);
            courses[to].degree++;
        }

        //topological sort, find source node,
        Queue<Course> queue = new LinkedList<>();
        for(int j = 0; j < numCourses;j++){
            Course course = courses[j];
            if(course==null) queue.add(new Course(j));
            else if(course.degree==0) queue.add(course);
        }
        int[] order = new int[numCourses];
        int i = 0;
        while(!queue.isEmpty()){
            Course cur = queue.poll();
            order[i++] = cur.val;
            for(Course next:cur.nextCourses){
                next.degree--;
                if(next.degree==0){
                    queue.add(next);
                }
            }
        }
        return i==numCourses?order:new int[0]; // important!!,
    }
