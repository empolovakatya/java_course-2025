package lr1;

//Напишите программу, в которой по году рождения определяется возраст пользователя.

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите год рождения: ");
        int year = in.nextInt();
        int age = 2025 - year;
        System.out.println("Ваш возраст в этом году - " + age);
        in.close();
    }
}
