package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Jz50 {

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (length == 0)
            return false;

        ArrayList<Integer> list = new ArrayList<>();
        for (int num : numbers) {
            if (list.contains(num)) {
                duplication[0] = num;
                return true;
            }
            list.add(num);
        }

        return false;
    }
}
