package lr9.task1.example2;

//Пример 2. Вывести последовательность, представленную в предыдущем примере, в обратном порядке.

public class Recursion {
    public static void m(int x) {
        if ((2 * x + 1) < 20) {
            m(2 * x + 1);
        }
        System.out.println("x=" + x);
    }

    public static void main(String[] args) {
        m(1);
    }
}
