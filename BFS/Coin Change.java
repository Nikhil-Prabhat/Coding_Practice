class Solution {

    int[][] memoizedTable;

    public int coinChange(int[] coins, int amount) {
        memoizedTable = new int[coins.length][amount + 1];
        IntStream.range(0, coins.length)
                .forEach(
                        index -> Arrays.fill(memoizedTable[index], -1));

        int minCoins = getMinCoins(coins, amount, 0, 0, memoizedTable);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    private int getMinCoins(int[] coinArr, int remainingAmount, int coinCount, int currentIndex, int[][] memTable) {
        if (remainingAmount == 0) {
            return 0;
        }

        if (remainingAmount < 0 || currentIndex >= coinArr.length) {
            return Integer.MAX_VALUE;
        }

        if (memoizedTable[currentIndex][remainingAmount] != -1) {
            return memoizedTable[currentIndex][remainingAmount];
        }

        // Ignoring the current coin
        int whenCurrentCoinIsIgnored = getMinCoins(coinArr, remainingAmount, coinCount, currentIndex + 1, memTable);

        // Considering the current coin
        int whenCurrentCoinIsConsidered = getMinCoins(coinArr, remainingAmount - coinArr[currentIndex], coinCount + 1,
                currentIndex, memTable);

        if (whenCurrentCoinIsConsidered != Integer.MAX_VALUE) {
            whenCurrentCoinIsConsidered++;
        }

        memoizedTable[currentIndex][remainingAmount] = Math.min(whenCurrentCoinIsIgnored, whenCurrentCoinIsConsidered);
        return memoizedTable[currentIndex][remainingAmount];
    }
}
