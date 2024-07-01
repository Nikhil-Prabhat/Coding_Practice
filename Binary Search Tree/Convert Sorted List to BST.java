/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = null;
        ListNode ptr = head;
        while (Objects.nonNull(ptr)) {
            root = insertTreeNode(root, ptr.val);
            ptr = ptr.next;
        }

        return root;
    }

    /* Utility to find height of the tree*/
    private int findHeightOfTree(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return 0;
        } else {
            int heightOfLeftTree = findHeightOfTree(treeNode.left);
            int heightOfRightTree = findHeightOfTree(treeNode.right);

            return heightOfLeftTree > heightOfRightTree ? heightOfLeftTree + 1 : heightOfRightTree + 1;
        }
    }

    /* Utility to find balancing factor */
    private int getBalancingFactor(TreeNode treeNode) {
        if (Objects.isNull(treeNode)) {
            return 0;
        } else {
            return findHeightOfTree(treeNode.left) - findHeightOfTree(treeNode.right);
        }
    }

    /* Rotations */
    private TreeNode rightRotate(TreeNode treeNodeToRotate) {
        TreeNode tempNode = treeNodeToRotate.left;
        TreeNode rightOfTempNode = tempNode.right;

        // Perform rotation
        tempNode.right = treeNodeToRotate;
        treeNodeToRotate.left = rightOfTempNode;

        // Return new root
        return tempNode;
    }

    private TreeNode leftRotate(TreeNode treeNodeToRotate) {
        TreeNode tempNode = treeNodeToRotate.right;
        TreeNode leftOfTempNode = tempNode.left;

        // Perform rotation
        tempNode.left = treeNodeToRotate;
        treeNodeToRotate.right = leftOfTempNode;

        // Return new root
        return tempNode;
    }

    /* Utility function to insert treeNode in AVL Tree */
    private TreeNode insertTreeNode(TreeNode treeNode, int key) {
        if (Objects.isNull(treeNode)) {
            return new TreeNode(key);
        }

        if (key < treeNode.val) {
            treeNode.left = insertTreeNode(treeNode.left, key);
        } else if (key > treeNode.val) {
            treeNode.right = insertTreeNode(treeNode.right, key);
        } else
            return treeNode;

        // Check balancing factor to make sure if the tree is balanced
        int balancingFactor = getBalancingFactor(treeNode);

        // Perform rotations

        // LL Case   -> Single R Rotation
        if (balancingFactor > 1 && key < treeNode.left.val)
            return rightRotate(treeNode);

        // RR Case    -> Single L Rotation
        if (balancingFactor < -1 && key > treeNode.right.val)
            return leftRotate(treeNode);

        // LR Case     -> LR Rotation
        if (balancingFactor > 1 && key > treeNode.left.val) {
            treeNode.left = leftRotate(treeNode.left);
            return rightRotate(treeNode);
        }

        // RL Case    -> RL Rotation
        if (balancingFactor < -1 && key < treeNode.right.val) {
            treeNode.right = rightRotate(treeNode.right);
            return leftRotate(treeNode);
        }

        return treeNode;
    }
}