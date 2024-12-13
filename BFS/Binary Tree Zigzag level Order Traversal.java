/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    record NodeWithHeight(int nodeVal, int height) {
    };

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> treeNodesList = new ArrayList<>();
        Deque<NodeWithHeight> deque = new LinkedList<>();

        inorderTraversal(root, 0, deque);
        var heightOfTree = deque.stream()
                .map(NodeWithHeight::height)
                .reduce(-1, Integer::max);

        if (heightOfTree > -1) {
            IntStream.rangeClosed(0, heightOfTree)
                    .forEach(
                            num -> treeNodesList.add(new ArrayList<>()));

            while (!deque.isEmpty()) {
                NodeWithHeight currentNode = deque.pollFirst();
                treeNodesList.get(currentNode.height()).add(currentNode.nodeVal());
            }

            for (int i = 0; i < treeNodesList.size(); i++) {
                if (i % 2 != 0) {
                    Collections.reverse(treeNodesList.get(i));
                }
            }
        }

        return treeNodesList;
    }

    private void inorderTraversal(TreeNode treeNode, int heightOfCurrentNode, Deque<NodeWithHeight> deque) {
        if (Objects.nonNull(treeNode)) {
            inorderTraversal(treeNode.left, heightOfCurrentNode + 1, deque);
            deque.add(new NodeWithHeight(treeNode.val, heightOfCurrentNode));
            inorderTraversal(treeNode.right, heightOfCurrentNode + 1, deque);
        }
    }
}
