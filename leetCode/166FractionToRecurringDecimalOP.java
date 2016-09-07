public class Solution {
   public String fractionToDecimal(int numerator, int denominator){
        if(denominator == 0) return "";
        StringBuilder sb = new StringBuilder();
        if((numerator<0&&denominator>0)||(numerator>0&&denominator<0)){
            sb.append('-');
        }
        HashMap<Long,Integer> recursion = new HashMap<>();
        long den =  Math.abs((long)denominator);
        long n = Math.abs((long)numerator/(long)denominator);
        long remainder = Math.abs((long)numerator%(long)denominator);
        sb.append(n);
        if(remainder == 0){
            return sb.toString();
        }
        sb.append('.');
        while(!recursion.containsKey(remainder)){
            recursion.put(remainder,sb.length());
            remainder*=10;
            n = remainder/den;
            remainder = remainder%den;
            sb.append(n);
            if(remainder == 0){
                return sb.toString();
            }
        }
        int count = recursion.get(remainder);
        sb.insert(count,'(');
        sb.append(')');
        return sb.toString();
    }
}
