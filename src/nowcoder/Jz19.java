package nowcoder;

import java.util.ArrayList;

public class Jz19 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0)
            return res;

        int rowS = 0, rowE = matrix[0].length;
        int colS = 0, colE = matrix.length;

        while (rowS < rowE && colS < colE) {
            int i = rowS, j = colS - 1;
//            go right
            while (j < rowE - 1) {
                res.add(matrix[i][++j]);
            }
//            go down
            while (i < colE - 1) {
                res.add(matrix[++i][j]);
            }
//            go left
            if (colE - colS > 1) {
                while (j > colS) {
                    res.add(matrix[i][--j]);
                }
            }
//            go up
            if (rowE - rowS > 1) {
                while (i > rowS + 1) {
                    res.add(matrix[--i][j]);
                }
            }
//            缩小矩阵范围
            rowS++; rowE--;
            colS++; colE--;
        }

        return res;
    }
}
