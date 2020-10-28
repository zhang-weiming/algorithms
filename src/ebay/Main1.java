package ebay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();

        if (n == 0) {
            System.out.print("");
            return;
        }

        ArrayList<Integer> data = new ArrayList<>(n);

        if (m == 0) {
            for (int d : data) {
                System.out.print(d + " ");
            }
            return;
        }

        for (int i = 0; i < m; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();

            int sum = data.get(a-1) + c;
        }
    }
}
