public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        Map<Character, char[]> map = new HashMap<Character, char[]>();
        if (digits == null || digits.equals("")) {
            return combinations;
        }
        map.put('0', new char[] {});
        map.put('1', new char[] {});
        map.put('2', new char[] { 'a', 'b', 'c' });
        map.put('3', new char[] { 'd', 'e', 'f' });
        map.put('4', new char[] { 'g', 'h', 'i' });
        map.put('5', new char[] { 'j', 'k', 'l' });
        map.put('6', new char[] { 'm', 'n', 'o' });
        map.put('7', new char[] { 'p', 'q', 'r', 's' });
        map.put('8', new char[] { 't', 'u', 'v'});
        map.put('9', new char[] { 'w', 'x', 'y', 'z' });
        StringBuilder sb = new StringBuilder();
        helper(map, sb, combinations,digits);
        return combinations;
    }

    public void helper(Map<Character, char[]> map, StringBuilder sb, List<String> combinations, String digits){
        if(digits.length()== sb.length()){
            combinations.add(sb.toString());
            return;
        }
        int index = sb.length();
        char[] array =  map.get(digits.charAt(index));
   
        for(char item: array){
            sb.append(item);
            helper(map, sb, combinations, digits);
            sb.setLength(index);
        } 
    }
}
