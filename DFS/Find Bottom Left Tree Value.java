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

 class CustomTuple implements Comparable<CustomTuple> {
    Integer key;
    Integer value;

    public CustomTuple(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "CustomTuple{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    @Override
    public int compareTo(CustomTuple customTuple) {
        return customTuple.value - this.value;
    }
}

class Solution {
    List<CustomTuple> customTuplesList = new ArrayList<>();

    public int findBottomLeftValue(TreeNode root) {
        findTheLeftMostNode(root, 0);
        Collections.sort(customTuplesList);
        return customTuplesList.get(0).key;
    }

    private void findTheLeftMostNode(TreeNode treeNode, int depth) {
        if (Objects.nonNull(treeNode)) {

            if (Objects.isNull(treeNode.left) && Objects.isNull(treeNode.right)) {
                customTuplesList.add(new CustomTuple(treeNode.val, depth));
            }

            findTheLeftMostNode(treeNode.left, depth + 1);
            findTheLeftMostNode(treeNode.right, depth + 1);
        }
    }
}