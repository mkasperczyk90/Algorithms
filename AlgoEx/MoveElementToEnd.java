package AlgoEx;

import java.util.*;

class MoveElementToEnd {
  public static void main(String args[]) {
    MoveElementToEnd program = new MoveElementToEnd();

    // params
    List<Integer> array = Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2);
    int toMove = 2;

    // execute
    List<Integer> result = program.moveElementToEnd(array, toMove);

    // display
    for (int number : result)
      System.out.print(number + ", ");
  }

  // time: O(N)
  // space: O(1)
  public List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    int left = 0;
    int right = array.size() - 1;

    while (left < right) {
      while (left < right && array.get(right) == toMove)
        right--;

      if (array.get(left) == toMove) {
        int tmp = array.get(right);
        array.set(right, array.get(left));
        array.set(left, tmp);
      }

      left++;
    }
    return array;
  }

}
