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
    TreeNode ROOT = null;
    
    public TreeNode sortedArrayToBST(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            ROOT = insertNode(ROOT, nums[i]);
        }

        return ROOT;
    }

    private int findHeightOfATree(TreeNode treeNode) {
        if (Objects.isNull(treeNode))
            return 0;

        int leftHeight = findHeightOfATree(treeNode.left);
        int rightHeight = findHeightOfATree(treeNode.right);

        return findMax(leftHeight, rightHeight) + 1;
    }

    private int findMax(int firstNumber, int secondNumber) {
        return firstNumber > secondNumber ? firstNumber : secondNumber;
    }

    private int getBalancingFactor(TreeNode treeNode) {
        if (Objects.isNull(treeNode))
            return 0;

        return findHeightOfATree(treeNode.left) - findHeightOfATree(treeNode.right);
    }

    private TreeNode leftRotate(TreeNode treeNode) {
        TreeNode y = treeNode.right;
        TreeNode z = y.left;

        // Perform rotation
        y.left = treeNode;
        treeNode.right = z;

        return y;
    }

    private TreeNode insertNode(TreeNode treeNode, int key) {
        if (Objects.isNull(treeNode))
            return new TreeNode(key);

        if (key < treeNode.val)
            treeNode.left = insertNode(treeNode.left, key);
        if (key > treeNode.val)
            treeNode.right = insertNode(treeNode.right, key);
        else
            return treeNode;

        // Find the balancing factor
        int balancingFactor = getBalancingFactor(treeNode);

        if (balancingFactor < -1 && key > treeNode.right.val)
            return leftRotate(treeNode);

        return treeNode;
    }
}