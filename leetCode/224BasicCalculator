public class Solution {
    public int calculate(String str){
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;
        int digit = 0;
        for(int i = 0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                while(i<str.length()&&Character.isDigit(str.charAt(i))){
                    digit=digit*10+str.charAt(i)-'0';
                    i++;
                }
                i--;
                result = result + sign*digit;
                digit = 0;
            }else if(str.charAt(i)=='+'){
                sign = 1;
            }else if(str.charAt(i)=='-'){
                sign = -1;
            }else if(str.charAt(i)=='('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }else if(str.charAt(i)==')'){
                result = result * stack.pop()+stack.pop();
            }

        }
        return result;
    }
}
