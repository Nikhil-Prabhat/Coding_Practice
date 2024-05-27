class Solution {
    public int minimumPushes(String word) {
        int length = word.length();
        int quotient = length / 8;
        int remainder = length % 8;
        int minimumCost = 0;

        for (int i = quotient; i > 0; i--) {
            minimumCost += (i * 8);
        }

        minimumCost += ((quotient + 1) * remainder);
        return minimumCost;
    }
}