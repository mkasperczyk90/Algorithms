package Learning;

import java.util.HashSet;
import java.util.Set;

public class GraphMinIsland {
    public static void main(String args[]) {
        GraphMinIsland program = new GraphMinIsland();

        char[][] grid = {
                { 'W', 'L', 'W', 'W', 'W' },
                { 'W', 'L', 'W', 'W', 'W' },
                { 'W', 'W', 'W', 'L', 'W' },
                { 'W', 'w', 'L', 'L', 'W' },
                { 'L', 'W', 'W', 'L', 'L' },
                { 'L', 'L', 'W', 'W', 'W' }
        };

        int result = program.MinIsland(grid);
        System.out.println("Min size of islands: " + result);
    }
    
    public int MinIsland(char[][] grid) {
        Set<String> visited = new HashSet<>();

        int minIslandSize = Integer.MAX_VALUE;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++) {
                int currentIslandSize = explore(grid, row, col, visited);
                if(currentIslandSize > 0)
                    minIslandSize = Math.min(minIslandSize, currentIslandSize);
            }
        }
        return minIslandSize;
    }

    private int explore(char[][] grid, int row, int col, Set<String> visited) {
        boolean rowInbounds = 0 <= row && row < grid.length;
        boolean colInbounds = 0 <= col && col < grid[0].length;
        if(!rowInbounds || !colInbounds) return 0;

        if(grid[row][col] == 'W') return 0;

        String setKey = Integer.toString(row) + ',' + Integer.toString(col);
        if(visited.contains(setKey)) return 0;
        visited.add(setKey);

        int size = 1;
        size += explore(grid, row+1, col, visited);
        size += explore(grid, row, col+1, visited);
        size += explore(grid, row-1, col, visited);
        size += explore(grid, row, col-1, visited);

        return size;
    }
}
