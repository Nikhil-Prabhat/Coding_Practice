class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] postIndex = new int[] { inorder.length - 1 };
        return buildTreeRecursively(postorder, inorder, postIndex, 0, inorder.length - 1);
    }

    private TreeNode buildTreeRecursively(int[] postOrder, int[] inOrder, int[] postIndex, int left, int right) {
        if (left > right)
            return null;

        int rootVal = postOrder[postIndex[0]];
        postIndex[0]--;

        TreeNode treeNode = new TreeNode(rootVal);
        int rootIndexInInOrderArr = findRootIndexInInOrderArr(inOrder, rootVal, left, right);

        treeNode.right = buildTreeRecursively(postOrder, inOrder, postIndex, rootIndexInInOrderArr + 1, right);
        treeNode.left = buildTreeRecursively(postOrder, inOrder, postIndex, left, rootIndexInInOrderArr - 1);

        return treeNode;
    }

    private int findRootIndexInInOrderArr(int[] inOrder, int value, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (inOrder[i] == value)
                return i;
        }

        return -1;
    }
}
