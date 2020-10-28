package basic.sort;

public class SelectSort {
    public static void sort(int[] array) {
        if (array.length < 2)
            return;

        for (int pos = array.length - 1; pos > 0; pos--) {
            int target = pos;

            for (int i = 0; i < pos; i++) {
                if (array[i] > array[target]) {
                    target = i;
                }
            }

            int tmp = array[pos];
            array[pos] = array[target];
            array[target] = tmp;
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
