package basic.dp;

import java.io.PrintStream;

public class MatMul {
    private static PrintStream out = System.out;

    /**
     * 备忘录 <br/>
     * DP的核心思想：将大问题分解成相同解法的子问题 <br/>
     * 先处理特殊情况，之后对矩阵添加分组括号，是的左右两组的组内乘法次数加上组间乘法次数之和最小，此时的加括号位置即是我们想要的。
     * 首先计算少量连续矩阵的中间结果，从最小问题规模，累计求出最终解。 <br/>
     *
     * 易错点：枚举中间分隔括号位置的时候，k值从第一个矩阵下标i开始，意思是从在第一个矩阵和第二个矩阵中间加括号开始枚举。
     * 有时候粗心，会让k从i+1开始枚举，导致漏掉这种情况。
     * @param numbers
     * @return
     */
    public static int minMulTimes(int[] numbers) {
        // 特殊情况
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        int[][] C = new int[numbers.length][numbers.length];

        for (int gap = 1; gap < C.length; gap++) {
            for (int i = 1, j = i + gap; j < C.length; i++, j++) {
                if (j == i + 1) {
                    C[i][j] = numbers[i-1] * numbers[i] * numbers[j];
                }
                else {
                    int minTimes = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        int times = C[i][k] + C[k+1][j] + numbers[i-1] * numbers[k] * numbers[j];
                        minTimes = Math.min(minTimes, times);
                    }
                    C[i][j] = minTimes;
                }
            }
        }

        return C[1][numbers.length-1];
    }

    public static void main(String[] args) {
        int[] numbers = {30, 35, 15, 5, 10, 20, 25};

        out.println(minMulTimes(numbers));
//        for (int i : numbers) {
//            out.println(i);
//        }
    }
}
