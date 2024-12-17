class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode treeNode)) return false;
        return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }
}

class Solution {
    public int numTrees(int n) {
        Map<TreeNode, Boolean> treeNodeMap = new HashMap<>();
        IntStream.rangeClosed(1, n)
                .forEach(
                        parent -> {
                            TreeNode treeNode = new TreeNode(parent);
                            Boolean[] visitedArr = new Boolean[n];
                            Arrays.fill(visitedArr, false);
                            visitedArr[parent - 1] = true;
                            createTreeForAllPermutations(parent, n, treeNodeMap, treeNode, visitedArr);
                            visitedArr[parent - 1] = false;
                        });

        return treeNodeMap.size();
    }

    private void createTreeForAllPermutations(int parentNode, int numberOfNodes, Map<TreeNode, Boolean> treeNodeMap,
            TreeNode currentTreeNode, Boolean[] visitedArr) {

        // Base Condition
        if (checkIfAllNodesAreVisited(visitedArr)) {
            TreeNode copiedTreeNode = copyTree(currentTreeNode);
            treeNodeMap.putIfAbsent(copiedTreeNode, true);
            return;
        }

        // Iterate all the nodes and decide at each stage with every option
        IntStream.rangeClosed(1, numberOfNodes)
                .filter(node -> node != parentNode && !visitedArr[node - 1])
                .forEach(
                        nextTreeNodeVal -> {
                            visitedArr[nextTreeNodeVal - 1] = true;
                            TreeNode updatedTreeNode = generateTree(currentTreeNode, nextTreeNodeVal);
                            createTreeForAllPermutations(parentNode, numberOfNodes, treeNodeMap, updatedTreeNode,
                                    visitedArr);
                            deleteLastInsertedNodeFromTree(updatedTreeNode, nextTreeNodeVal);
                            visitedArr[nextTreeNodeVal - 1] = false;
                        });
    }

    private TreeNode generateTree(TreeNode treeNode, int nextTreeNodeVal) {
        if (Objects.nonNull(treeNode)) {
            if (treeNode.val < nextTreeNodeVal) {
                treeNode.right = Objects.nonNull(treeNode.right) ? generateTree(treeNode.right, nextTreeNodeVal)
                        : new TreeNode(nextTreeNodeVal);
            } else if (treeNode.val > nextTreeNodeVal) {
                treeNode.left = Objects.nonNull(treeNode.left) ? generateTree(treeNode.left, nextTreeNodeVal)
                        : new TreeNode(nextTreeNodeVal);
            }
        }

        return treeNode;
    }

    private TreeNode deleteLastInsertedNodeFromTree(TreeNode treeNode, int nodeValToDelete) {
        if (Objects.nonNull(treeNode)) {
            if (treeNode.val == nodeValToDelete) {
                return null;
            }

            if (treeNode.val < nodeValToDelete) {
                treeNode.right = deleteLastInsertedNodeFromTree(treeNode.right, nodeValToDelete);
            } else if (treeNode.val > nodeValToDelete) {
                treeNode.left = deleteLastInsertedNodeFromTree(treeNode.left, nodeValToDelete);
            }
        }

        return treeNode;
    }

    private TreeNode copyTree(TreeNode treeNode) {
        if (Objects.nonNull(treeNode)) {
            TreeNode newTreeNode = new TreeNode(treeNode.val);
            newTreeNode.left = copyTree(treeNode.left);
            newTreeNode.right = copyTree(treeNode.right);

            return newTreeNode;
        }

        return null;
    }

    private Boolean checkIfAllNodesAreVisited(Boolean[] visitedArr) {
        return Arrays.stream(visitedArr)
                .allMatch(Boolean::booleanValue);
    }
}

// Accepted Solution
