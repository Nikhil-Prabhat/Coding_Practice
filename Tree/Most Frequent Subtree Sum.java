class Solution {

    Map<Integer, List<Integer>> subtreeSumMap = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        calculateSumUptoRoot(root);
        return findMaximumFrequencyKeys();
    }

    private int[] findMaximumFrequencyKeys() {
        List<Integer> subtreeSumList = new ArrayList<>();
        int maxSize = Integer.MIN_VALUE;

        for (Map.Entry<Integer, List<Integer>> entry : subtreeSumMap.entrySet()) {
            var sizeOfKey = entry.getValue().size();

            if (sizeOfKey > maxSize) {
                maxSize = sizeOfKey;
                subtreeSumList.clear();
                subtreeSumList.add(entry.getKey());
            } else if (sizeOfKey == maxSize) {
                subtreeSumList.add(entry.getKey());
            }
        }

        return subtreeSumList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int calculateSumUptoRoot(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return 0;
        }

        var leftSubtreeSum = calculateSumUptoRoot(treeNode.left);
        var rightSubtreeSum = calculateSumUptoRoot(treeNode.right);

        var sumUptoThisNode = leftSubtreeSum + rightSubtreeSum + treeNode.val;
        subtreeSumMap.computeIfAbsent(sumUptoThisNode, key -> new ArrayList<>()).add(treeNode.val);
        return sumUptoThisNode;
    }
}
