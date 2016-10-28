class MyQueue {
    // Push element x to the back of queue.
    private Stack<Integer> input = new Stack<>();
    private Stack<Integer> output = new Stack<>();
    public void push(int x) {
          input.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        output.pop();
    }

    // Get the front element.
    public int peek() {
       if(output.isEmpty()){
           while(!input.isEmpty())
             output.push(input.pop());
       } 
       return output.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
       return input.isEmpty()&&output.isEmpty();
    }
}
