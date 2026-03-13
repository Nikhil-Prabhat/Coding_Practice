class Solution {

    int MODULO = (int) (1e9 + 7);
    int[] memoizedTable;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        memoizedTable = new int[n+1];
        Arrays.fill(memoizedTable, -1);
        
        int countOfPeople = 0;
        for (int index = n - forget + 1; index <= n; index++) {
            if (index > 0) {
                countOfPeople = (countOfPeople + (getPeopleAwareOfSecretOnSpecificDay(index, delay, forget))) % MODULO;
            }
        }

        return countOfPeople;
    }

    private int getPeopleAwareOfSecretOnSpecificDay(int day, int delay, int forget) {
        if (day == 1) {
            return 1;
        }

        if (memoizedTable[day] != -1) {
            return memoizedTable[day];
        }

        int countOfPeople = 0;
        for (int index = day - forget + 1; index <= day - delay; index++) {
            if (index > 0) {
                countOfPeople = (countOfPeople + getPeopleAwareOfSecretOnSpecificDay(index, delay, forget)) % MODULO;
            }
        }

        return memoizedTable[day] = countOfPeople;
    }
}
