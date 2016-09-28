public static int getLargestTwo(List<Integer> nums){
                List<Integer> sub_0 = new ArrayList<>();
                List<Integer> sub_1 = new ArrayList<>();
                int max = 0;
                for(int k : nums) max = Math.max(max, k);
                int prone = 1;
                while((prone << 1) <= max) prone = (prone << 1);
                prone >> 1;
                for(int k : nums){
                        if((k & prone) != 0) sub_1.add(k);
                        else sub_0.add(k);
                }
                return getLargestTwoHelper(sub_0, sub_1, prone >> 1);
        }. 
        public static int getLargestTwoHelper(List<Integer> nums_1, List<Integer> nums_2, int prone){
                if(nums_1.size() == 0 || nums_2.size() == 0) return 0;
                if(prone == 0) return nums_1.get(0) ^ nums_2.get(0);
                List<Integer> sub_10 = new ArrayList<>();
                List<Integer> sub_11 = new ArrayList<>();
                List<Integer> sub_20 = new ArrayList<>();
                List<Integer> sub_21 = new ArrayList<>();
                for(int m : nums_1){
                        if((m & prone) != 0) sub_11.add(m);
                        else sub_10.add(m);
                }
                for(int m : nums_2){
                        if((m & prone) != 0) sub_21.add(m);
                        else sub_20.add(m);
                }
                if(sub_11.size() > 0 && sub_20.size() > 0 || sub_10.size() > 0 && sub_21.size() > 0)
                        return Math.max(getLargestTwoHelper(sub_21, sub_10, prone >> 1), getLargestTwoHelper(sub_11, sub_20, prone >> 1));
                }else return Math.max(getLargestTwoHelper(sub_20, sub_10, prone >> 1), getLargestTwoHelper(sub_11, sub_21, prone >> 1));
        }
  /*Trie Solution*/  
   class TrieNode{
        int val;
        TrieNode left;
        TrieNode right;
        TrieNode(int val){this.val = val;}
    }
    public int maximumOXR(int[] nums){
        int max = 0;
        for(int k : nums) max = Math.max(max, k);
        int prone = 1;
        while((prone << 1) <= max) prone = (prone << 1);
        TrieNode root = new TrieNode(-1);
        for(int k: nums){
            buildTrie(k, root, prone);
        }
        int maxResult = 0;

        for(int k: nums) {
            StringBuilder sb = new StringBuilder();
            xorMaximum(root, k, prone, sb);
            String str = sb.toString();
//            maxResult = Math.max(maxResult, sb.toS );
        }
        return maxResult;
    }
    public void buildTrie(int k, TrieNode root, int prone){
        if(prone==0) return;
        if((k&prone) == 0) { if(root.left==null)root.left = new TrieNode(0); buildTrie(k, root.left, prone>>1);}
        else{ if(root.right==null)root.right = new TrieNode(1);buildTrie(k%prone, root.right, prone>>1);}
    }

    public void xorMaximum(TrieNode root, int k, int prone, StringBuilder sb){
        if(prone == 0) return;
        if((prone&k)==0){
            if(root.right != null) {sb.append(1); xorMaximum(root.right, k,prone>>1,sb);}
            else{ sb.append(0);xorMaximum(root.left,k,prone>>1,sb);}
        }else {
            if (root.left != null) {
                sb.append(1);
                xorMaximum(root.left, k % prone, prone >> 1, sb);
            } else {
                sb.append(0);
                xorMaximum(root.right, k % prone, prone >> 1, sb);
            }
        }
    }
