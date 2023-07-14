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

/*
    TreeNode root = null;
    
    public TreeNode createBinaryTree(int[][] descriptions) {
        Arrays.stream(descriptions).forEach(
                treeNodeArr -> {
                    if (Objects.isNull(root)) {
                        root = new TreeNode();
                        root.val = treeNodeArr[0];
                        if (treeNodeArr[2] == 1) {
                            TreeNode leftTreeNode = new TreeNode();
                            leftTreeNode.val = treeNodeArr[1];
                            root.left = leftTreeNode;
                        } else {
                            TreeNode rightTreeNode = new TreeNode();
                            rightTreeNode.val = treeNodeArr[1];
                            root.right = rightTreeNode;
                        }
                    } else {
                        // First Check for parent, if it is there in the tree
                        TreeNode toSearchParentNode = findNode(root, treeNodeArr[0]);
                        if (Objects.nonNull(toSearchParentNode)) {
                            if (treeNodeArr[2] == 1) {
                                TreeNode leftTreeNode = new TreeNode();
                                leftTreeNode.val = treeNodeArr[1];
                                toSearchParentNode.left = leftTreeNode;
                            } else {
                                TreeNode rightTreeNode = new TreeNode();
                                rightTreeNode.val = treeNodeArr[1];
                                toSearchParentNode.right = rightTreeNode;
                            }
                        } else {
                            // Check if the child exists there
                            TreeNode toSearchChildNode = findNode(root, treeNodeArr[1]);
                            TreeNode parentNode = new TreeNode();
                            parentNode.val = treeNodeArr[0];
                            if (treeNodeArr[2] == 1) {
                                parentNode.left = toSearchChildNode;
                            } else {
                                parentNode.right = toSearchChildNode;
                            }

                            root = parentNode;
                        }
                    }
                }
        );

        return root;

    }

    private TreeNode findNode(TreeNode treeNode, int val) {
        if (Objects.nonNull(treeNode)) {
            if (treeNode.val == val)
                return treeNode;
            TreeNode leftNode = findNode(treeNode.left, val);
            if (Objects.nonNull(leftNode) && leftNode.val == val)
                return leftNode;
            else {
                TreeNode rightNode = findNode(treeNode.right, val);
                if (Objects.nonNull(rightNode) && rightNode.val == val)
                    return rightNode;
            }
        }

        return null;
    }

    */

        public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> children = new HashSet<>();
        Map<Integer, TreeNode> mapOfTrees = new HashMap<>();

        for(int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            int left = description[2];

            mapOfTrees.putIfAbsent(parent, new TreeNode(parent));
            mapOfTrees.putIfAbsent(child, new TreeNode(child));
            children.add(child);

            if(left == 1)
                mapOfTrees.get(parent).left = mapOfTrees.get(child);
            else
                mapOfTrees.get(parent).right = mapOfTrees.get(child);

        }
        mapOfTrees.keySet().removeAll(children);
        return mapOfTrees.values().iterator().next();
    }
}