class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        List<List<Long>> pathSumCombinationList = new ArrayList<>();
        List<Long> pathSumLevelList = new ArrayList<>();
        iterateTreeAndCalculatePathSum(root, pathSumLevelList, pathSumCombinationList);

        return (int) pathSumCombinationList.stream()
                .flatMap(List::stream)
                .filter(pathSum -> pathSum == targetSum)
                .count();
    }

    private void iterateTreeAndCalculatePathSum(TreeNode treeNode, List<Long> pathSumsAtEachLevel,
            List<List<Long>> pathSumsSoFar) {
        if (Objects.nonNull(treeNode)) {
            List<Long> tempPathSums = new ArrayList<>();
            for (long pathSumVal : pathSumsAtEachLevel) {
                tempPathSums.add(pathSumVal + treeNode.val);
            }
            tempPathSums.add((long) treeNode.val);
            pathSumsSoFar.add(new ArrayList<>(tempPathSums));

            iterateTreeAndCalculatePathSum(treeNode.left, tempPathSums, pathSumsSoFar);
            iterateTreeAndCalculatePathSum(treeNode.right, tempPathSums, pathSumsSoFar);
        }
    }
}
