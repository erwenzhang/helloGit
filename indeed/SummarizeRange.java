public List<String> summarizeRange(int[] nums){
        List<String> results = new ArrayList<>();
        if(nums == null ||nums.length == 0) return results;

        int pace = -1;
        int start = nums[0];
        int end = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == end + pace){
                end = nums[i];
                continue;
            }
            if(pace == -1){
                pace = nums[i] - end;
                end = nums[i];
            }else{
                results.add(generateString(start,end,pace));
                pace = -1;
                start = nums[i];
                end = nums[i];
            }

        }
        results.add(generateString(start,end,pace));
        return results;
    }

    public String generateString(int start, int end, int pace){
        return pace==-1?String.valueOf(end):String.format("%d-%d/%d", start, end, pace);
    }
