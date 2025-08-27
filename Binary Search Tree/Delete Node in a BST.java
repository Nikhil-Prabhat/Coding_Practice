class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (Objects.isNull(root)) {
            return root;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (Objects.isNull(root.left)) {
                return root.right;
            }

            if (Objects.isNull(root.right)) {
                return root.left;
            }

            TreeNode successorNode = getSuccessorNode(root);
            root.val = successorNode.val;
            root.right = deleteNode(root.right, successorNode.val);
        }

        return root;
    }

    private TreeNode getSuccessorNode(TreeNode treeNode) {
        treeNode = treeNode.right;

        while (Objects.nonNull(treeNode) && Objects.nonNull(treeNode.left)) {
            treeNode = treeNode.left;
        }

        return treeNode;
    }
}
