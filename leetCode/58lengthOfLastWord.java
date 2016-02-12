 public int lengthOfLastWord(String s) {
        int i = s.length()-1;
        int len = 0;
        for(;i>=0;i--){
        	if(s.charAt(i)==' '){
        		if(len==0)
        			continue;
        		else 
        			break;
            }else{
            		len++;
            }
        	
        }  
        return len;     
  }
