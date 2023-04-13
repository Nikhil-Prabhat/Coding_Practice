class Solution {
    public int arrangeCoins(int n) {
       int count = 0;
        long total = 0;
        long sum = 0;

        while (true) {
            ++total;
            sum += total;

            if (sum > n)
                break;
            ++count;
        }

        return count;
    }
}