package timus;

//Определите по этим данным, сколько банок не прострелил Гарри
// и сколько банок не прострелил Ларри.
//Исходные данные
//В единственной строке записано 2 числа — количество банок,
// простреленных Гарри и Ларри соответственно.
//Результат
//Выведите 2 числа — количество банок, не простреленных Гарри и Ларри соответственно.
//исходные данные	результат
//4 7
//        6 3


import java.io.PrintWriter;
import java.util.Scanner;

public class task_1409 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int shotHarry = in.nextInt();
        int shotLarry = in.nextInt();

        int sum = shotHarry + shotLarry - 1;
        int resultHarry = sum - shotHarry;
        int resultLarry = sum - shotLarry;


        out.println(resultHarry + " " + resultLarry);
        out.flush();
    }
}
