public class Solution {
  public List<String> generatePalindromes(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        List<String> palindromes = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.get(c) == null){
                map.put(c,new Integer(0));
            }
            map.put(c,map.get(c)+1);
        }
        boolean oddFlag = false;
        String oddChar = "";
        Set<Character> keySet = map.keySet();
        Iterator<Character> it = keySet.iterator();
        while(it.hasNext()){
            Character c = it.next();
            Integer num = map.get(c);
            if(num%2==1){
                if(oddFlag) return palindromes;
                else{
                    oddFlag = true;
                    oddChar = c+"";
                    num = num - 1;
                    map.put(c, num);
                }
            }
            map.put(c,num/2);
        }
        generatePermutations(map, palindromes, "",s.length()/2, oddChar);
        return palindromes;
    }

    public void generatePermutations(HashMap<Character,Integer> map, List<String> palindromes, String str,int len, String oddChar){
        if(str.length()==len){
            StringBuilder sb = new StringBuilder(str);
            sb.reverse().append(oddChar).append(str);
            palindromes.add(sb.toString());
            return;
        }
        Set<Character> keySet = map.keySet();
        Iterator<Character> it = keySet.iterator();
        while(it.hasNext()){
            Character c = it.next();
            if(map.get(c)==0) continue;
            map.put(c,map.get(c)-1);
            generatePermutations(map,palindromes,str+c,len, oddChar);
            map.put(c,map.get(c)+1);
        }
    }
}
