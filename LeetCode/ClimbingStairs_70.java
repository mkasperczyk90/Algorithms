package LeetCode;

/*
 * Example dynamic programming for 6
 * [0, 1, 2, 3, 5, 8, 13]
 * [0, 1, 2, 2+1, 3+2, 5+8] ... adding 2 elements before 
 */

public class ClimbingStairs_70 {

  public static void main(String args[]) {
    ClimbingStairs_70 program = new ClimbingStairs_70();

    // params
    int n = 12;

    // execute
    int result = program.climbStairs(n);

    // display
    System.out.print(result);
  }

  // time: O(N)
  // space: O(N)
  public int climbStairs(int n) {
    if (n == 1) return 1;
    
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }
}