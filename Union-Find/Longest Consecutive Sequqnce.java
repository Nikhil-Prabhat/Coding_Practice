class Solution {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.naturalOrder());
        Set<Integer> numsSet = new HashSet<>();
        var tempNum = Integer.MIN_VALUE;
        var prevNum = Integer.MIN_VALUE;
        var finalCount = 0;
        var tempCount = 0;

        Arrays.stream(nums).forEach(numsSet::add);
        numsSet.forEach(priorityQueue::add);

        while (!priorityQueue.isEmpty()) {
            var isFirstNum = false;

            if (tempNum == Integer.MIN_VALUE) {
                isFirstNum = true;
                tempCount = tempCount + 1;
            }

            tempNum = priorityQueue.poll();

            if (!isFirstNum) {
                if (prevNum + 1 == tempNum) {
                    tempCount = tempCount + 1;

                } else {
                    prevNum = tempNum;
                    tempNum = Integer.MIN_VALUE;
                    finalCount = finalCount < tempCount ? tempCount : finalCount;
                    tempCount = 1;
                    continue;
                }
            }

            prevNum = tempNum;
        }

        finalCount = finalCount < tempCount ? tempCount : finalCount;

        return finalCount;
    }
}

// Workable solution

class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int max=0;
        if(nums.length<=1) return nums.length;
        for(int i=1;i<nums.length;i++){
            int count=1;
            while(i<nums.length && nums[i]-nums[i-1]==1) {
                count++;
                i++;
                while(i<nums.length && nums[i]-nums[i-1]==0)i++;
            }
            max=Math.max(max,count);
        }
        return max;
    }
}
