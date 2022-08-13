package Amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates {
    private static final int GATE = 0;
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
            new int[] { 1, 0 },
            new int[] { -1, 0 },
            new int[] { 0, 1 },
            new int[] { 0, -1 });

    public static void main(String[] args) {
        int[][] rooms = { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
                { 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } };

        WallsAndGates solution = new WallsAndGates();
        solution.wallsAndGates(rooms);

        for (int rows[] : rooms) {
            System.out.println();
            for (int col : rows) {
                System.out.print(col + ", ");
            }
        }
    }

    // time O(rows*cols)
    // space O(rows*cols)
    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (rooms[row][col] == GATE) {
                    queue.add(new int[] {row, col});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] points = queue.poll();
            int rowPoint = points[0];
            int colPoint = points[1];

            for(int[] direction: DIRECTIONS) {
                int actualRow = rowPoint + direction[0];
                int actualCol = colPoint + direction[1];

                if(actualCol < 0 || actualRow < 0 || actualCol >= cols || actualRow >= rows || rooms[actualRow][actualCol] != EMPTY) {
                    continue;
                }
    
                rooms[actualRow][actualCol] = rooms[rowPoint][colPoint] +1;
                queue.add(new int[]{actualRow, actualCol});
            }
        }
    }
}
