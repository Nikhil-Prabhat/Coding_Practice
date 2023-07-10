class Solution {
    public int minMaxDifference(int num) {
        String numString = String.valueOf(num);
        int index = -1;

        // Find the first index where the char is not 9 and replace it with 9
        for(int i=0;i<numString.length();i++) {
            if(Character.compare(numString.charAt(i), '9') != 0) {
                index = i;
                break;
            }
        }

        int maxNumber = index != -1 ? Integer.parseInt(String.valueOf(num).replace(numString.charAt(index), '9')) : num;
        int minNumber = Integer.parseInt(String.valueOf(num).replace(numString.charAt(0), '0'));
        return maxNumber - minNumber;
    }
}