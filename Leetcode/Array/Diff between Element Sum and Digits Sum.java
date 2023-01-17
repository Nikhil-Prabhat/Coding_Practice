class Solution {

    int sumOfDigits = 0;
    int sumOfElements = 0;
    
    public int differenceOfSum(int[] nums) {

        sumOfElements = Arrays.stream(nums).sum();
        sumOfDigits = 0;
        Arrays.stream(nums).forEach(
                num -> {
                    sumOfDigits += findSumOfDigits(num);
                }
        );

        return Math.abs(sumOfDigits - sumOfElements);
    }

    private int findSumOfDigits(int num) {
        int sum = 0;
        while(num != 0)
        {
            sum += num%10;
            num = num/10;
        }
        return sum;
    }
}