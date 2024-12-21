import java.util.ArrayList;
import java.util.List;

public class GreedyPathFinder {

    
    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public static void main(String[] args) {
        int[][] matrix = {
            {2, 3, -1, 4},
            {0, 6, 5, -1},
            {1, -1, 8, 9},
            {-1, 2, 3, 7}
        };
        findPath(matrix);
    }

    public static void findPath(int[][] matrix) {
        int n = matrix.length;
        List<int[]> path = new ArrayList<>();
        int x = 0, y = 0;
        
        path.add(new int[]{x, y});

        while (x != n - 1 || y != n - 1) {
            int maxNeighborValue = Integer.MIN_VALUE;
            int[] nextPosition = null;

            
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && matrix[newX][newY] != -1) {
                    if (matrix[newX][newY] > maxNeighborValue) {
                        maxNeighborValue = matrix[newX][newY];
                        nextPosition = new int[]{newX, newY};
                    }
                }
            }

            
            if (nextPosition == null) {
                System.out.println("NO POSSIBLE PATH");
                return;
            }

           
            x = nextPosition[0];
            y = nextPosition[1];
            path.add(new int[]{x, y});
        }

       
        System.out.println("Path from Start to Goal:");
        for (int[] pos : path) {
            System.out.println("[" + pos[0] + ", " + pos[1] + "]");
        }
    }
}
