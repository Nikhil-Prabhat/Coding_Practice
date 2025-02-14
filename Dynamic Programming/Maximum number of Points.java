class Solution {
    public long maxPoints(int[][] points) {
        int rowLength = points.length;
        int colLength = points[0].length;
        int[] prevRow = points[0];

        for (int i = 1; i < rowLength; i++) {
            int[] nextRow = points[i];
            int[] leftIntermediateArr = new int[colLength];
            int[] rightIntermediateArr = new int[colLength];

            leftIntermediateArr[0] = prevRow[0];
            for (int j = 1; j < colLength; j++) {
                leftIntermediateArr[j] = Math.max(prevRow[j], leftIntermediateArr[j - 1] - 1);
            }

            rightIntermediateArr[colLength - 1] = prevRow[colLength - 1];
            for (int j = colLength - 2; j > -1; j--) {
                rightIntermediateArr[j] = Math.max(prevRow[j], rightIntermediateArr[j + 1] - 1);
            }

            for (int j = 0; j < colLength; j++) {
                nextRow[j] += Math.max(leftIntermediateArr[j], rightIntermediateArr[j]);
            }

            prevRow = Arrays.copyOf(nextRow, nextRow.length);
        }

        return Arrays.stream(prevRow).max().getAsInt();
    }
}
