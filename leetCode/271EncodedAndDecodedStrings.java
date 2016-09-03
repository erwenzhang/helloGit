public class Codec{
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs == null || strs.isEmpty()) return null;
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append('N').append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> results = new ArrayList<>();
        if(s == null) return results;
        int start = 0;
        while(start < s.length()){
            int p = s.indexOf('N',start);
            int num = Integer.parseInt(s.substring(start,p));
            String str = s.substring(p+1, p+1+num);
            start = p + num + 1;
            results.add(str);
        }
        return results;
    }
}
