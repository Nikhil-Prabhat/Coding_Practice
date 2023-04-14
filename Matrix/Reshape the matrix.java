class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int curr_r = mat.length;
        int curr_c = mat[0].length;
        if(curr_r*curr_c != r*c || curr_r == r && curr_c==c){
            return mat;
        }
            int[][] result = new int[r][c];
            int new_c =0;
            int new_r =0;
            for(int i=0;i<curr_r;i++){
                for(int j =0;j<curr_c;j++){
                    if(new_c == c ){
                        new_r++;
                        new_c=0;
                    }
                    result[new_r][new_c++] = mat[i][j];
                }
            }
            return result;
    }
}