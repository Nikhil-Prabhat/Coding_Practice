class Solution {
    public int minimumOperations(int[] nums) {
        return Arrays.stream(nums)
                .filter(num -> num% 3 != 0)
                .reduce(0, (accumulator, currentElement)-> accumulator + 1);

    }
}