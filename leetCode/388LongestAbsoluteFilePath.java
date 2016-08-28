public class Solution {
      public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        List<Integer> length = new ArrayList<>();
        int level;
        int maxLength = 0;
        for(String line:lines){
            String realDir = line.substring(line.lastIndexOf("\t")+1);
            level = line.length() - realDir.length();
            if(realDir.matches(".*\\.\\w*")){
                int filenameAbosoluteLength = realDir.length()+level;
                if(level>0){
                    filenameAbosoluteLength = filenameAbosoluteLength + length.get(level-1);
                }
                maxLength = Math.max(maxLength,filenameAbosoluteLength);
                continue;
            }
            
            int newLength = realDir.length();
            if(level > 0)
                newLength = newLength + length.get(level-1);
            if(level >= length.size()){
                length.add(newLength); 
            }else{
                length.set(level,newLength);
            }
        }
        return maxLength;
    }
}
