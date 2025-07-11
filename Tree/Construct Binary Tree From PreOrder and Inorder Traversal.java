class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] preIndex = new int[] { 0 };
        return buildTreeRecursively(preorder, inorder, preIndex, 0, inorder.length-1);
    }

    private TreeNode buildTreeRecursively(int[] preOrder, int[] inOrder, int[] preIndex, int left, int right) {
        if (left > right)
            return null;

        int rootVal = preOrder[preIndex[0]];
        preIndex[0]++;

        TreeNode treeNode = new TreeNode(rootVal);
        int rootIndexInInOrderArr = findRootIndexInInOrderArr(inOrder, rootVal, left, right);

        treeNode.left = buildTreeRecursively(preOrder, inOrder, preIndex, left, rootIndexInInOrderArr - 1);
        treeNode.right = buildTreeRecursively(preOrder, inOrder, preIndex, rootIndexInInOrderArr + 1, right);

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
