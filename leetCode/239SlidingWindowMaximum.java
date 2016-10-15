 public int[] maxSlidingWindow(int[] nums, int k) {
           if(nums==null || nums.length==0 || k<=0) return new int[0];
           Deque<Integer> queue = new ArrayDeque<>();
           int index = 0;
           int[] res = new int[nums.length-k+1];
           for(int i=0; i<nums.length; i++){
               while(!queue.isEmpty() && queue.peekFirst()<i-k+1) queue.pollFirst();
               while(!queue.isEmpty() && nums[queue.peekLast()]<nums[i]) queue.pollLast();
               queue.add(i);
               if(i>=k-1) res[index++] = nums[queue.peekFirst()];
           }
           return res;
}
