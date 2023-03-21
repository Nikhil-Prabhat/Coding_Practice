class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int arrayLength = arr.length;
        int[] memTable = new int[arrayLength];
        Arrays.fill(memTable, -1);
        int maxResult = firstPartition(0, arr, k, memTable);
        return maxResult;
    }

    public int firstPartition(int index, int[] arr, int k, int[] memTable) {
        int arrayLength = arr.length;

        if (index == arrayLength)
            return 0;

        if (memTable[index] != -1)
            return memTable[index];

        int max = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        int len = 0;
        for (int j = index; j < Math.min(index + k, arrayLength); j++) {
            len++;
            max = Math.max(max, arr[j]);
            int sum = len * max + firstPartition(j + 1, arr, k, memTable);
            maxAns = Math.max(maxAns, sum);
        }

        memTable[index] = maxAns;
        return maxAns;
    }

}