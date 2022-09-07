package LeetCode;

public class ConstructStringFromBinaryTree_606 {

    public static void main(String args[]) {
        ConstructStringFromBinaryTree_606 program = new ConstructStringFromBinaryTree_606();

        // params
        TreeNode tree1 = new TreeNode(1);
        TreeNode tree2 = new TreeNode(2);
        TreeNode tree3 = new TreeNode(3);
        TreeNode tree4 = new TreeNode(4);
        tree1.left = tree2;
        tree1.right = tree3;
        tree2.left = tree4;

        // execute
        String result = program.tree2str(tree1);

        // display
        System.out.print(result);
    }

    public String tree2str(TreeNode root) {
        if(root == null) return "";
        if(root.left == null && root.right == null) return root.value + "";        
        if(root.right == null) 
            return root.value + "(" + tree2str(root.left) + ")"; 
        return root.value+ "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }

    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
