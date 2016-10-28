 public int calculate(String s) {
        int res = 0;
        long pre = 0;
        long cur = 0;
        char operator = '+';
        for(int i = 0;i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                int digit = 0;
                while(i<s.length()&&Character.isDigit(s.charAt(i))){
                    digit = digit*10+ s.charAt(i)-'0';
                    i++;
                }
                i--;
                cur = digit;
                if(operator=='+'){
                    res += pre;
                    pre = cur;
                }else if(operator=='-'){
                   res += pre;
                   pre = -cur;
                }else if(operator=='*'){
                    pre = pre*cur;
                }else{
                    pre = pre/cur;
                }
            }else if(i<s.length()&&s.charAt(i)!=' '){
                operator = s.charAt(i);
            }
        }
        res += pre;
        return res;
    }
