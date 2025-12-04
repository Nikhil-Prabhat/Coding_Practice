class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> output = new ArrayList<>();
        dfs(root, targetSum, 0, output, new ArrayList<>());
        return output;
    }

    private void dfs(TreeNode root, int targetSum, int curSum,
                     List<List<Integer>> output, List<Integer> currentPath) {
        if (root == null) return;

        // Add current node's value to sum and path
        curSum += root.val;
        currentPath.add(root.val);

        // If it's a leaf and path sum equals target, add path to result
        if (root.left == null && root.right == null && curSum == targetSum) {
            output.add(new ArrayList<>(currentPath));
        }

        // Recur for children
        dfs(root.left, targetSum, curSum, output, currentPath);
        dfs(root.right, targetSum, curSum, output, currentPath);

        // Backtrack: remove current node
        currentPath.remove(currentPath.size() - 1);
    }
}

// Tried Solution

class Solution {
    
    List<List<Integer>> rootToLeafNodeList = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        inOrderTreeTraversal(root, 0, targetSum, new ArrayList<>());
        return rootToLeafNodeList;
    }

    private void inOrderTreeTraversal(TreeNode treeNode, int sumOfNodesSoFar, int targetSum, List<Integer> intermediateResult) {
        if (Objects.nonNull(treeNode)) {
            intermediateResult.add(treeNode.val);
            sumOfNodesSoFar += treeNode.val;

            if (sumOfNodesSoFar == targetSum) {
                if (Objects.isNull(treeNode.left) && Objects.isNull(treeNode.right)) {
                    List<Integer> rootToLeafList = new ArrayList<>();
                    intermediateResult.forEach(rootToLeafList::add);

                    rootToLeafNodeList.add(rootToLeafList);
                    intermediateResult.remove(intermediateResult.size() - 1);
                }

                return;
            }

            if (sumOfNodesSoFar > targetSum) {
                intermediateResult.remove(intermediateResult.size() - 1);
                return;
            }

            if (sumOfNodesSoFar < targetSum) {
                inOrderTreeTraversal(treeNode.left, sumOfNodesSoFar, targetSum, intermediateResult);
                inOrderTreeTraversal(treeNode.right, sumOfNodesSoFar, targetSum, intermediateResult);
                intermediateResult.remove(intermediateResult.size() - 1);
            }
        }
    }
}
