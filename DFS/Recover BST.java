record NodeWithDirection(Integer nodeVal, String direction) {
}

class Solution {
    HashMap<Integer, NodeWithDirection> nodeMap = new HashMap<>();

    public void recoverTree(TreeNode root) {
        initNodeMap(root);

        List<Integer> rectificationNodes = iterateAndFindRectificationNodes(root);
        rectifyTree(root, rectificationNodes);
        System.out.println(root);
    }

    private void initNodeMap(TreeNode root) {
        nodeMap.put(root.val, new NodeWithDirection(-1, "X"));
        traverseNodesAndGenerateNodeMap(root);
    }

    private void traverseNodesAndGenerateNodeMap(TreeNode treeNode) {
        if (Objects.nonNull(treeNode)) {
            if (Objects.nonNull(treeNode.left)) {
                nodeMap.put(treeNode.left.val, new NodeWithDirection(treeNode.val, "L"));
            }

            if (Objects.nonNull(treeNode.right)) {
                nodeMap.put(treeNode.right.val, new NodeWithDirection(treeNode.val, "R"));
            }

            traverseNodesAndGenerateNodeMap(treeNode.left);
            traverseNodesAndGenerateNodeMap(treeNode.right);
        }
    }

    private List<Integer> iterateAndFindRectificationNodes(TreeNode treeNode) {
        List<Integer> rectificationNodes = List.of();
        if (Objects.nonNull(treeNode)) {
            rectificationNodes = findRectificationNodes(treeNode.val);
            if (!rectificationNodes.isEmpty())
                return rectificationNodes;

            if (rectificationNodes.isEmpty())
                rectificationNodes = iterateAndFindRectificationNodes(treeNode.left);
            else
                return rectificationNodes;

            if (rectificationNodes.isEmpty())
                rectificationNodes = iterateAndFindRectificationNodes(treeNode.right);
            else
                return rectificationNodes;
        }

        return rectificationNodes;
    }

    private List<Integer> findRectificationNodes(Integer nodeVal) {
        NodeWithDirection nodeWithDirection = nodeMap.get(nodeVal);
        while (nodeWithDirection.nodeVal() != -1) {
            var nodeRootVal = nodeWithDirection.nodeVal();
            var nodeRootDir = nodeWithDirection.direction();

            if (nodeRootDir.equals("L") && nodeRootVal < nodeVal)
                return List.of(nodeRootVal, nodeVal);
            else if (nodeRootDir.equals("R") && nodeRootVal > nodeVal)
                return List.of(nodeRootVal, nodeVal);

            nodeWithDirection = nodeMap.get(nodeRootVal);
        }

        return List.of();
    }

    private void rectifyTree(TreeNode treeNode, List<Integer> nodeList) {
        if (Objects.nonNull(treeNode)) {
            if (treeNode.val == nodeList.get(0)) {
                treeNode.val = nodeList.get(1);
            } else if (treeNode.val == nodeList.get(1)) {
                treeNode.val = nodeList.get(0);
            }

            rectifyTree(treeNode.left, nodeList);
            rectifyTree(treeNode.right, nodeList);
        }
    }
}
