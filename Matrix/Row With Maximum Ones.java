class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] result = new int[2];
        int resultRow = -1;
        int maxOne = Integer.MIN_VALUE;

        for (int i = 0; i < mat.length; i++) {
            int countOnes = countOnes(mat[i]);
            if (countOnes > maxOne) {
                maxOne = countOnes;
                resultRow = i;
            }
        }

        result[0] = resultRow;
        result[1] = maxOne;

        return result;
    }

    private int countOnes(int[] arr) {
        int count = 0;
        for (int arrValue : arr)
            count = arrValue == 1 ? ++count : count;

        return count;
    }
}