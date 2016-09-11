public String reverseHTMLEntity(String str){
    char[] chars = str.toCharArray();
    reverse(chars,0,chars.length-1);
    boolean flag = false;
    int start = 0;
    for(int i = 0; i < chars.length; i++){
        if(chars[i]==’;’){
            flag = true;
            start = i;
        }else if(chars[i]==’&’&&flag){
            reverse(chars,start,i);
            flag = false;
        }        
    }
    return new String(chars);
}

public void reverse(char[] chars, int start, int end){
    while(start<end){
        int tmp = chars[start];
        chars[start] = chars[end];
        chars[end] = tmp;
        start++;
        end--;
    }
}
