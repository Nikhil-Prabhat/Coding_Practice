class NodeWithDepth {
    public TreeNode treeNode;
    public int depth;

    public NodeWithDepth(TreeNode treeNode, int depth) {
        this.treeNode = treeNode;
        this.depth = depth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NodeWithDepth)) return false;
        NodeWithDepth that = (NodeWithDepth) o;
        return depth == that.depth && Objects.equals(treeNode, that.treeNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(treeNode, depth);
    }

    @Override
    public String toString() {
        return "NodeWithDepth{" +
                "treeNode=" + treeNode +
                ", depth=" + depth +
                '}';
    }
}

class Solution {

    Queue<NodeWithDepth> nodeQueue = new LinkedList<>();
    List<List<Integer>> resultList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(Objects.isNull(root)) {
            return new ArrayList<>();
        }
        nodeQueue.add(new NodeWithDepth(root, 0));
        iterateLevelOrder();
        return resultList;
    }

    private void iterateLevelOrder() {
        List<Integer> currentLevelList = null;

        while (!nodeQueue.isEmpty()) {
            NodeWithDepth topNode = nodeQueue.poll();
            int currentNodeDepth = topNode.depth;

            try {
                currentLevelList = resultList.get(currentNodeDepth);
            } catch (Exception ex) {
                currentLevelList = new ArrayList<>();
                resultList.add(currentLevelList);
            } finally {
                List<Integer> updatedList = updateList(currentLevelList, topNode.treeNode, currentNodeDepth);
                resultList.set(currentNodeDepth, updatedList);
            }
        }
    }

    private List<Integer> updateList(List<Integer> currentList, TreeNode treeNode, int depth) {
        currentList.add(treeNode.val);

        if(Objects.nonNull(treeNode.left)) {
            nodeQueue.add(new NodeWithDepth(treeNode.left, depth + 1));
        }

        if(Objects.nonNull(treeNode.right)) {
            nodeQueue.add(new NodeWithDepth(treeNode.right, depth + 1));
        }

        return currentList;
    }
}