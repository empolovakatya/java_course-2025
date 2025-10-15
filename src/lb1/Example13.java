package lb1;

//Напишите программу для вычисления суммы двух чисел.
//Оба числа вводятся пользователем. Для вычисления суммы используйте оператор +.


import java.util.Scanner;

public class Example13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число: ");
        int num = in.nextInt();
        System.out.println("Введите еще одно число: ");
        int nextNum = in.nextInt();
        int sum = num + nextNum;
        System.out.println("Сумма чисел равна " + sum);
        in.close();
    }

}
