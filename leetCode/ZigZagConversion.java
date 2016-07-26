public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i=0;i<numRows;i++){
           sbs[i] = new StringBuilder();
        }
        int i = 0;
        while(i<s.length()){
           for(int indx = 0;indx<numRows&&i<s.length();indx++)
             sbs[indx].append(s.charAt(i++));
           for(int indx = numRows-2;indx>=1&&i<s.length();indx--)
             sbs[indx].append(s.charAt(i++));
        }
        for(int indx=1;indx<numRows;indx++)
          sbs[0].append(sbs[indx]);
        return sbs[0].toString();
    }
}
