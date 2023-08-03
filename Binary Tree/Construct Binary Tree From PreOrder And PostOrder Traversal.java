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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {

        List<Integer> preOrderList = convertToList(preorder);
        List<Integer> postOrderList = convertToList(postorder);
        TreeNode treeNode = new TreeNode(-1);
        constructTree(preOrderList, postOrderList, treeNode, null, preorder[0], true);
        return treeNode;
    }

    private void constructTree(List<Integer> preOrderList, List<Integer> postOrderList, TreeNode treeNode, TreeNode currentNode, int rootValue, boolean isLeftChild) {

        // Base condition
        if (treeNode.val == -1) {
            treeNode.val = rootValue;
        } else {
            if (isLeftChild) {
                if (Objects.isNull(currentNode)) {
                    treeNode.left = new TreeNode(rootValue);
                    currentNode = treeNode.left;
                } else {
                    currentNode.left = new TreeNode(rootValue);
                    currentNode = currentNode.left;
                }
            } else {
                if (Objects.isNull(currentNode)) {
                    treeNode.right = new TreeNode(rootValue);
                    currentNode = treeNode.right;
                } else {
                    currentNode.right = new TreeNode(rootValue);
                    currentNode = currentNode.right;
                }
            }
        }

        if (preOrderList.size() <= 1 && postOrderList.size() <= 1)
            return;

        int leftChild = preOrderList.get(1);
        int rightChild = postOrderList.get(postOrderList.size() - 2);

        if (leftChild == rightChild) {
            if (Objects.isNull(currentNode)) {
                treeNode.left = new TreeNode(leftChild);
                currentNode = treeNode.left;
            } else {
                currentNode.left = new TreeNode(leftChild);
                currentNode = currentNode.left;
            }
            return;
        }

        // In PostOrder List
        int indexOfLeftChild = postOrderList.indexOf(leftChild);

        // In PreOrder List
        int indexOfRightChild = preOrderList.indexOf(rightChild);

        // Left And Right Tree Creation
        constructTree(preOrderList.subList(1, indexOfRightChild), postOrderList.subList(0, indexOfLeftChild + 1), treeNode, currentNode, leftChild, true);
        constructTree(preOrderList.subList(indexOfRightChild, preOrderList.size()), postOrderList.subList(indexOfLeftChild + 1, postOrderList.size() - 1), treeNode, currentNode, rightChild, false);
    }

    private List<Integer> convertToList(int[] array) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }
}

/* Final Solution */

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
 
 // References : https://www.youtube.com/watch?v=xe6cLIhberQ
class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return constructFromPrePost(preorder, 0, n - 1, postorder, 0, n - 1);
    }

    private TreeNode constructFromPrePost(int[] preorder, int preStartIndex, int preEndIndex, int[] postorder, int postStartIndex, int postEndIndex) {
        if (preStartIndex > preEndIndex)
            return null;

        TreeNode root = new TreeNode(preorder[preStartIndex]);
        if (preStartIndex == preEndIndex)
            return root;

        int index = postStartIndex;
        while (postorder[index] != preorder[preStartIndex + 1])
            index++;

        int numberOfElements = (index - postStartIndex + 1);
        root.left = constructFromPrePost(preorder, preStartIndex + 1, preStartIndex + numberOfElements, postorder, postStartIndex, index);
        root.right = constructFromPrePost(preorder, preStartIndex + numberOfElements + 1, preEndIndex, postorder, index + 1, postEndIndex - 1);
        return root;

    }
}