public class Solution {
    int minab;
    int minLen;
    public String minAbbreviation(String target, String[] dictionary) {
        List<Integer> dict = new ArrayList<>();
        int n = target.length();
        int bn = 1 << n;
        int countOr = 0;
        minLen = Integer.MAX_VALUE;
        for(String w: dictionary){
            int word = 0;
            if(w.length()!=n) continue;
            for(int i = n - 1, bit = 1; i>=0;i--,bit<<=1){
                if(target.charAt(i)!=w.charAt(i)) word+=bit;
            }
            dict.add(word);
            countOr |= word;
        }
        StringBuilder sb = new StringBuilder();sb.append(0);
        dfs(1,0, dict,bn,countOr,n);
        return reconstruct(target, minab);
    }

    public void dfs(int bit, int mask, List<Integer> dict,int bn, int countOr,int n){
        int tmpLen = abbrLen(mask, n);
        if(tmpLen>= minLen) return;

        boolean match = true;
        for(int d: dict){
            if((mask&d)==0){ match = false;break;}
        }
        if(match){
            minLen = tmpLen;
            minab = mask;
        }else{
            for(int b = bit; b<bn;b<<= 1){
                if((countOr&b)!=0) dfs(b<<1,mask+b, dict,bn, countOr,n);
            }
        }
    }
    public int abbrLen(int mask, int n){
        int count = n;
        int bn = 1 << n;
        for(int b =3 ; b<bn;b<<=1){
            if((mask&b)==0) count--;
        }
        return count;
    }
    public String reconstruct(String target, int minab){
        String res ="";
        for(int i = target.length()-1, pre = i; i >=0 ;i--,minab>>=1){
            if((minab&1)!=0){
                if(pre-i>0) res = Integer.toString(pre-i)+res;
                pre = i - 1;
                res = target.charAt(i)+res;
            }
            else if(i==0){
                res = Integer.toString(pre-i+1)+res;
            }
        }
        return res;
    }
}
