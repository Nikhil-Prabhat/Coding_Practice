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

    int countGoodNodes = 0;
    
    public int goodNodes(TreeNode root) {
        int maxValue = root.val;
        postOrder(root, maxValue);
        return countGoodNodes;
    }

    private void postOrder(TreeNode treeNode, int maxValue)
    {
        if(Objects.isNull(treeNode))
            return;

        if(treeNode.val >= maxValue)
            countGoodNodes++;

        // Find the maximum of the nodes visited till now
        int max = Math.max(treeNode.val, maxValue);
        maxValue = max;

        // Tree Iteration
        postOrder(treeNode.left, maxValue);
        postOrder(treeNode.right, maxValue);
    }
}