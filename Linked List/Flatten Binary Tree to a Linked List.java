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

    Queue<TreeNode> treeNodesQueue = new LinkedList<>();
    
    public void flatten(TreeNode root) {
        preOrderTraversal(root);
        TreeNode tempRoot = null;
        TreeNode ptr = null;

        while(!treeNodesQueue.isEmpty()) {

            if(Objects.isNull(tempRoot)) {
                tempRoot = treeNodesQueue.poll();
                tempRoot.left = null;
                ptr = tempRoot;
                continue;
            }

            ptr.right = treeNodesQueue.poll();
            ptr.left = null;
            ptr = ptr.right;
        }

        root = tempRoot;
    }

    private void preOrderTraversal(TreeNode treeNode) {
        if(Objects.nonNull(treeNode)) {
            treeNodesQueue.add(treeNode);
            preOrderTraversal(treeNode.left);
            preOrderTraversal(treeNode.right);
        }
    }
}