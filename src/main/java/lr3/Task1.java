package lr3;

//Напишите программу, в которой пользователь вводит целое число в диапазоне от 1 до 7,
//а программа определяет по этому числу день недели.
//Если введенное пользователем число выходит за допустимый диапазон,
//выводится сообщение о том, что введено некорректное значение.
//Используйте оператор выбора switch.

import java.io.PrintWriter;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();

        switch (n){
            case 1:
                out.println("Понедельник");
                break;
            case 2:
                out.println("Вторник");
                break;
            case 3:
                out.println("Среда");
                break;
            case 4:
                out.println("Четверг");
                break;
            case 5:
                out.println("Пятница");
                break;
            case 6:
                out.println("Суббота");
                break;
            case 7:
                out.println("Воскресение");
                break;
            default:
                out.println("Введено некорректное значение");
        }
        out.flush();
    }
}
