/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    private HashMap<Integer, Node> graphNodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        return clone(node);
    }

    private Node clone(Node node) {
        if (Objects.isNull(node)) return null;

        if (graphNodeMap.containsKey(node.val)) {
            return graphNodeMap.get(node.val);
        }
        
        Node clonedNode = new Node(node.val);
        graphNodeMap.put(clonedNode.val, clonedNode);
        
        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(clone(neighbor));
        }
        
        return clonedNode;
    }
}
