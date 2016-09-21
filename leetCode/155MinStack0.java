class MinStack{
    class Node{
    	int val;
    	int min;
    	Node next;
     	Node(int x,int min){
    		this.val = x;
    		this.min = min;
    		next = null;
        }
    }
    Node head;
    public void push(int x){
    	if(head==null){
    		    head = new Node(x,x);
        }else{
             Node tmp = new Node(x,Math.min(x,head.min));
             tmp.next = head;
             head = tmp;
        }
    }
    public void pop(){
    	if(head!=null){
    		head = head.next;
        }

    }
    public int top(){
    	return head.val;
    }	
    public int getMin(){
    	if(head!=null) return head.min;
    	return -1;
    }
}
