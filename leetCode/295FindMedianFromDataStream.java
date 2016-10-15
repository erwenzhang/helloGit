public class MedianFinder {
    private PriorityQueue<Integer> small = new PriorityQueue<>();
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    
    // Adds a number into the data structure.
    public void addNum(int num) {
           small.add(-num);
           if(!large.isEmpty() && (-small.peek())>large.peek()) large.add(-small.poll());
           if(small.size()>large.size()) large.add(-small.poll());
           if(large.size()>small.size()+1) small.add(-large.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(large.size()==small.size()) return (double)(large.peek()-small.peek())/2.0;
        else return large.peek();
    }
}
