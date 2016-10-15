
public class ValidWordAbbr{
    Map<String, Set<String>> map = new HashMap<>();
    
    public ValidWordAbbr(String[] dictionary) {
        for(String word : dictionary){
            String abbrev = getAbbreviation(word);
            if(!map.containsKey(abbrev)){
                map.put(abbrev, new HashSet<String>());
            }
            map.get(abbrev).add(word);
        }
    }
    
    public String getAbbreviation(String word){
        if(word.length()<3){
            return word;
        }else{
            return word.charAt(0)+String.valueOf(word.length()-2)+word.charAt(word.length()-1);
        }
    }
    
    public boolean isUnique(String word){
          String abbr = getAbbreviation(word);
          if(!map.containsKey(abbr) || (map.get(abbr).size()==1 && map.get(abbr).contains(word))) return true;
          return false;
    }
}




// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
