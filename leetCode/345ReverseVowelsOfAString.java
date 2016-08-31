public String reverseVowels(String str){
    char[] chars = str.toCharArray();
    String vowels = "aeiouAEIOU";
    int start = 0;
    int end = chars.length-1;
    while(start<end){
        while(start<end&&!vowels.contains(chars[start]+"")){
            start++;
        }
        while(start<end&&!vowels.contains(chars[end]+"")){
            end--;
        }
        char tmp = chars[start];
        chars[start] = chars[end];
        chars[end] = tmp;
        start++;
        end--;
    }
    return new String(chars);
 }
