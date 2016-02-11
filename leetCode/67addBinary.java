public String addBinary(String s1, String s2){
    	if(s1==null) return s2;
    	if(s2==null) return s1;
    	int p1 = s1.length()-1, p2 = s2.length()-1;
        String res = "";
        int carry = 0;
        for(;p1>=0&&p2>=0;p1--,p2--){
        	int result = s1.charAt(p1)-'0'+s2.charAt(p2)-'0'+carry;
        	carry = result/2;
        	result = result%2;
        	res = Integer.toString(result)+res;
        }
        for(;p1>=0;p1--){
        	int result = s1.charAt(p1)-'0'+carry;
        	carry = result/2;
        	result = result%2;
        	res = Integer.toString(result)+res;
        }
        for(;p2>=0;p2--){
        	int result = s2.charAt(p2)-'0'+carry;
        	carry = result/2;
        	result = result%2;
        	res = Integer.toString(result)+res;
        }
        if(carry==1)
        res = Integer.toString(carry)+res;
    
        return res;
}
