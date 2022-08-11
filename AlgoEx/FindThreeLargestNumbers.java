package AlgoEx;

import java.util.*;

class FindThreeLargestNumbers {
  public static void main(String args[]) {
    FindThreeLargestNumbers program = new FindThreeLargestNumbers();
    int[] array = { 141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7 };

    int[] result = program.findThreeLargestNumbers_1(array);

    System.out.println(result[0]);
    System.out.println(result[1]);
    System.out.println(result[2]);
  }

  public int[] findThreeLargestNumbers_2(int[] array) {
    int max = Integer.MIN_VALUE;
    int mid = Integer.MIN_VALUE;
    int min = Integer.MIN_VALUE;

    for (int num : array) {
      if (num > max) {
        min = mid;
        mid = max;
        max = num;
      } else if (num > mid) {
        min = mid;
        mid = num;
      } else if (num > min) {
        min = num;
      }
    }
    return new int[] { min, mid, max };
  }

  public int[] findThreeLargestNumbers_1(int[] array) {
    int[] threeMax = { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };

    for (int num : array) {
      if (num > threeMax[2]) {
        shift(threeMax, num, 2);
      } else if (num > threeMax[1]) {
        shift(threeMax, num, 1);
      } else if (num > threeMax[0]) {
        shift(threeMax, num, 0);
      }
    }
    return threeMax;
  }

  private void shift(int[] array, int num, int index) {
    for (int i = 0; i <= index; i++) {
      if (i == index) {
        array[i] = num;
      } else {
        array[i] = array[i + 1];
      }
    }
  }
}
