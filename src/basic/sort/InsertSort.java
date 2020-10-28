package basic.sort;

public class InsertSort {
    public static void sort(int[] array) {
        if (array.length < 2)
            return;

        for (int target = 1; target < array.length; target++) {
            int targetNum = array[target];

            int i = target - 1;
            while (i >= 0 && targetNum < array[i]) {
                array[i+1] = array[i];
                i--;
            }
            array[++i] = targetNum;
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
