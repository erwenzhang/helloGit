class TrieNode{
    public TrieNode[] children = new TrieNode[26];
    public boolean isLeaf = false;
}

class Trie{
    public TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        if(word==null) return;
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c-'a']==null){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isLeaf = true;
    }
}
    
    public List<String> findWords(char[][] board, String[] words) {
        if(board==null || board.length==0 || board[0].length==0 || words==null || words.length==0) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        Trie trie = new Trie();
        for(int i=0; i<words.length; i++){
            trie.insert(words[i]);
        }
        int rows = board.length;
        int cols = board[0].length;
        
        boolean[][] visited = new boolean[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                helper(board, i, j, visited, trie.root, result, "");
            }
        }
        return result;
    }
    
    private void helper(char[][] board, int i, int j, boolean[][] visited, TrieNode root, List<String> result, String cur){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j] || root.children[board[i][j]-'a']==null) return;
        char c = board[i][j];
        cur += c;
        TrieNode node = root.children[c-'a'];
        if(node.isLeaf){
            result.add(cur);
            node.isLeaf = false;
        }
        boolean hasChildren = false;
        for(int k=0; k<26; k++){
            if(node.children[k]!=null){
                hasChildren = true;
                break;
            }
        }
        if(!hasChildren){
            root.children[c-'a'] = null;
        }
        visited[i][j] = true;
        helper(board, i-1, j, visited, node, result, cur);
        helper(board, i+1, j, visited, node, result, cur);
        helper(board, i, j-1, visited, node, result, cur);
        helper(board, i, j+1, visited, node, result, cur);
        visited[i][j] = false;
    }
    
    
    
    class TrieNode{
    public boolean isLeaf = false;
    public Map<Character, TrieNode> children;
    public char val;
    public TrieNode(){
        this.val = ' ';
        this.children = new HashMap<>();
    }
    public TrieNode(char val){
        this.val = val;
        this.children = new HashMap<>();
    }
    
}

class Trie{
    public TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        if(word==null || word.length()==0) return;
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
          if(!node.children.containsKey(word.charAt(i))){
              node.children.put(word.charAt(i), new TrieNode(word.charAt(i)));
          }
          node = node.children.get(word.charAt(i));
        }
        node.isLeaf = true;
    }
}
    public List<String> findWords(char[][] board, String[] words) {
       if(words==null || words.length==0 || board==null || board.length==0 || board[0].length==0) return
         new ArrayList<>();
      
       Trie trie = new Trie();
      for(String word : words){
          trie.insert(word);
      }
    
      int rows = board.length;
      int cols = board[0].length;
      boolean[][] visited = new boolean[rows][cols];
      List<String> result = new ArrayList<>();
      for(int i=0; i<rows; i++){
          for(int j=0; j<cols; j++){
          
              helper(board, i, j, visited, result, trie.root, "");
          }
      }
      
      return result;
    }
    
  private void helper(char[][] board, int i, int j, boolean[][] visited, List<String> result, TrieNode root, String sb){
    if(i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j]) return;
    if(!root.children.containsKey(board[i][j])) return;
    TrieNode node = root.children.get(board[i][j]);
    sb+=board[i][j];
    
    if(node.isLeaf){
        result.add(sb.toString());
        node.isLeaf = false;
    }
    
    if(node.children.isEmpty()){
        root.children.remove(node.val);
    }
    
    visited[i][j] = true;
    helper(board, i-1, j, visited, result, node, sb);
    helper(board, i+1, j, visited, result, node, sb);
    helper(board, i, j+1, visited, result, node, sb);
    helper(board, i, j-1, visited, result, node, sb);
    visited[i][j] = false;
  }
