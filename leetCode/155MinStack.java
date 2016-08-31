public class MinStack{
    Stack<Integer> stack;
    public MinStack(){
        stack = new Stack<>();
    }
    public void push(int x){
        if(stack.isEmpty()){
            stack.push(x);
            stack.push(x);
            return;
        }
        int min = this.getMin();
        stack.push(x);
        stack.push(Math.min(x,min));
    }
    public void pop(){
        if(stack.isEmpty()) return;
        stack.pop();
        stack.pop();
    }

    public int top(){
        if(stack.isEmpty()) return -1;
        int min = stack.pop();
        int top = stack.peek();
        stack.push(min);
        return top;
    }

    public int getMin(){
        if(stack.isEmpty()) return -1;
        return stack.peek();

    }
}
