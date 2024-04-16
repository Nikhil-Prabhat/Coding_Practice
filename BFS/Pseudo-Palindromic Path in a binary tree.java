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

     int palindromeCount = 0;
     
    public int pseudoPalindromicPaths(TreeNode root) {
        List<Integer> intermediateList = new ArrayList<>();
        intermediateList.add(root.val);
        iterateTree(root, intermediateList);
        return palindromeCount;
    }

    private void iterateTree(TreeNode treeNode, List<Integer> intermediateList) {
        if (Objects.nonNull(treeNode)) {

            // Base Case
            if (Objects.isNull(treeNode.left) && Objects.isNull(treeNode.right)) {
                palindromeCount = checkIfTheListCanBeArrangedToPalindrome(intermediateList) ? palindromeCount + 1 : palindromeCount;
                return;
            }

            // Iterate left and right trees
            if (Objects.nonNull(treeNode.left)) {
                intermediateList.add(treeNode.left.val);
                iterateTree(treeNode.left, intermediateList);

                // Delete left tree value
                intermediateList.remove(intermediateList.size() - 1);
            }


            if (Objects.nonNull(treeNode.right)) {
                intermediateList.add(treeNode.right.val);
                iterateTree(treeNode.right, intermediateList);

                // Delete right tree value
                intermediateList.remove(intermediateList.size() - 1);
            }
        }
    }

    private boolean checkIfTheListCanBeArrangedToPalindrome(List<Integer> numberList) {
        Map<Integer, Integer> palindromeMap = new HashMap<>();

        numberList.stream().forEach(
                number -> palindromeMap.put(number, palindromeMap.getOrDefault(number, 0) + 1)
        );

        Integer oddCount = palindromeMap.entrySet().stream()
                .map(map -> map.getValue())
                .reduce(0, (aggregate, nextElement) -> aggregate + (nextElement % 2 == 1 ? 1 : 0));

        return oddCount > 1 ? false : true;
    }
}