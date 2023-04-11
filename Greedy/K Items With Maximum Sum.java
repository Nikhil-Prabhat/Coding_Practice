class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {

        if (numOnes >= k)
            return k;
        else if (numOnes + numZeros >= k)
            return numOnes;
        else {
            int countOfOnesAndZeroes = numOnes + numZeros;
            int countOfNegativeNumbers = k - countOfOnesAndZeroes;
            return numOnes - countOfNegativeNumbers;
        }

    }
}