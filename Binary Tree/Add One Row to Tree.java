class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1 && Objects.isNull(root)) {
            return new TreeNode(val);
        }

        if (depth == 1) {
            TreeNode treeNode = new TreeNode(val);
            treeNode.left = root;
            return treeNode;
        }

        TreeNode rootOfTree = root;
        iterateTreeAndRow(root, val, depth, 1);
        return rootOfTree;
    }

    private void iterateTreeAndRow(TreeNode treeNode, int val, int expectedDepth, int actualDepth) {
        if (Objects.nonNull(treeNode)) {
            var depthOfChild = actualDepth + 1;

            if (depthOfChild == expectedDepth) {
                var tempLeftNode = treeNode.left;
                var tempRightNode = treeNode.right;

                treeNode.left = new TreeNode(val);
                treeNode.left.left = tempLeftNode;

                treeNode.right = new TreeNode(val);
                treeNode.right.right = tempRightNode;
                return;
            }

            iterateTreeAndRow(treeNode.left, val, expectedDepth, depthOfChild);
            iterateTreeAndRow(treeNode.right, val, expectedDepth, depthOfChild);
        }
    }
}

