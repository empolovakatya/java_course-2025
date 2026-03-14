package lr9.task2.example6;

import java.util.Scanner;

//Создать приложение с использованием рекурсии для перевода целого числа, введенного с клавиатуры,
// в двоичную систему счисления.

public class DecimalToBinary {

    public static String toBinary(int n) {
        if (n == 0) return "0";
        if (n == 1) return "1";
        return toBinary(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число");
        int number = scanner.nextInt();
        System.out.println("Число " + number + " в двоичной системе: " + toBinary(number));
        scanner.close();
    }
}
