class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> summaryRangeList = new ArrayList<>();
        
        if(nums.length== 0) {
            return summaryRangeList;
        }

        int prevNum = nums[0], nextNum = -1, index = -1;

        for (index = 1; index < nums.length; index++) {
            nextNum = nums[index - 1];

            if (nums[index] - nextNum != 1) {
                summaryRangeList.add(getSummaryRangeFromCurrentRanges(prevNum, nextNum));
                prevNum = nums[index];
            }
        }

        if (index == nums.length) {
            nextNum = nums[index - 1];
            summaryRangeList.add(getSummaryRangeFromCurrentRanges(prevNum, nextNum));
        }

        return summaryRangeList;
    }

    private String getSummaryRangeFromCurrentRanges(int prevNum, int nextNum) {
        return prevNum != nextNum ? prevNum + "->" + nextNum : prevNum + "";
    }
}
