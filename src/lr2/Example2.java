package lr2;

//Напишите программу, которая проверяет, удовлетворяет ли введенное
//пользователем число следующим критериям: при делении на 5 в остатке
//получается 2, а при делении на 7 в остатке получается 1

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число: ");
        int num = in.nextInt();
        if (num % 5 == 2 && num % 7 == 1) {
            System.out.println("Число подходит");
        }
        else {
            System.out.println("Число не подходит");
        }
        in.close();
    }
}
