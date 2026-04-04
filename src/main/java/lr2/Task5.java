package lr2;


//Напишите программу, которая проверяет, сколько тысяч во введенном
//пользователем числе (определяется четвертая цифра справа в десятичном
//        представлении числа).

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число: ");
        int num = in.nextInt();
        int result = (num / 1000) % 10;
        System.out.println(result);
        in.close();
        }
    }
