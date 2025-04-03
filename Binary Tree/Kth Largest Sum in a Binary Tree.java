record TreeNodeWithDepth(int treeNodeVal, int depth) {
};

class Solution {

    List<TreeNodeWithDepth> treeNodeList = new ArrayList<>();

    public long kthLargestLevelSum(TreeNode root, int k) {
        inOrderTraversal(root, 0);

        Map<Integer, List<TreeNodeWithDepth>> mapByDepth = treeNodeList.stream()
                .collect(Collectors.groupingBy(nodeWithDepth -> nodeWithDepth.depth(),
                        Collectors.mapping(nodeWithDepth -> nodeWithDepth, Collectors.toList())));

        Map<Integer, Long> mapByDepthAndTreeValSum = mapByDepth.entrySet()
                .stream()
                .collect(
                        Collectors.toMap(map -> map.getKey(),
                                map -> map.getValue()
                                        .stream()
                                        .map(nodeWithDepth -> Long.valueOf(nodeWithDepth.treeNodeVal()))
                                        .reduce(0L, Long::sum))

                );

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        mapByDepthAndTreeValSum.entrySet()
                .stream()
                .forEach(
                        entrySet -> priorityQueue.add(entrySet.getValue())
                );

        if (mapByDepthAndTreeValSum.size() < k) {
            return -1;
        } else {
            while (--k > 0) {
                priorityQueue.poll();
            }

            return priorityQueue.poll();
        }
    }

    private void inOrderTraversal(TreeNode treeNode, int depth) {
        if (Objects.nonNull(treeNode)) {
            inOrderTraversal(treeNode.left, depth + 1);
            treeNodeList.add(new TreeNodeWithDepth(treeNode.val, depth));
            inOrderTraversal(treeNode.right, depth + 1);
        }
    }
}
