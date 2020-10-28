package basic.sort;

import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[] left, int[] right) {
        int[] array = new int[left.length + right.length];

        int t = 0;
        int i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                array[t++] = left[i++];
            }
            else {
                array[t++] = right[j++];
            }
        }

        while (i < left.length) {
            array[t++] = left[i++];
        }
        while (j < right.length) {
            array[t++] = right[j++];
        }
        return array;
    }

    public static int[] mergeSort(int[] array) {
        if (array.length < 2)
            return array;

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 6 ,5, 4, 1};
//        int[] array = {1};
        array = mergeSort(array);
        for (int n : array) {
            System.out.printf("%d ", n);
        }
        System.out.println();
    }
}
