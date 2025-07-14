class Solution {
    Map<Integer, List<Integer>> nodesMap = new TreeMap<>(Comparator.reverseOrder());

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> nodesList = new ArrayList<>();
        inOrderTraversal(root, 0);

        nodesMap.values()
                .stream()
                .forEach(values -> nodesList.add(values));

        return nodesList;
    }

    private void inOrderTraversal(TreeNode treeNode, int depth) {
        if (Objects.nonNull(treeNode)) {
            inOrderTraversal(treeNode.left, depth + 1);

            List<Integer> nodesAtDepth = nodesMap.getOrDefault(depth, new ArrayList<>());
            nodesAtDepth.add(treeNode.val);
            nodesMap.put(depth, nodesAtDepth);

            inOrderTraversal(treeNode.right, depth + 1);
        }
    }
}
