package nowcoder;

import java.io.PrintStream;

public class Jz66 {
    public int res = 0;

    public boolean isLegal(int i, int j, int threshold) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum <= threshold;
    }

    public int goUp(int i, int j, int threshold, int rows, int cols, int[][] visited) {
        if (i == 0 || visited[i-1][j] == 1 || !isLegal(i, j, threshold))
            return 0;
        i -= 1;
        visited[i][j] = 1;
        return 1;
    }
    public int goLeft(int i, int j, int threshold, int rows, int cols, int[][] visited) {
        if (j == 0 || visited[i][j-1] == 1 || !isLegal(i, j, threshold))
            return 0;
        j -= 1;
        visited[i][j] = 1;
        return 1;
    }
    public int goRight(int i, int j, int threshold, int rows, int cols, int[][] visited) {
        if (j == cols - 1 || visited[i][j+1] == 1 || !isLegal(i, j+1, threshold))
            return 0;
        j += 1;
        visited[i][j] = 1;
        return 1;
    }
    public int goDown(int i, int j, int threshold, int rows, int cols, int[][] visited) {
        if (i == rows - 1 || visited[i+1][j] == 1 || !isLegal(i+1, j, threshold))
            return 0;
        i += 1;
        visited[i][j] = 1;
        return 1;
    }

    public void move(int i, int j, int threshold, int rows, int cols, int[][] visited) {
//         if (isLegal(i, j, threshold)) {
// //             res += 1;
//         }
//         else {
//             return;
//         }

        if (goRight(i, j, threshold, rows, cols, visited) == 1) {
            move(i, j + 1, threshold, rows, cols, visited);
        }
        if (goDown(i, j, threshold, rows, cols, visited) == 1) {
            move(i + 1, j, threshold, rows, cols, visited);
        }
    }

    public int movingCount(int threshold, int rows, int cols) {
        if (rows < 1 || cols < 1) {
            return 0;
        }
        if (rows == 1 && cols == 1) {
            return 1;
        }

        int[][] visited = new int[rows][cols];
        visited[0][0] = 1;
        move(0, 0, threshold, rows, cols, visited);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] == 1) {
                    res += 1;
                }
            }
        }

        return res;
    }

    static PrintStream out = System.out;

    public static void main(String[] args) {
        Jz66 demo = new Jz66();
        out.println(demo.movingCount(10, 1, 100));
    }
}
