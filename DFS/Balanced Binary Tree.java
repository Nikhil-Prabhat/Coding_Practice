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
    boolean finalAnswer = true;
    
    public boolean isBalanced(TreeNode root) {
        if (Objects.nonNull(root)) {
            isBalanced(root.left);

            if (getBalancingFactor(root) > 1) {
                finalAnswer = false;
                return finalAnswer;
            }
            isBalanced(root.right);
        }

        return finalAnswer ? true : false;
    }

    private int getBalancingFactor(TreeNode treeNode) {
        return Math.abs(getHeightOfTree(treeNode.left) - getHeightOfTree(treeNode.right));
    }

    private int getHeightOfTree(TreeNode treeNode) {
        if (Objects.isNull(treeNode))
            return 0;

        int leftHeight = getHeightOfTree(treeNode.left);
        int rightHeight = getHeightOfTree(treeNode.right);

        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }
}