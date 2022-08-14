package AlgoEx;

import java.util.*;

class SmallestDifference {
  public static void main(String args[]) {
    // params
    int[] arrayOne = { -1, 5, 10, 20, 28, 3 };
    int[] arrayTwo = { 26, 134, 135, 15, 17 };

    // execute
    SmallestDifference program = new SmallestDifference();
    int[] result = program.smallestDifference(arrayOne, arrayTwo);

    // print
    for (int num : result)
      System.out.print(num + " ");
  }

  // time: O(nlogn + mlogn)
  // space: O(1)
  public int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    Arrays.sort(arrayOne);
    Arrays.sort(arrayTwo);

    int smallestDifference = Integer.MAX_VALUE;
    int current = Integer.MAX_VALUE;
    int indexOne = 0;
    int indexTwo = 0;
    int[] resultCandidate = new int[2];

    while (indexOne < arrayOne.length && indexTwo < arrayTwo.length) {
      int numberOne = arrayOne[indexOne];
      int numberTwo = arrayTwo[indexTwo];
      if (numberOne == numberTwo) {
        return new int[] { numberOne, numberTwo };
      } else if (numberOne > numberTwo) {
        current = numberOne - numberTwo;
        indexTwo++;
      } else {
        current = numberTwo - numberOne;
        indexOne++;
      }

      if (current < smallestDifference) {
        smallestDifference = current;
        resultCandidate = new int[] { numberOne, numberTwo };
      }
    }

    return resultCandidate;
  }

}
