package LeetCode;

public class PlusOne_66 {

  public static void main(String args[]) {
    PlusOne_66 program = new PlusOne_66();

    // params
    int[] digits = { 1, 2, 9 };

    // execute
    int[] result = program.plusOne(digits);

    // display
    for (int number : result)
      System.out.print(number + ", ");
  }

  // time: O(N)
  // space: O(N)
  public int[] plusOne(int[] digits) {
    int n = digits.length;

    for (int i = n - 1; i >= 0; i--) {
      if (digits[i] == 9) {
        digits[i] = 0;
      } else {
        digits[i]++;
        return digits;
      }
    }

    int[] result = new int[n + 1];
    result[0] = 1;
    return result;
  }
}
