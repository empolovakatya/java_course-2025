package lr1;


//Напишите программу, в которой пользователю предлагается ввести
//название месяца и количество дней в этом месяце.
//Программа выводит сообщение о том, что соответствующий месяц содержит указанное количество дней.

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите месяц: ");
        String month = in.nextLine();
        System.out.println("Введите количество дней: ");
        int days = in.nextInt();
        System.out.println("В месяце " + month + " " + days + " " + "дней");
        in.close();
    }
}

