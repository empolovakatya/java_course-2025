package lr9.task1.example5;

//Пример 5. Вывести число Фибоначчи, заданное его номером в последовательности.

public class Recursion {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }

    public static int fibonacci(int n) {
        System.out.println("fib(" + n + ") вызван");
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int result = fibonacci(n-2) + fibonacci(n - 1);
            System.out.println("fib(" + n + ") = " + result);
            return result;
        }
    }
}
