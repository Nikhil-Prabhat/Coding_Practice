class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int listLen = nums.size();
        int result = listLen;
        int firstIndex = 0, secondIndex = (listLen + 1) / 2;

        while (firstIndex < listLen / 2 && secondIndex < listLen) {
            if (nums.get(firstIndex) < nums.get(secondIndex))
                result -= 2;

            firstIndex++;
            secondIndex++;
        }

        return result;
    }
}
