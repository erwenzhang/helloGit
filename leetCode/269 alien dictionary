

public class Solution {
   static class Node{
        ArrayList<Node> neighbors;
        int val;
        int degree;
        public Node(int i){
            neighbors = new ArrayList<Node>();
            val = i;
        }
    }
    public String alienOrder(String[] words){
        boolean[] happend = new boolean[26];
        Node[] nodes = new Node[26];
       // build the graph
        for(int i = 0; i < 26; i++) nodes[i] = new Node(i);
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j<words[i].length();j++) happend[words[i].charAt(j)-'a'] = true;
            if(i == words.length-1) break;
            int j = 0;
            boolean flag = false;
            for(j = 0; j < words[i].length()&&j<words[i+1].length();j++){
                if(words[i].charAt(j)!=words[i+1].charAt(j)){
                    flag = true;
                    int start = words[i].charAt(j) - 'a';
                    int end = words[i+1].charAt(j) - 'a';
                    nodes[start].neighbors.add(nodes[end]);
                    nodes[end].degree++;
                    break;
                }
            }
            if(j<words[i].length()&&!flag) return ""; // for corner case "str", "st", return ""
        }
        String ans = "";
        //topological sort
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < 26; i++){
            if(nodes[i].degree==0&&happend[i]) {
                q.add(nodes[i]);            
                ans = ans + (char)(nodes[i].val + 'a');
            }
        }
   
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(Node i:cur.neighbors){
                i.degree--;
                if(i.degree==0){
                    q.add(i);
                    ans = ans + (char)(i.val + 'a');
                }
            }
        }
        for(int i = 0; i < 26; i++){
            if(nodes[i].degree!=0) return "";
        }
        return ans;
    }
}
 
