package lr1;


//Напишите программу, в которой Пользователь вводит имя и год рождения,
//в программа отображает сообщение содержащее имя пользователя и его возраст.

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        System.out.println("Введите год рождения: ");
        int year = in.nextInt();
        int age = 2025 - year;
        System.out.println(name + " "+ age + " " + "лет");
        in.close();
    }
}
