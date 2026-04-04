package lr3;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Task2_ver2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String day = in.nextLine().toLowerCase(Locale.ROOT);

        if (day.equals("понедельник")) {
            out.println(1);
        } else if (day.equals("вторник")) {
            out.println(2);
        } else if (day.equals("среда")) {
            out.println(3);
        } else if (day.equals("четверг")) {
            out.println(4);
        } else if (day.equals("пятница")) {
            out.println(5);
        } else if (day.equals("суббота")) {
            out.println(6);
        } else if (day.equals("воскресение")) {
            out.println(7);
        } else {
            out.println("Введено неправильное название дня");
        }
        out.flush();
    }
}
