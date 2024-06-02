class Solution {
    List<Integer> valuesList = new ArrayList<>();

   public TreeNode balanceBST(TreeNode root) {
        iterateTree(root);
        TreeNode newRoot = null;
        for (int i = 0; i < valuesList.size(); i++) {
          newRoot = createBalancedBinarySearchTree(newRoot, valuesList.get(i));
        }
        return newRoot;
    }

    private void iterateTree(TreeNode treeNode) {
        if (Objects.nonNull(treeNode)) {
            iterateTree(treeNode.left);
            valuesList.add(treeNode.val);
            iterateTree(treeNode.right);
        }
    }

    private TreeNode createBalancedBinarySearchTree(TreeNode treeNode, int key) {

        if (Objects.isNull(treeNode))
            return new TreeNode(key);
        else if (key < treeNode.val) {
            treeNode.left = createBalancedBinarySearchTree(treeNode.left, key);
        } else if (key > treeNode.val) {
            treeNode.right = createBalancedBinarySearchTree(treeNode.right, key);
        } else {
            return treeNode;
        }

        // Find balancing factor and apply rotations
        int balancingFactor = getBalancingFactor(treeNode);

        // LL Case : Single R Rotation
        if (balancingFactor > 1 && (key < treeNode.left.val)) {
            return rightRotate(treeNode);
        }

        // RR Case : Single L Rotation
        if (balancingFactor < -1 && (key > treeNode.right.val)) {
            return leftRotate(treeNode);
        }

        // LR Case : LR Rotation
        if (balancingFactor > 1 && (key > treeNode.left.val)) {
            treeNode.left = leftRotate(treeNode.left);
            return rightRotate(treeNode);
        }

        // RL Case : RL Rotation
        if (balancingFactor < -1 && (key < treeNode.right.val)) {
            treeNode.right = rightRotate(treeNode.right);
            return leftRotate(treeNode);
        }

        return treeNode;
    }

    private int getHeightOfTheTree(TreeNode treeNode) {
        if (Objects.isNull(treeNode))
            return 0;

        int leftHeightOfTree = getHeightOfTheTree(treeNode.left);
        int rightHeightOfTree = getHeightOfTheTree(treeNode.right);

        return leftHeightOfTree > rightHeightOfTree ? leftHeightOfTree + 1 : rightHeightOfTree + 1;
    }

    private int findMax(int a, int b) {
        return a > b ? a : b;
    }

    private int getBalancingFactor(TreeNode treeNode) {
        if (Objects.isNull(treeNode))
            return 0;
        return getHeightOfTheTree(treeNode.left) - getHeightOfTheTree(treeNode.right);
    }

    private TreeNode rightRotate(TreeNode treeNode) {
        TreeNode newRoot = treeNode.left;
        TreeNode oldRightChild = newRoot.right;

        // Perform rotation
        newRoot.right = treeNode;
        treeNode.left = oldRightChild;

        return newRoot;
    }

    private TreeNode leftRotate(TreeNode treeNode) {
        TreeNode newRoot = treeNode.right;
        TreeNode oldLeftChild = newRoot.left;

        // Perform rotation
        newRoot.left = treeNode;
        treeNode.right = oldLeftChild;

        // Return new root
        return newRoot;
    }
}