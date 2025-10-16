package lr2;


//Напишите программу, которая проверяет, попадает ли введение
//пользователем число в диапазон от 5 до 10 включительно.

import java.util.Scanner;

public class Example4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число: ");
        int num = in.nextInt();
        if (num >= 5 && num <= 10) {
            System.out.println("Число подходит");
        }
        else {
            System.out.println("Число не подходит");
        }
        in.close();
    }
}

