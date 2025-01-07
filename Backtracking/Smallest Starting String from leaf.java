class Solution {
    String smallestString = "";

    public String smallestFromLeaf(TreeNode root) {
        StringBuilder currentString = new StringBuilder("");
        iterateStringPermutations(root, currentString);

        return smallestString;
    }

    private void iterateStringPermutations(TreeNode treeNode, StringBuilder currentString) {
        if (Objects.nonNull(treeNode)) {
            currentString.insert(0, (char) (treeNode.val + 'a'));
            iterateStringPermutations(treeNode.left, currentString);

            if (Objects.isNull(treeNode.left) && Objects.isNull(treeNode.right)) {
                smallestString = computeAndUpdateStringsLexicographically(currentString);
            }

            iterateStringPermutations(treeNode.right, currentString);
            currentString.replace(0, 1, "");
        }
    }

    private String computeAndUpdateStringsLexicographically(StringBuilder currentString) {
        var toCompareString = currentString.toString();
        if (smallestString.isEmpty()) {
            return toCompareString;
        } else if (smallestString.compareTo(toCompareString) > 0) {
            return toCompareString;
        }

        return smallestString;
    }
}
