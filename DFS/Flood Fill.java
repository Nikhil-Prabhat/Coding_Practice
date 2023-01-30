class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int column = image[0].length;
        int prevColor = image[sr][sc];
        if(prevColor != newColor)
            createFloodFill(image, sr, sc, row, column, prevColor, newColor);
        return image;
    }

    private void createFloodFill(int[][] image, int sr, int sc, int row, int col, int prevColor, int newColor) {
        // Checking border conditions
        if (sr < 0 || sr >= row || sc < 0 || sc >= col)
            return;

        if (image[sr][sc] != prevColor)
            return;


        // Assign the new color
        image[sr][sc] = newColor;

        // Move 4-directionally
        // Left
        createFloodFill(image, sr, sc - 1, row, col, prevColor, newColor);

        // Right
        createFloodFill(image, sr, sc + 1, row, col, prevColor, newColor);

        // Top
        createFloodFill(image, sr - 1, sc, row, col, prevColor, newColor);

        // Bottom
        createFloodFill(image, sr + 1, sc, row, col, prevColor, newColor);
    }

}