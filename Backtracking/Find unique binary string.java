class Solution {

    Map<String, Boolean> uniqueStrMap = new HashMap<>();
    int[] binaryArray = new int[]{0, 1};
    String result = "";
    Boolean isFound = false;


    public String findDifferentBinaryString(String[] nums) {
        for (String num : nums)
            uniqueStrMap.put(num, true);

        int length = nums.length != 0 ? nums[0].length() : 0;
        String finalResult = "";
        generateStrings(finalResult, length, 0);
        return result;
    }

    private void generateStrings(String finalString, int length, int currentIterationLength ) {
        if (finalString.length() <= length ) {

            // Base case
            if (finalString.length() == length && Objects.isNull(uniqueStrMap.get(finalString))) {
                result = finalString;
                isFound = true;
                return;
            }

            if(isFound)
                return;

            for(int i=0; i< 2 && currentIterationLength < length && !isFound; i++) {
                int element = binaryArray[i];
                generateStrings(finalString + element, length, currentIterationLength+1);
            }
        }
    }
}