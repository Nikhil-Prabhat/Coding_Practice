class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
       int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        int value,ind1,ind2;

        for(int i=0;i<rowLength;i++)
        for(int j=0;j<columnLength;j++)
        {
            ind1 = i;
            ind2 = j;
            value = matrix[ind1][ind2];
            while (true)
            {
                try {
                    if(value == matrix[++ind1][++ind2])
                        continue;
                    else
                        return false;
                }
                catch (Exception e) {
                    break;
                }
            }
        }

        return true;
    }
}