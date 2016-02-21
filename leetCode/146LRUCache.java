public class LRUCache{

	private static class Node{
		public final int key;
		public int val;
		public Node left;
		public Node right;
		public Node(int key,int val,Node left,Node right){
			this.key = key;
			this.val = val;
			this.left= left;
			this.right = right;

		}
	}

	private Node head;
	private final int capacity;
	private HashMap<Integer,Node> map;

	public LRUCache(int capacity){
		head = new Node(0,0,null,null);
		head.left=head.right=head;
		this.capacity = capacity;
		map = new HashMap<>();
	}

	public int get(int key){
		Node node = map.get(key);
		if(node == null) return -1;
		node.right.left = node.left;
		node.left.right = node.right;
		node.left = head;
		node.right = head.right;
		head.right.left = node;
		return node.val;
	}

	public void set(int k,int val){
		Node node = map.get(k);
		if(node==null){
			node = new Node(k,val,head,head.right);
			head.right.left = node;
			head.right = node;
			map.put(key,val);
			if(map.size()>capacity){
				Node remove = head.left;
				remove.left.right = head;
				head.left = remove.left;
				map.remove(remove,key);
			}
		}else{
			node.val = value;
			get(key);
		}
	}

}
