import java.util.HashMap;

public class LRUCache{
    static class Node{
        public final int key;
        public int val;
        public Node left;
        public Node right;
        Node(int k, int v){
            key = k;
            val = v;
        }
    }
    int capacity;
    Node p;
    Node dummyHead;
    HashMap<Integer, Node> cache;
    public LRUCache(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>();
        p = new Node(-1,-1);
        dummyHead = p;
    }

    public int get(int key){
        if(!cache.containsKey(key)) return -1;
        replace(key);
        return cache.get(key).val;
    }
    
    public void set(int key, int value){
        if(capacity == 0) return;
        if(cache.containsKey(key)){
            cache.get(key).val = value;
            replace(key);
            return;
        }
        if(cache.size()==capacity){
            removeLRU();
        }
        Node node = new Node(key,value);
        cache.put(key,node);
        addLRU(node);
    }

    public void replace(int key){
        Node cur = cache.get(key);
        if(cur == p) return;
        cur.left.right = cur.right;
        cur.right.left = cur.left;
        addLRU(cur);
    }
    
    public void addLRU(Node node){
        p.right = node;
        node.left = p;
        node.right = null;
        p = node;
    }

    public void removeLRU(){
        int key = dummyHead.right.key;
        cache.remove(key);
        if(dummyHead.right == p){
            p = dummyHead;
        }else{
            dummyHead.right.right.left = dummyHead;
        }
        dummyHead.right = dummyHead.right.right;
    }
}
