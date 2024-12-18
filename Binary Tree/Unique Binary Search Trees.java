class Solution {
    public int numTrees(int n) {
        int[] memoizedTableForNodesPossible = new int[n + 1];
        Arrays.fill(memoizedTableForNodesPossible, 1);

        IntStream.rangeClosed(2, n)
                .forEach(
                        currentRoot -> {
                            memoizedTableForNodesPossible[currentRoot] = getRootCount(currentRoot,
                                    memoizedTableForNodesPossible);
                        });

        return memoizedTableForNodesPossible[n];
    }

    // This method is to create memoization table on the go for all the previous
    // tree nodes
    private int getRootCount(int currentNode, int[] memoizedTableForNodesPossible) {
        return IntStream.rangeClosed(1, currentNode)
                .map(root -> {
                    var leftNodeCount = root - 1;
                    var rightNodeCount = currentNode - root;
                    return (memoizedTableForNodesPossible[leftNodeCount]
                            * memoizedTableForNodesPossible[rightNodeCount]);
                })
                .sum();
    }
}
