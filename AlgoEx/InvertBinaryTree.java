package AlgoEx;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String args[]) {
        InvertBinaryTree program = new InvertBinaryTree(); // important! Minimum secound index!

        BinaryTree tree1 = new BinaryTree(1);
        BinaryTree tree2 = new BinaryTree(2);
        BinaryTree tree3 = new BinaryTree(3);
        BinaryTree tree4 = new BinaryTree(4);
        BinaryTree tree5 = new BinaryTree(5);
        BinaryTree tree6 = new BinaryTree(6);
        BinaryTree tree7 = new BinaryTree(7);
        BinaryTree tree8 = new BinaryTree(8);
        BinaryTree tree9 = new BinaryTree(9);
        tree1.left = tree2;
        tree1.right = tree3;
        tree2.left = tree4;
        tree2.right = tree5;
        tree3.left = tree6;
        tree3.right = tree7;
        tree4.left = tree8;
        tree4.right = tree9;
        program.Print(tree1);

        // execute
        program.invertBinaryTree_queue(tree1);

        // display
        System.out.println("");
        program.Print(tree1);
    }

    // time: O(N)
    // space: O(N)
    public void invertBinaryTree(BinaryTree tree) {
        if(tree == null) return;

        BinaryTree tmp = tree.left;
        tree.left = tree.right;
        tree.right = tmp;

        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    // time: O(N)
    // space: O(N)
    public void invertBinaryTree_queue(BinaryTree tree) {
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();

        queue.add(tree);
        while(queue.size() > 0) {
            BinaryTree actualNode = queue.poll();
            BinaryTree tmp = actualNode.left;
            actualNode.left = actualNode.right;
            actualNode.right = tmp;

            if(actualNode.left != null) queue.add(actualNode.left);
            if(actualNode.right != null) queue.add(actualNode.right);
        }
    }

    public void Print(BinaryTree tree)
    {
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();

        queue.add(tree);
        while(queue.size() > 0) {
            BinaryTree actualNode = queue.poll();
            System.out.print(actualNode.value + " ");

            if(actualNode.left != null) queue.add(actualNode.left);
            if(actualNode.right != null) queue.add(actualNode.right);
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
