/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class NodeWithDepth {
    public int value;
    public int depth;
    public List<Node> children;

    public NodeWithDepth(int value, int depth,  List<Node> children) {
        this.value = value;
        this.depth = depth;
        this.children = children;
    }

    @Override
    public String toString() {
        return "NodeWithDepth{" +
                "value=" + value +
                ", depth=" + depth +
                ", children=" + children +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NodeWithDepth)) return false;
        NodeWithDepth that = (NodeWithDepth) o;
        return value == that.value && depth == that.depth && Objects.equals(children, that.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, depth, children);
    }
}

class Solution {

    public Queue<NodeWithDepth> queue = new LinkedList<>();

   public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(Objects.isNull(root))
            return result;
        
        NodeWithDepth rootWithDepth = new NodeWithDepth(root.val,0 , root.children);
        queue.add(rootWithDepth);
        levelOrderTraversal(result, 0);
        return result;
    }

    private void levelOrderTraversal(List<List<Integer>> result, int depth) {
        List<Integer> intermediateList = new ArrayList<>();

        // Iterate the queue and add only those values which are having same depth
        while(!queue.isEmpty() && queue.peek().depth == depth) {
            NodeWithDepth topNodeWithDepth = queue.poll();
            intermediateList.add(topNodeWithDepth.value);
            getChildNodeAndAddInTheQueue(topNodeWithDepth, depth+1);
        }

        result.add(intermediateList);

        if(queue.isEmpty())
            return;
        levelOrderTraversal(result, depth+1);

    }

    private void getChildNodeAndAddInTheQueue(NodeWithDepth node, int depth) {

        for(int i=0;i<node.children.size();i++) {
            Node child = node.children.get(i);
            queue.add(new NodeWithDepth(child.val, depth, child.children));
        }
    }
}