class Solution {
    public boolean isValidSerialization(String preorder) {
        if (Objects.isNull(preorder)) {
            return false;
        }

        Stack<String> treeStack = new Stack<>();
        String[] treeNodes = preorder.split(",");

        for (String treeNode : treeNodes) {
            while (treeNode.equals("#") && !treeStack.isEmpty() && treeStack.peek().equals(treeNode)) {
                treeStack.pop();
                if (treeStack.isEmpty()) {
                    return false;
                }
                treeStack.pop();
            }

            treeStack.push(treeNode);
        }

        return treeStack.size() == 1 && treeStack.peek().equals("#");
    }
}
