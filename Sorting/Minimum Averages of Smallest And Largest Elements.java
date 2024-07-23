class Solution {
    public double minimumAverage(int[] nums) {
        PriorityQueue<Float> priorityQueue = new PriorityQueue<>();
        int initialIndex = 0, lastIndex = nums.length-1, counter=0, lenOfArray = nums.length;
        Arrays.sort(nums);

        while(counter++ <= lenOfArray/2) {
            float avg = ((float) (nums[initialIndex] + nums[lastIndex])) / 2;
            priorityQueue.add(avg);

            initialIndex++;
            lastIndex--;
        }

        return priorityQueue.peek();
    }
}