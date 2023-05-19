class Solution {
    
    public String smallestNumber(String pattern) {

        String SMALLEST_NUMBER = "";
        int[] numberArray = new int[pattern.length() + 1];
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = i + 1;
        }

        // Find the index of all 'D' in the pattern and reverse it till the first encountered 'I'
        for (int i = 0; i < pattern.length(); i++) {
            // We won't decrease the tempIndex as the size of pattern is 1 less than the size of numberArray
            int tempIndex = i;
            while (tempIndex < pattern.length() && Character.compare(pattern.charAt(tempIndex), 'D') == 0)
                tempIndex++;

            reverseTheArray(numberArray, i, tempIndex);

            // Just mark the index till where the operation has been executed
            if(tempIndex != i)
                i = --tempIndex;
        }

        // Return the numberArray in string
        for(Integer number : numberArray)
            SMALLEST_NUMBER += number;

        return SMALLEST_NUMBER;

    }

    private void reverseTheArray(int[] numberArray, int startIndex, int lastIndex) {
        while (startIndex < lastIndex) {
            int tempValue = numberArray[startIndex];
            numberArray[startIndex] = numberArray[lastIndex];
            numberArray[lastIndex] = tempValue;
            startIndex++;
            lastIndex--;
        }
    }
}