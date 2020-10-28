package nowcoder;

public class Jz48 {
    public int Add(int num1,int num2) {
        while (num2 != 0) {
            int c = (num1 & num2) << 1;
            num1 = num1 ^ num2;
            num2 = c;
        }
        return num1;
    }

    public static void main(String[] args) {
        Jz48 jz48 = new Jz48();
        System.out.println(
                jz48.Add(5, -6)
        );
    }
}
