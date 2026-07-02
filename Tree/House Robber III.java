// Tried Solution
class Solution {
    record Pair(int evenLevelSum, int oddLevelSum) {};

    public int rob(TreeNode root) {
        Pair pair = iterateTree(root, 0, 0, 0);
        return Math.max(pair.evenLevelSum(), pair.oddLevelSum());
    }

    private Pair iterateTree(TreeNode treeNode, Integer evenLevelSum, Integer oddLevelSum, int level) {
        if (Objects.nonNull(treeNode)) {
            if (checkIfLevelIsEven.test(level)) {
                evenLevelSum += treeNode.val;
            } else {
                oddLevelSum += treeNode.val;
            }

            Pair leftPair = iterateTree(treeNode.left, evenLevelSum, oddLevelSum, level + 1);
            Pair rightPair = iterateTree(treeNode.right, leftPair.evenLevelSum(), leftPair.oddLevelSum(), level + 1);

            return new Pair(rightPair.evenLevelSum(), rightPair.oddLevelSum());
        }

        return new Pair(evenLevelSum, oddLevelSum);
    }

    private Predicate<Integer> checkIfLevelIsEven = level -> level % 2 == 0;
}
