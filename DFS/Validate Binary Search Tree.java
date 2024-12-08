class Solution {
    public boolean isValidBST(TreeNode root) {
        if (Objects.nonNull(root)) {
            isValidBST(root.left);
            isValidBST(root.right);
            return validateBST(root, root.val);
        }

        return false;
    }

    private boolean validateBST(TreeNode treeNode, int rootVal) {
        Boolean isLeftValid = true;
        Boolean isRightValid = true;

        if (Objects.nonNull(treeNode)) {
            if (Objects.nonNull(treeNode.left)) {
                isLeftValid = (rootVal >= treeNode.val) && (treeNode.val > treeNode.left.val);
            }

            if (Objects.nonNull(treeNode.right)) {
                isRightValid = (rootVal <= treeNode.val) && (treeNode.val < treeNode.right.val);
            }

            return isLeftValid && isRightValid;
        }

        return true;
    }
}

// Accepted Solution
public boolean isValidBST(TreeNode root) {

        if (Objects.isNull(root)) {
            return true;
        }

        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode previousNodeToCompare = null;
        TreeNode currentNodeToCompare = root;

        while (Objects.nonNull(currentNodeToCompare) || !treeNodeStack.isEmpty()) {
            while (Objects.nonNull(currentNodeToCompare)) {
                treeNodeStack.push(currentNodeToCompare);
                currentNodeToCompare = currentNodeToCompare.left;
            }

            currentNodeToCompare = treeNodeStack.pop();

            // If the current Node is ever smaller than the previous node, then it is not a valid BST
            // At anytime , the previousNode to compare will have values either from root or left sub tree
            if (Objects.nonNull(previousNodeToCompare) && currentNodeToCompare.val <= previousNodeToCompare.val) {
                return false;
            }

            previousNodeToCompare = currentNodeToCompare;
            currentNodeToCompare = currentNodeToCompare.right;
        }

        return true;
    }
	
	
class Solution {

    List<Integer> treeList = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        inorderTraversal(root);

        for (int i = 1; i < treeList.size(); i++) {
            if (treeList.get(i - 1) >= treeList.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void inorderTraversal(TreeNode treeNode) {
        if (Objects.nonNull(treeNode)) {
            inorderTraversal(treeNode.left);
            treeList.add(treeNode.val);
            inorderTraversal(treeNode.right);
        }
    }
}

