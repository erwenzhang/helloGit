 /*brief version*/
 public String minWindow(String s, String t){
        if (s == null || t == null || s.length() < t.length()||t.isEmpty()) { return "";}
        int[] target = new int[256];
        for(int i = 0; i<t.length();i++){
            target[t.charAt(i)]++;
        }
        int minLen = Integer.MAX_VALUE;
        String ret = "";
        int start = 0;
        int end = 0;
        int found = 0;
        while(end<s.length()){     
            if(target[s.charAt(end++)]-->0){
                found++;
             }
             while(found==t.length()){ //valid
                 if(end-start<minLen){
                     ret = s.substring(start,end);
                     minLen = end - start;
                 }          
                 if(target[s.charAt(start++)]++==0){
                         found--; //make it invalid
                 }   
             }         
       }
       return ret;
    }
    
  /*complete version*/
  
  public String minWindow(String s, String t){
        if (s == null || t == null || s.length() < t.length()||t.isEmpty()) { return "";}
        int[] target = new int[256];
        int[] window = new int[256];
        for(int i = 0; i<t.length();i++){
            target[t.charAt(i)]++;
        }
        int minLen = Integer.MAX_VALUE;
        String ret = "";
        int start = 0;
        int end = 0;
        int found = 0;
        while(end<s.length()){     
            if(target[s.charAt(end)]>0){
                if(target[s.charAt(end)]>window[s.charAt(end)]){
                    found++;
                }
                window[s.charAt(end)]++;
             }
             end++;
             while(found==t.length()){
                 if(end-start<minLen){
                     ret = s.substring(start,end);
                     minLen = end - start;
                 }          
                 if(target[s.charAt(start)]>0){
                     window[s.charAt(start)]--;
                     if(target[s.charAt(start)]>window[s.charAt(start)]){
                         found--;
                     }
                 }  start++;
             }
            
       }
       return ret;
 }
