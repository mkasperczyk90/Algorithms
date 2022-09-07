package Learning;

import java.util.HashSet;
import java.util.Set;

public class GraphIslandCount {
    public static void main(String args[]) {
        GraphIslandCount program = new GraphIslandCount();

        char[][] grid = {
                { 'W', 'L', 'W', 'W', 'W' },
                { 'W', 'L', 'W', 'W', 'W' },
                { 'W', 'W', 'W', 'L', 'W' },
                { 'W', 'w', 'L', 'L', 'W' },
                { 'L', 'W', 'W', 'L', 'L' },
                { 'L', 'L', 'W', 'W', 'W' }
        };

        int result = program.IslandCount(grid);
        System.out.println("Count of islands: " + result);
    }

    public int IslandCount(char[][] grid) {
        Set<String> visited = new HashSet<>();
        int islands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (explore(grid, row, col, visited))
                    islands++;
            }
        }
        return islands;
    }

    private boolean explore(char[][] grid, int row, int col, Set<String> visited) {
        boolean rowInbounds = 0 <= row && row < grid.length;
        boolean colInbounds = 0 <= col && col < grid[0].length;
        if (!rowInbounds || !colInbounds)
            return false;

        if (grid[row][col] == 'W')
            return false;

        String setKey = Integer.toString(row) + ',' + Integer.toString(col);
        if (visited.contains(setKey))
            return false;
        visited.add(setKey);

        explore(grid, row + 1, col, visited);
        explore(grid, row, col + 1, visited);
        explore(grid, row - 1, col, visited);
        explore(grid, row, col - 1, visited);

        return true;
    }
}
