package AlgoEx;

import java.security.cert.CertPathValidatorException.Reason;
import java.util.*;

class ValidateBST {
  public static void main(String args[]) {
    ValidateBST program = new ValidateBST();
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
    boolean result = program.validateBst(tree);

    // print
    System.out.println(result);
  }

  // time O(N)
  // space O(D)
  public boolean validateBst(BST tree) {
    return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public boolean validateBst(BST tree, int minValue, int maxValue) {
    if (tree.value < minValue || tree.value >= maxValue)
      return false;
    if (tree.left != null && !validateBst(tree.left, minValue, tree.value))
      return false;
    if (tree.right != null && !validateBst(tree.right, tree.value, maxValue))
      return false;

    return true;
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
