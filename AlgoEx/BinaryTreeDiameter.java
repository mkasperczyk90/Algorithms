package AlgoEx;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeDiameter {
    int diameter = 0;

    public static void main(String args[]) {
        BinaryTreeDiameter program = new BinaryTreeDiameter(); // important! Minimum secound index!

        BinaryTree tree1 = new BinaryTree(1);
        BinaryTree tree2 = new BinaryTree(2);
        BinaryTree tree3 = new BinaryTree(3);
        BinaryTree tree4 = new BinaryTree(4);
        BinaryTree tree5 = new BinaryTree(5);
        BinaryTree tree6 = new BinaryTree(6);
        BinaryTree tree7 = new BinaryTree(7);
        BinaryTree tree8 = new BinaryTree(8);
        BinaryTree tree9 = new BinaryTree(9);
        tree1.left = tree3;
        tree1.right = tree2;
        tree3.left = tree7;
        tree3.right = tree4;
        tree7.left = tree8;
        tree8.left = tree9;
        tree4.right = tree5;
        tree5.right = tree6;

        // execute
        int result = program.binaryTreeDiameter(tree1);

        // display
        System.out.println(result);
    }

    // time: O(N)
    // space: O(h) - height of tree
    public int binaryTreeDiameter(BinaryTree tree) {
        return getTreeInfo(tree).diameter;
    }

    public TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null)
            return new TreeInfo(0, 0);

        TreeInfo leftNodeInfo = getTreeInfo(tree.left);
        TreeInfo rightNodeInfo = getTreeInfo(tree.right);

        int rootLongestPath = leftNodeInfo.height + rightNodeInfo.height;
        int maxDiameter = Math.max(leftNodeInfo.diameter, rightNodeInfo.diameter);
        int currDiameter = Math.max(maxDiameter, rootLongestPath);
        int currHeight = 1 + Math.max(leftNodeInfo.height, rightNodeInfo.height);
        return new TreeInfo(currDiameter, currHeight);
    }

    static class TreeInfo {
        public int diameter;
        public int height;

        public TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
