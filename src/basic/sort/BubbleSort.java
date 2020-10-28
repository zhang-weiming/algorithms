package basic.sort;

public class BubbleSort {
    public static void sort(int[] array) {
        if (array.length < 2)
            return;

        for (int end = array.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (array[i] > array[i+1]) {
                    int tmp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = tmp;
                }
            }
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
