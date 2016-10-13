  public int validPython(String[] codes){
        boolean flag = false;
        Stack<Integer> stack = new Stack<>();
        String s = codes[0];
        if(s.startsWith(" ")) System.out.print(0);
        for(int j = 1; j<codes.length;j++){
            String code = codes[j];
            int coutn = 0;
            int i = 0;
            while(i<=code.length()-4&&code.substring(i,i+4).equals("      ")) {coutn++;i+=4;}
            if(code.charAt(i)==' ') {return j;}
            if(flag){
                if(stack.isEmpty()) return j;
                else if(coutn!=stack.peek()+1) return j;
                flag = false;
            }else {
                while(!stack.isEmpty()&&stack.peek()>coutn) stack.pop();
                if(!stack.isEmpty()&&stack.peek()!=coutn) return j;
            }
            stack.push(coutn);
            int loc = code.indexOf(" ",i);
            if(loc!=-1){
                String sub = code.substring(i,loc);
                if(sub.equals("for")||sub.equals("if")||sub.equals("else")) {
                    flag = true;
                }
            }
        }
        return -1;
    }
