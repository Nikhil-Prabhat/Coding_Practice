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

    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> inOrderList = new ArrayList<>();
    
    public TreeNode convertBST(TreeNode root) {
        // Traverse the tree and create an inorder traversal
        inOrderTraversal(root);

        // Create the reverse cumulative list
        int sumOfSubsequentNumber = 0;

        // Create the map
        for (int i = inOrderList.size() - 1; i > -1; i--) {
            int currentElement = inOrderList.get(i);
            sumOfSubsequentNumber += currentElement;
            map.put(currentElement, sumOfSubsequentNumber);
        }

        inOrderUpdate(root);

        return root;
    }

    private void inOrderTraversal(TreeNode root) {
        if (Objects.nonNull(root)) {
            inOrderTraversal(root.left);
            inOrderList.add(root.val);
            inOrderTraversal(root.right);
        }
    }

    private void inOrderUpdate(TreeNode root) {
        if (Objects.nonNull(root)) {
            inOrderUpdate(root.left);
            root.val = map.get(root.val);
            inOrderUpdate(root.right);
        }
    }
}