package basic.sort;

public class ShellSort {
    public static void sort(int[] array) {
        if (array.length < 2)
            return;

        int len = array.length;
        int temp, gap = len / 2;

        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 6 ,5, 4, 1};
//        int[] array = {1};
        sort(array);
        for (int n : array) {
            System.out.printf("%d ", n);
        }
        System.out.println();
    }
}
