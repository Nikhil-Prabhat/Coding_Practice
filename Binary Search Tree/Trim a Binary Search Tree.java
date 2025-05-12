class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode trimmedTreeParent = new TreeNode(-1);
        preOrderTraversal(root, trimmedTreeParent, low, high);
        return trimmedTreeParent.val == -1 ? null : trimmedTreeParent;
    }

    private void preOrderTraversal(TreeNode treeNode, TreeNode trimmedTree, int lowerBound, int higherBound) {
        if (Objects.nonNull(treeNode)) {

            if (treeNode.val >= lowerBound && treeNode.val <= higherBound) {
                addElementInTheTrimmedTree(trimmedTree, treeNode.val);
            }

            preOrderTraversal(treeNode.left, trimmedTree, lowerBound, higherBound);
            preOrderTraversal(treeNode.right, trimmedTree, lowerBound, higherBound);
        }
    }

    private void addElementInTheTrimmedTree(TreeNode trimmedTreeNode, int element) {
        if (Objects.nonNull(trimmedTreeNode)) {

            // Base case
            if (trimmedTreeNode.val == -1) {
                trimmedTreeNode.val = element;
                return;
            }

            // Adding the element in the left subtree
            if (trimmedTreeNode.val > element) {
                if (Objects.nonNull(trimmedTreeNode.left))
                    addElementInTheTrimmedTree(trimmedTreeNode.left, element);
                else
                    trimmedTreeNode.left = new TreeNode(element);

            }

            // Adding the element in the right sub tree
            if (trimmedTreeNode.val < element) {
                if (Objects.nonNull(trimmedTreeNode.right))
                    addElementInTheTrimmedTree(trimmedTreeNode.right, element);
                else
                    trimmedTreeNode.right = new TreeNode(element);
            }
        }
    }
}
