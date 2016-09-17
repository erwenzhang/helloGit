import java.util.HashMap;

public class LRUCache{
    static class Node{
        int key;
        int val;
        Node left;
        Node right;
        Node(int k, int v){
            key = k;
            val = v;
        }
    }
    int capacity;
    Node head;
    HashMap<Integer, Node> cache;
    public LRUCache(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(-1,-1);
        head.right = head.left = head;
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
        cur.left.right = cur.right;
        cur.right.left = cur.left;
        addLRU(cur);
    }
    
    public void addLRU(Node node){
        node.right = head;
        node.left = head.left;
        head.left.right = node;
        head.left = node;
    }

    public void removeLRU(){
        int key = head.right.key;
        cache.remove(key);
        head.right.right.left = head;
        head.right = head.right.right;
    }
}
