package lr3;

//Напишите программу, в которой пользователю предлагается ввести название дня недели.
//По введенному названию программа определяет порядковый номер дня в неделе.
//Если пользователь вводит неправильное название дня,
//программа выводит сообщение о том, что такого дня нет.
//Предложите версию программы
//на основе вложенных условных операторов и
//на основе оператора выбора switch.


import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String day = in.nextLine().toLowerCase(Locale.ROOT);

        switch (day){
            case "понедельник":
                out.println(1);
                break;
            case "вторник":
                out.println(2);
                break;
            case "среда":
                out.println(3);
                break;
            case "четверг":
                out.println(4);
                break;
            case "пятница":
                out.println(5);
                break;
            case "суббота":
                out.println(6);
                break;
            case "воскресение":
                out.println(7);
                break;
            default:
                out.println("Введено неправильное название дня");
        }
        out.flush();
    }
}
