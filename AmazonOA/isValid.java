public boolean isValid(String s){
		if(s==null||s.length()== 0) return true;
		Stack<Character> stack = new Stack<>();
		for(int i = 0;i<s.length();i++){
			char x = s.charAt(i);
			if(x=='('||x=='{'||x== '[') stack.push(x);
			else{
					if(stack.isEmpty()) return false;
					char cur = stack.pop();
					switch (cur){
						case '(':
							if(x!=')') return false;
							break;
						case '{':
							if(x!='}') return false;
							break;
						case '[':
							if(x!=']') return false;
							break;
					}

				}
		}
		return stack.isEmpty();
 	}
