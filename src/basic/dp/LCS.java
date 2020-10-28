package basic.dp;

import java.io.PrintStream;


public class LCS {
    static PrintStream out = System.out;

    /**
     * 备忘录 <br/>
     * 长度分别为i和j的子串x和y的最后一个元素相等，则他们的最长子串数为长i-1和j-1的子串的最长子串数+1 <br/>
     * 如果末尾元素不相等，当长度组合为（i-1, j）比（i, j-1）的最长子串数更大时，公共元素来自（i-1, j）组合，即长i-1的x的末尾元素；
     * 反之来自（i, j-1）组合，即长j-1的y的末尾元素 <br/>
     *
     * B数组用来记录每次的状态选择来源，取值分别为 1：相等的x和y的末尾元素，2：x的末尾元素，3：y的末尾元素 <br/>
     * 因此，从最后一个坐标（m-1. n-1）通过回溯就可以找到最长子串，但结果可能不唯一。
     *
     * @param X
     * @param Y
     * @param lcs
     * @return
     */
    public static int findLCS(char[] X, char[] Y, String[] lcs) {
        if (X == null || Y == null || X.length == 0 || Y.length == 0) {
            lcs[0] = "";
            return 0;
        }

        int m = X.length + 1;
        int n = Y.length + 1;
        int[][] C = new int[m][n];
        int[][] B = new int[m][n];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (X[i-1] == Y[j-1]) {
                    C[i][j] = C[i-1][j-1] + 1;
                    B[i][j] = 1;
                }
                else if (C[i-1][j] > C[i][j-1]) {
                    C[i][j] = C[i-1][j];
                    B[i][j] = 2;
                }
                else {
                    C[i][j] = C[i][j-1];
                    B[i][j] = 3;
                }
            }
        }

        StringBuilder strBulder = new StringBuilder();
        int i = m - 1;
        int j = n - 1;
        while (i > 0 && j > 0) {
            switch (B[i][j]) {
                case 1:
                    strBulder.append(X[i-1]);
                    i--;
                    j--;
                    break;
                case 2:
                    i--;
                    break;
                case 3:
                    j--;
                    break;
            }
        }
        strBulder.reverse();
        lcs[0] = strBulder.toString();

        return C[m-1][n-1];
    }

    public static void main(String[] args) {
        char[] X = "ABCBDAB".toCharArray();
        char[] Y = "BDCABA".toCharArray();
        String[] lcs = new String[1];

        out.println(findLCS(X, Y, lcs));
        out.println(lcs[0]);
    }
}
