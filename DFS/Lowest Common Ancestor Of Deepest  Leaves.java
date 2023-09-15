/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    Map<Integer, Boolean> map = new HashMap<>();
    TreeNode commonAncestor = null;
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepthOfTree = findDepthOfTree(root);
        iterateTreeAndGetAllNodesAtTheDeepestDepth(root, 1, maxDepthOfTree);
        findCommonAncestor(root);
        return commonAncestor;
    }

    /* Finding the depth of the tree */
    private int findDepthOfTree(TreeNode root) {
        if (Objects.isNull(root))
            return 0;
        else
            return 1 + Math.max(findDepthOfTree(root.left), findDepthOfTree(root.right));
    }

    /* Go through the entire tree and find all the nodes at the deepest depth */
    private void iterateTreeAndGetAllNodesAtTheDeepestDepth(TreeNode root, int startingDepth, int maxDepth) {
        if (Objects.isNull(root))
            return;

        if (startingDepth == maxDepth)
            map.put(root.val, false);

        iterateTreeAndGetAllNodesAtTheDeepestDepth(root.left, startingDepth + 1, maxDepth);
        iterateTreeAndGetAllNodesAtTheDeepestDepth(root.right, startingDepth + 1, maxDepth);
    }

    /* Find common ancestor */
    private int findCommonAncestor(TreeNode treeNode) {
        if (Objects.isNull(treeNode))
            return 0;

        int result = 0;
        if (map.containsKey(treeNode.val))
            result += 1;

        result += (findCommonAncestor(treeNode.left) + findCommonAncestor(treeNode.right));

        if (result == map.size() && Objects.isNull(commonAncestor))
            commonAncestor = treeNode;

        return result;
    }
}