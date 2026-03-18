class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int totalPossibleSum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        if (totalPossibleSum < desiredTotal) {
            return false;
        }

        Map<Integer, Boolean> memoizedMap = new HashMap<>();
        return winComputationHelper(desiredTotal, 0, maxChoosableInteger, memoizedMap);
    }

    private boolean winComputationHelper(int desiredTotal, int state, int maxChoosable,
            Map<Integer, Boolean> memoizedMap) {
        if (memoizedMap.containsKey(state)) {
            return memoizedMap.get(state);
        }

        for (int i = 1; i <= maxChoosable; i++) {

            // The number is already used
            if ((state & (1 << i)) != 0) {
                continue;
            }

            if (desiredTotal - i <= 0) {
                memoizedMap.put(state, true);
                return true;
            }

            int newState = state | (1 << i);
            if (!winComputationHelper(desiredTotal - i, newState, maxChoosable, memoizedMap)) {
                memoizedMap.put(state, true);
                return true;
            }
        }

        memoizedMap.put(state, false);
        return false;
    }
}
