package AlgoEx;

import java.util.*;

class SpiralTraverse {
  public static void main(String args[]) {
    // params
    int[][] array = {
        { 1, 2, 3, 4 },
        { 12, 13, 14, 5 },
        { 11, 16, 15, 6 },
        { 10, 9, 8, 7 }
    };

    // execute
    SpiralTraverse program = new SpiralTraverse();
    List<Integer> result = program.spiralTraverse(array);

    // print
    for (int num : result)
      System.out.print(num + " ");
  }

  // O(N) time
  // O(N) space
  public List<Integer> spiralTraverse(int[][] array) {
    List<Integer> result = new ArrayList<Integer>();
    int startRow = 0;
    int startCol = 0;
    int endRow = array.length - 1;
    int endCol = array[0].length - 1;

    while (startRow <= endRow && startCol <= endCol) {
      for (int col = startCol; col <= endCol; col++) {
        result.add(array[startRow][col]);
      }
      for (int row = startRow + 1; row <= endRow; row++) {
        result.add(array[row][endCol]);
      }
      for (int col = endCol - 1; col >= startRow; col--) {
        if (startRow == endRow)
          break;
        result.add(array[endRow][col]);
      }
      for (int row = endRow - 1; row > startRow; row--) {
        if (startCol == endCol)
          break;
        result.add(array[row][startCol]);
      }

      startRow++;
      startCol++;
      endRow--;
      endCol--;
    }
    return result;
  }

}
