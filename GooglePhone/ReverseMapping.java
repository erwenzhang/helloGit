链接: https://instant.1point3acres.com/thread/185005
来源: 一亩三分地

public void ReverseMapping(String[] strs, int[] map){
    for(int i = 0; i< map.length(); i++){
        int j = i;
        while(map[j]!=i){
            swap(strs, j, map[j]);
            int tmp = map[j];
            map[j] = j;
            j = tmp;
        }
        map[j] = j;    
    }
}

public void swap(String[] strs, int i, int j){
    String tmp = strs[i];
    strs[i] = strs[j];
    strs[j] = tmp;
}
