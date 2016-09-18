public class Solution {
    public boolean isNumber(String s){
        int i = 0, n = s.length();
        boolean isNumeric = false;
        while(i<n&&s.charAt(i)==' ') i++;
        if(i<n&&s.charAt(i)=='-'||i<n&&s.charAt(i)=='+') i++;
        while(i<n&&Character.isDigit(s.charAt(i))){ i++; isNumeric = true;}
        if(i<n&&s.charAt(i)=='.'){
            i++;
            while(i<n&&Character.isDigit(s.charAt(i))){
                i++;
                isNumeric = true;
            }
        }
        if(isNumeric&&i<n&&s.charAt(i)=='e'){
            i++;
            isNumeric = false;
            if(i<n&&s.charAt(i)=='-'||i<n&&s.charAt(i)=='+') i++;
            while(i<n&&Character.isDigit(s.charAt(i))){
                i++;
                isNumeric = true;
            }
        }
        while(i<n&&s.charAt(i)==' ') i++;
        return isNumeric&&i==n;
    }
}
