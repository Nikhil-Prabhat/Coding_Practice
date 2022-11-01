class NodeWithDepth {
    public int value;
    public int depth;

    public NodeWithDepth(int value, int depth) {
        this.value = value;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "NodeWithDepth{" +
                "value=" + value +
                ", depth=" + depth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NodeWithDepth)) return false;
        NodeWithDepth that = (NodeWithDepth) o;
        return value == that.value && depth == that.depth;
    }

    @Override
    public int hashCode() {
        return 31 * value + 31 * depth;
    }
}
class Solution {
    
PriorityQueue<NodeWithDepth> priorityQueue = new PriorityQueue<>(new Comparator<NodeWithDepth>() {
        @Override
        public int compare(NodeWithDepth nodeWithDepth1, NodeWithDepth nodeWithDepth2) {
            return nodeWithDepth2.depth - nodeWithDepth1.depth;
        }
    });
public int sumOfLeafNodes = 0;
    
public int deepestLeavesSum(TreeNode root) {
        inOrder(root, 0);
        NodeWithDepth nodeWithDepth = priorityQueue.poll();
        int maxDepth = nodeWithDepth.depth;
        sumOfLeafNodes += nodeWithDepth.value;
        priorityQueue.stream().forEach(
                nodeWithDepth1 -> {
                    if (nodeWithDepth1.depth == maxDepth)
                        sumOfLeafNodes += nodeWithDepth1.value;
                }
        );

        return sumOfLeafNodes;
    }

    private void inOrder(TreeNode root, int depth) {
        if (root != null) {
            inOrder(root.left, depth + 1);
            if (root.left == null && root.right == null)
                priorityQueue.add(new NodeWithDepth(root.val, depth));
            inOrder(root.right, depth + 1);
        }
    }
}