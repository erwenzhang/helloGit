public class Solution {
   
    public List<String> generatePalindromes(String s) {
           if(s==null || s.length()==0) return new ArrayList<String>();
           int[] count = new int[256];
           for(int i=0; i<s.length(); i++){
               count[s.charAt(i)]++;
           }
           int num = 0;
           List<String> result = new ArrayList<String>();
           String median = "";
           for(int i=0; i<256; i++){
               if(count[i]%2==1) {
                   num++;
                   median += (char)i;
               }
               if(num>1) return result;
               else count[i]/=2;
           }
           helper(count, "", result, s.length(), median);   
           return result;
    }
    
    public void helper(int[] count, String str, List<String> result, int len, String median){
        if(str.length()==len/2){
            StringBuilder temp = new StringBuilder(str);
            temp.reverse();
            temp.append(median).append(str);
            result.add(temp.toString());
            return;
        }
        
        for(int i=0; i<count.length; i++){
            if(count[i]>0){
                count[i]--;
                helper(count, str+(char)i, result, len, median);
                count[i]++;
            }
        }
    }
}
