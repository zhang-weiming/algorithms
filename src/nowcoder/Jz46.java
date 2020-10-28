package nowcoder;

public class Jz46 {

    /**
     * 没写完
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0)
            return -1;

        while (n > 1) {
            n = m % n;
        }

        return n - 1;
    }
}
