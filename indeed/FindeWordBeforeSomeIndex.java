  public String findWord(String s, int len){
        if(s.length()<=len) return s;
        int spaceIndex = s.lastIndexOf(" ", len-1);
        return spaceIndex == -1?null:s.substring(0,spaceIndex);
    }
