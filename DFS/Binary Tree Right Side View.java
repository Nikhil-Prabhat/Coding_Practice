
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSideViewList = new ArrayList<>();
        iterateRightViewOfTree(root, rightSideViewList, 0);
        return rightSideViewList;
    }

    private void iterateRightViewOfTree(TreeNode treeNode, List<Integer> rightSideViewList, int currentDepth) {
        if (Objects.nonNull(treeNode)) {
            if (currentDepth == rightSideViewList.size()) {
                rightSideViewList.add(treeNode.val);
            }

            iterateRightViewOfTree(treeNode.right, rightSideViewList, currentDepth + 1);
            iterateRightViewOfTree(treeNode.left, rightSideViewList, currentDepth + 1);
        }
    }
}
