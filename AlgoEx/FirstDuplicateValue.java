package AlgoEx;

import java.util.*;

class FirstDuplicateValue {
  public static void main(String args[]) {
    FirstDuplicateValue program = new FirstDuplicateValue(); // important! Minimum secound index!

    // params
    int[] array = { 2, 1, 5, 2, 3, 3, 4 };

    // execute
    int result = program.firstDuplicateValue_solution1(array);
    int result2 = program.firstDuplicateValue_solution2(array);

    // display
    System.out.println(result);
    System.out.println(result2);
  }

  // time: O(N^2)
  // space: O(1)
  public int firstDuplicateValue_solution1(int[] array) {
    int minSecoundIndex = array.length;

    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] == array[j]) {
          minSecoundIndex = Math.min(minSecoundIndex, j);
        }
      }
    }

    if (minSecoundIndex == array.length)
      return -1;

    return array[minSecoundIndex];
  }

  // time: O(N)
  // space: O(N)
  public int firstDuplicateValue_solution2(int[] array) {
    HashSet<Integer> currentValues = new HashSet<>();

    for (int num : array) {
      if (currentValues.contains(num))
        return num;
      currentValues.add(num);
    }

    return -1;
  }

}
