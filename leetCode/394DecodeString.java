public class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<String> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        int i = 0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = 0;
                while(i<s.length()&&Character.isDigit(s.charAt(i))){ num = num*10 + s.charAt(i)-'0';i++;}
                count.push(num);
            }else if(c=='['){
                stack.push(res);
                res = "";
                i++;
            }else if(c==']'){
                int num = count.pop();
                StringBuilder sb = new StringBuilder(stack.pop());
                while(num-->0){
                    sb.append(res);
                }
                res = sb.toString();
                i++;
            }else {
                res += c;
                i++;
            }
        }
        return res;
    }
}
