public List<String> wordBreak(String s, Set<String> wordDict) {
    HashMap<String, List<String>> map = new HashMap<>();     
    return helper(s, wordDict, map);
}

public List<String> helper(String s, Set<String> wordDict, HashMap<String, List<String>> cache){
    if(cache.containsKey(s)) return cache.get(s);
    List<String> ret = new ArrayList<String>();
    if(s.isEmpty()) return ret;
    for(String word: wordDict){
        if(s.startsWith(word)){
            if(word.length()==s.length()) 
                ret.add(word);
            else{
                List<String> words =helper(s.substring(word.length()),wordDict,cache);  
                for(String w:words){
                    ret.add(word+" "+w);
                } 
            }
        }
    }
    cache.put(s, ret);
    return ret;
}
