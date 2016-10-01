public List<String> wordBreak(String s, Set<String> wordDict) {
    HashMap<String, List<String>> map = new HashMap<>();     
    return helper(s, wordDict, map);
}

public List<String> helper(String s, Set<String> wordDict, HashMap<String, List<String>> cache){
    if(cache.containsKey(s)) return cache.get(s);
    List<String> ret = new ArrayList<String>();
    if(s.isEmpty()) return ret;
    for(int i = 1; i <= s.length(); i++){
        String item = s.substring(0,i);
        if(wordDict.contains(item)){
            if(i==s.length()){
                ret.add(item);
            }else{
                List<String> words = helper(s.substring(i),wordDict,cache);
                for(String word: words){
                    ret.add(item+" "+word);
                }
            }
        }
    }
    cache.put(s, ret);
    return ret;
}
