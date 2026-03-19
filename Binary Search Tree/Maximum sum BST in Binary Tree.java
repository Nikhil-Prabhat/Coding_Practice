class Solution {
    int maximumSum = 0;

    public int maxSumBST(TreeNode root) {
        computeMaxSumForEachNode(root);
        return maximumSum;
    }

    private int[] computeMaxSumForEachNode(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return new int[] { 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 1 };
        }

        int[] leftSubTreeResult = computeMaxSumForEachNode(treeNode.left);
        int[] rightSubTreeResult = computeMaxSumForEachNode(treeNode.right);

        if (leftSubTreeResult[3] == 1 && rightSubTreeResult[3] == 1 && leftSubTreeResult[2] < treeNode.val
                && rightSubTreeResult[1] > treeNode.val) {
            var sumOfCurrentBST = treeNode.val + leftSubTreeResult[0] + rightSubTreeResult[0];
            maximumSum = Math.max(sumOfCurrentBST, maximumSum);
            return new int[] { sumOfCurrentBST, Math.min(leftSubTreeResult[1], treeNode.val),
                    Math.max(treeNode.val, rightSubTreeResult[2]), 1 };
        }

        return new int[] { 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0 };
    }
}
