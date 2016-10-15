public boolean isStrobogrammatic(String num) {
           Map<Character, Character> map = new HashMap<>();
           map.put('0','0');
           map.put('1','1');
           map.put('6','9');
           map.put('8','8');
           map.put('9','6');
          int i=0;
          for(; i<num.length()/2; i++){
              if(!map.containsKey(num.charAt(i)) || !map.get(num.charAt(i)).equals(num.charAt(num.length()-1-i))){
                  return false;
              }
          }
          
          if(num.length()%2==1){
              if(num.charAt(i)!='0' && num.charAt(i)!='1' && num.charAt(i)!='8') return false;
          }
          return true;
    }
