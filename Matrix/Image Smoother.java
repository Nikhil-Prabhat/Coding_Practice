class Solution {
    record IndexPair(int firstIndex, int secondIndex) { };

    public int[][] imageSmoother(int[][] img) {

        int[][] smootheredMatrix = new int[img.length][img[0].length];

        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                int averageAtTheCurrentIndex = computeImageSmoother(img, new IndexPair(i, j));
                smootheredMatrix[i][j] = averageAtTheCurrentIndex;
            }
        }
        return smootheredMatrix;
    }

    private int computeImageSmoother(int[][] img, IndexPair indexPair) {
        int firstIndex = indexPair.firstIndex();
        int secondIndex = indexPair.secondIndex();
        int subsequentSum = 0;
        int subsequentCount = 0;

        if (firstIndex >= 0 && firstIndex < img.length && secondIndex >= 0 && secondIndex < img[0].length) {

            // Top Row Case
            if ((firstIndex - 1) >= 0) {

                // Top Left Diagonal Case
                if ((secondIndex - 1) >= 0) {
                    subsequentCount++;
                    subsequentSum += img[firstIndex - 1][secondIndex - 1];
                }

                // Top Right Diagonal Case
                if ((secondIndex + 1) < img[0].length) {
                    subsequentCount++;
                    subsequentSum += img[firstIndex - 1][secondIndex + 1];
                }

                // Top Case
                subsequentCount++;
                subsequentSum += img[firstIndex - 1][secondIndex];
            }

            // Bottom Row Case
            if ((firstIndex + 1) < img.length) {

                // Botton Left Diagonal Case
                if ((secondIndex - 1) >= 0) {
                    subsequentCount++;
                    subsequentSum += img[firstIndex + 1][secondIndex - 1];
                }

                // Botton Right Diagonal Case
                if ((secondIndex + 1) < img[0].length) {
                    subsequentCount++;
                    subsequentSum += img[firstIndex + 1][secondIndex + 1];
                }

                // Botton Case
                subsequentCount++;
                subsequentSum += img[firstIndex + 1][secondIndex];
            }

            // Same Row Case
            // Left Case
            if ((secondIndex - 1) >= 0) {
                subsequentCount++;
                subsequentSum += img[firstIndex][secondIndex - 1];
            }

            // Right Case
            if ((secondIndex + 1) < img[0].length) {
                subsequentCount++;
                subsequentSum += img[firstIndex][secondIndex + 1];
            }

            // Middle Value
            subsequentCount++;
            subsequentSum += img[firstIndex][secondIndex];
        }

        int average = subsequentCount != 0 ? (subsequentSum / subsequentCount) : 0;
        return average;
    }
}
