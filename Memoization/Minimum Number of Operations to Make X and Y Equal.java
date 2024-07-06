class Solution {

    int[] memTable = new int[10011];
    
    public int minimumOperationsToMakeEqual(int x, int y) {
        Arrays.fill(memTable, -1);
        return computeMinimumOperations(x, y);
    }

    private int computeMinimumOperations(int x, int y) {
        if (x <= y)
            return y - x;

        if (memTable[x] != -1)
            return memTable[x];

        int res = Math.abs(x - y);
        res = Math.min(res, 1 + x % 5 + computeMinimumOperations(x / 5, y));
        res = Math.min(res, 1 + (5 - x % 5) + computeMinimumOperations(x / 5 + 1, y));
        res = Math.min(res, 1 + x % 11 + computeMinimumOperations(x / 11, y));
        res = Math.min(res, 1 + (11 - x % 11) + computeMinimumOperations(x / 11 + 1, y));
        return memTable[x] = res;
    }
}
