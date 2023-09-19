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

    int count = 0;

   public int countNodes(TreeNode root) {
        inOrder(root);
        return count;
    }

    private void inOrder(TreeNode treeNode) {
        if (Objects.nonNull(treeNode)) {
            inOrder(treeNode.left);
            count++;
            inOrder(treeNode.right);
        }
    }
}