package lb1;

//Напишите программу, в которой Пользователь вводит два числа,
//а программой вычисляется и отображается сумма и разность этих чисел.


import java.util.Scanner;

public class Example15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число: ");
        int num = in.nextInt();
        System.out.println("Введите еще одно число: ");
        int nextNum = in.nextInt();
        int sum = num + nextNum;
        int diff = num - nextNum;
        System.out.println("Сумма чисел равна " + sum);
        System.out.println("Разность чисел равна " + diff);
        in.close();
    }
}
