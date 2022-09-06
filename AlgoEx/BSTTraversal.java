package AlgoEx;

import java.util.*;

class BSTTraversal {
  public static void main(String args[]) {
    BSTTraversal program = new BSTTraversal();
    BST tree = new BST(10);
    BST tree5 = new BST(5);
    BST tree15 = new BST(15);
    BST tree2 = new BST(2);
    BST tree5_2 = new BST(5);
    BST tree22 = new BST(22);
    tree.left = tree5;
    tree.right = tree15;
    tree5.left = tree2;
    tree5.right = tree5_2;
    tree15.right = tree22;

    // act
    List<Integer> preOrder = program.preOrderTraverse(tree, new ArrayList<Integer>());
    List<Integer> inOrder = program.inOrderTraverse(tree, new ArrayList<Integer>());
    List<Integer> postOrder = program.postOrderTraverse(tree, new ArrayList<Integer>());

    // print
    System.out.println("preOrder:");
    for (Integer number : preOrder)
      System.out.print(number + " ");
    System.out.println("\ninOrder:");
    for (Integer number : inOrder)
      System.out.print(number + " ");
    System.out.println("\npostOrder:");
    for (Integer number : postOrder)
      System.out.print(number + " ");

  }

  public List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
    if (tree == null)
      return array;

    inOrderTraverse(tree.left, array);
    array.add(tree.value);
    inOrderTraverse(tree.right, array);

    return array;
  }

  public List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
    if (tree == null)
      return array;

    array.add(tree.value);
    preOrderTraverse(tree.left, array);
    preOrderTraverse(tree.right, array);

    return array;
  }

  public List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
    if (tree == null)
      return array;

    postOrderTraverse(tree.left, array);
    postOrderTraverse(tree.right, array);
    array.add(tree.value);

    return array;
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
