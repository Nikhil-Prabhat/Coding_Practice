class Solution {

    List<TreeNode> treeNodeList = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        for (int element : to_delete) {
            inOrderTraversalSearch(root, element);
        }
        treeNodeList.add(root);
        return treeNodeList;
    }

    private void inOrderTraversalSearch(TreeNode treeNode, int elementToBeDeleted) {
        if (Objects.nonNull(treeNode)) {
            if (Objects.nonNull(treeNode.left) && treeNode.left.val == elementToBeDeleted) {

                if (Objects.nonNull(treeNode.left.left))
                    treeNodeList.add(treeNode.left.left);
                if (Objects.nonNull(treeNode.left.right))
                    treeNodeList.add(treeNode.left.right);

                treeNode.left = null;
                return;
            }

            if (Objects.nonNull(treeNode.right) && treeNode.right.val == elementToBeDeleted) {
                if (Objects.nonNull(treeNode.right.left))
                    treeNodeList.add(treeNode.right.left);
                if (Objects.nonNull(treeNode.right.right))
                    treeNodeList.add(treeNode.right.right);

                treeNode.right = null;
                return;
            }

            inOrderTraversalSearch(treeNode.left, elementToBeDeleted);
            inOrderTraversalSearch(treeNode.right, elementToBeDeleted);
        }
    }
}

// Accepted Solution

class Solution {
    public static ArrayList<TreeNode> preorder(TreeNode root, HashSet<Integer> set, ArrayList<TreeNode> list, TreeNode parent){
        if(root == null) return list;
        //System.out.println(root.val);
        list = preorder(root.left, set, list, root);
        list = preorder(root.right, set, list, root);
        if(set.contains(root.val)){
            System.out.println(root.val);
            //list.add(root);
            if(root.left!=null && !set.contains(root.left.val)) {
                list.add(root.left);
                root.left = null;
            }
            if(root.right!=null && !set.contains(root.right.val)) {
                list.add(root.right);
                root.right = null;
            }
            if(parent!=null){
                if(parent.left!=null && parent.left.val == root.val){
                    parent.left = null;
                }
                if(parent.right!=null && parent.right.val == root.val){
                    parent.right = null;
                }
            }
            //root = null;
            //System.out.println(root.val);
        }
        
        return list;

    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<to_delete.length; i++){
            set.add(to_delete[i]);
        }
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        list = preorder(root, set, list, null);
        if(!set.contains(root.val)){
            list.add(root);
        }
        
        return list;
        
    }
}