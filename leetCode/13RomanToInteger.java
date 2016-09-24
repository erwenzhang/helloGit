public class Solution {
    private Map<Character, Integer> map =
        new HashMap<Character, Integer>() {{
        put('I', 1); put('V', 5); put('X', 10);
        put('L', 50); put('C', 100); put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String roman){
        char[] romanArray = roman.toCharArray();
        int len = romanArray.length;
        int result = 0;
        int pre = 0;
        for(int i = 0; i < len;i++){
            int cur = map.get(romanArray[i]);
            result += (cur>pre)?(cur-pre*2):cur;
            pre = cur;
        }
        return result;
    }
}
