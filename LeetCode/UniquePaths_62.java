package LeetCode;

public class UniquePaths_62 {

    public static void main(String args[]) {
        UniquePaths_62 solution = new UniquePaths_62();
        // params
        int m = 3;
        int n = 7;

        // execute
        int result = solution.uniquePaths(m, n);

        // display
        System.out.println("Result: " + result);
    }

    // Time O(n*m)
    // Space O(n)
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];

        for (int row = 0; row < m; row++) {
            grid[row][n - 1] = 1; // set right rows
        }
        for (int col = 0; col < n; col++) {
            grid[m - 1][col] = 1; // set right column
        }

        for (int row = m - 2; row >= 0; row--) {
            for (int col = n - 2; col >= 0; col--) {
                grid[row][col] = grid[row + 1][col] + grid[row][col + 1];
            }
        }

        return grid[0][0];
    }
}
