class Solution {
    
    public static int resultNum;
    
    public int missingNumber(int[] nums) {
        int lengthOfArray = nums.length;
        Arrays.sort(nums);
        IntStream intStream = IntStream.range(0, lengthOfArray+1);
        intStream.forEach(
                num ->{
                    if(!checkIfNumberIsPresent(nums,num))
                    {
                       resultNum = num;
                    }
                }
        );

        return resultNum;
    }

    private boolean checkIfNumberIsPresent(int[] nums, int toSearch)
    {
        int low = 0;
        int high = nums.length-1;
        while(low <= high)
        {
            int mid = low + (high-low)/2;

            // If the element is found
            if(nums[mid] == toSearch)
                return Boolean.TRUE;

            // If the element is bigger than the mid element, then search right side of the mid element in the array.
            // If the element is lesser than the mid element, then search left side of the mid element in the array.
            if(nums[mid] < toSearch)
                low = mid +1;
            else
                high = mid -1;
        }

        // If element not found in the array, then return -1;
        return Boolean.FALSE;
    }
}