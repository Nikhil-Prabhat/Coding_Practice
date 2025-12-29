/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (Objects.isNull(root)) {
            return root;
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            int currentNodeLevel = nodeQueue.size();

            while (currentNodeLevel-- > 0) {
                Node currentNode = nodeQueue.poll();
                if (currentNodeLevel != 0) {
                    currentNode.next = nodeQueue.peek();
                }

                if (Objects.nonNull(currentNode.left)) {
                    nodeQueue.add(currentNode.left);
                }

                if (Objects.nonNull(currentNode.right)) {
                    nodeQueue.add(currentNode.right);
                }
            }
        }

        return root;
    }
}
