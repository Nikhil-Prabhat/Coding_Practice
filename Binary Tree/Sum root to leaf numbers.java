
class Solution {

    List<Integer> leafNumberList = new ArrayList<>();
    
    public int sumNumbers(TreeNode root) {
        preOrderTraversal(root, "");
        return leafNumberList.stream().reduce(Integer::sum).get();
    }

    private void preOrderTraversal(TreeNode treeNode, String number) {
        if(Objects.nonNull(treeNode)) {
            if(Objects.isNull(treeNode.left) && Objects.isNull(treeNode.right)) {
                leafNumberList.add(Integer.parseInt(number + treeNode.val));
            }

            number += treeNode.val;

            preOrderTraversal(treeNode.left, number);
            preOrderTraversal(treeNode.right, number);
        }
    }
}
