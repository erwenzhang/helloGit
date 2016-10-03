public class Solution {
    public List<String> removeInvalidParentheses(String s){
        List<String> list = new ArrayList<>();
        int l = 0;
        int r = 0;
        for(int  i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                l++;
            }else if(c==')'){
                if(l>0) l--;
                else{ r++;}
            }else{
                continue;
            }
        }
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();
        dfs(s,0,l,r,0,set,sb);
        ArrayList<String> result = new ArrayList<String>(set);
        return result;
    }

    public void dfs(String s, int index, int left, int right, int open, HashSet<String> set, StringBuilder sb){
        if(left==0&&right==0&&open==0&&index==s.length()){
            set.add(sb.toString()); return;
        }
        if(index==s.length()||left<0||right<0||open<0){
            return;
        }

        char c = s.charAt(index);
        int len = sb.length();
        if(c=='('){
            dfs(s, index+1, left-1, right, open, set, sb);
            dfs(s, index+1, left, right, open+1, set, sb.append(c));
        }else if(c==')'){
            dfs(s,index+1, left, right-1, open, set,sb);
            dfs(s, index+1, left, right, open-1, set,sb.append(c));
        }else{
            dfs(s,index+1,left, right, open,set,sb.append(c));
        }
        sb.setLength(len);
    }
}
