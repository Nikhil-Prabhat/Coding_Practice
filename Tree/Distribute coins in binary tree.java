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

    int steps = 0;
    
    public int distributeCoins(TreeNode root) {
        findSteps(root);
        return steps;
    }

    // Steps is based on path counters to achieve required nodes
    private int findSteps(TreeNode treeNode) {
        if (Objects.isNull(treeNode))
            return 0;
        else {
            int leftExcessNodes = findSteps(treeNode.left);
            int rightExcessNodes = findSteps(treeNode.right);
            steps += (Math.abs(leftExcessNodes) + Math.abs(rightExcessNodes));
            
            // Always consider root values as well 
            // It returns the counter of saturation of a node
            return (leftExcessNodes + rightExcessNodes + treeNode.val - 1);
        }
    }
}