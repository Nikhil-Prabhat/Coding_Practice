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

/* Tried Solution */
record NodeWithDepth(Node node, int depth) {
};

record NodeValWithDepth(int nodeVal, int depth){};

class Solution {

    List<NodeWithDepth> nodeList = new ArrayList<>();
    Map<NodeValWithDepth, Node> nodeMap = new HashMap<>();

    public Node connect(Node root) {
        if (Objects.nonNull(root)) {
            inOrderTraversal(root, 0);
            updateNodesMap(nodeList, nodeMap);
            inOrderTraversalWithNextNodeUpdate(root, 0);
        }

        return root;
    }

    private void inOrderTraversal(Node node, int depth) {
        if (Objects.nonNull(node)) {
            inOrderTraversal(node.left, depth + 1);
            nodeList.add(new NodeWithDepth(node, depth));
            inOrderTraversal(node.right, depth + 1);
        }
    }

    private void inOrderTraversalWithNextNodeUpdate(Node node, int depth) {
        if (Objects.nonNull(node)) {
            inOrderTraversalWithNextNodeUpdate(node.left, depth+1);
            node.next = nodeMap.get(new NodeValWithDepth(node.val, depth));
            inOrderTraversalWithNextNodeUpdate(node.right, depth+1);
        }
    }

    private void updateNodesMap(List<NodeWithDepth> nodeList, Map<NodeValWithDepth, Node> nodeMap) {
        Collections.sort(nodeList, Comparator.comparing(NodeWithDepth::depth));

        for (int i = 0; i < nodeList.size() - 1; i++) {
            NodeWithDepth currentNode = nodeList.get(i);
            NodeWithDepth nextNode = nodeList.get(i + 1);

            if (currentNode.depth() == nextNode.depth()) {
                nodeMap.put(new NodeValWithDepth(currentNode.node().val, currentNode.depth()), nextNode.node());
            } else {
                nodeMap.put(new NodeValWithDepth(currentNode.node().val, currentNode.depth()), null);
            }
        }

        NodeWithDepth lastNodeWithDepth = nodeList.get(nodeList.size() - 1);
        nodeMap.put(new NodeValWithDepth(lastNodeWithDepth.node().val, lastNodeWithDepth.depth()), null);
    }
}

/* Final Solution */
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;

        root.left.next = root.right;
        if(root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }
}
