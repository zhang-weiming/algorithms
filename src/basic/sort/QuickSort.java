package basic.sort;

public class QuickSort {

    public static int partition(int[] array, int l, int r) {
        int pivot = array[l];

        while (l < r) {
            while (l < r && array[r] >= pivot)    r--;
            array[l] = array[r];

            while (l < r && array[l] <= pivot)    l++;
            array[r] = array[l];
        }
        array[l] = pivot;
        return l;
    }

    public static void quickSort(int[] array, int l, int r) {
        if (l >= r)     return;
        int p = partition(array, l, r);
        partition(array, l, p-1);
        partition(array, p+1, r);
    }

    public static void sort(int[] array) {
        if (array.length < 2)
            return;

        quickSort(array, 0, array.length-1);
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 6 ,5, 4, 1};
//        int[] array = {1};
        sort(array);
        for (int n : array) {
            System.out.printf("%d ", n);
        }
    }
}
