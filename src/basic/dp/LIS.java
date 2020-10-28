package basic.dp;

import java.io.PrintStream;

public class LIS {
    static PrintStream out = System.out;

    /**
     * 最小问题是只有一个数 <br/>
     * 次小问题是有两个数 <br/>
     * 每次对末尾元素计算最大上升子序列长度，寻找过程是枚举其前面的所有中间结果，与末尾元素组合能得到的最大可能结果 <br/>
     *
     * @param numbers
     * @return
     */
    public static int findLIS(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        int[] C = new int[numbers.length];
        int res = 0;

        for (int i = 0; i < numbers.length; i++) {
            C[i] = 1;
            for (int k = 0; k < i; k++) {
                if (numbers[k] < numbers[i] && C[k] + 1 > C[i]) {
                    C[i] = C[k] + 1;
                }
            }
            res = Math.max(res, C[i]);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] numbers = {1, 3, 4, 2, 7, 9, 6, 8};

        out.println(findLIS(numbers));

    }
}
