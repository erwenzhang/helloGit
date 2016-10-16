public class SnakeGame {

        int width;
        int height;
        int[][] food;
        LinkedList<Integer> body;
        Set<Integer> set;
        int foodIndex;
        int score;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        foodIndex = 0;
        score = 0;
        body = new LinkedList<Integer>();
        set = new HashSet<Integer>();
        set.add(0);
        body.offerLast(0);
    }

    public int move(String direction) {
        if(score==-1) return -1;
        int rowHead = body.peekFirst()/width;
        int colHead = body.peekFirst()%width;
        
        switch (direction) {
            case "U" : rowHead--;
                      break;
            case "D" : rowHead++;
                      break;
            case "L" : colHead--;
                      break;
            default :  colHead++;
        }
        
        int head = rowHead*width+colHead;
        set.remove(body.peekLast());
        
        if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
            return score = -1;
        }
        
        set.add(head);
        body.offerFirst(head);
        if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
            set.add(body.peekLast());
            foodIndex++;
            return ++score;
        }
        
        body.pollLast();
        return score;

    }
}
