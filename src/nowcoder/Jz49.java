package nowcoder;

public class Jz49 {

    public int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;

        int res = 0;
        boolean nagetive = false;

//        先处理第一个字符是不是 + -
        int i = 0;
        if (str.charAt(i) == '+') {
            i++;
        }
        else if (str.charAt(i) == '-') {
            nagetive = true;
            i++;
        }

        while (i < str.length()) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return 0;
            }
            res = res * 10 + Character.digit(c, 10);

            i++;
        }

        return nagetive ? -res : res;
    }
}
