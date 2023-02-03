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
    public TreeNode reverseOddLevels(TreeNode root) {
        setOrder(root.left,root.right, 1);
        return root;
    }

    private void setOrder(TreeNode leftTreeNode, TreeNode rightTreeNode, int level) {
        
        if (leftTreeNode != null && rightTreeNode != null) {
            if (level % 2 == 1) {
                int temp = leftTreeNode.val;
                leftTreeNode.val = rightTreeNode.val;
                rightTreeNode.val = temp;
            }

            setOrder(leftTreeNode.left, rightTreeNode.right, level+1);
            setOrder(leftTreeNode.right, rightTreeNode.left, level+1);
        }
    }
}