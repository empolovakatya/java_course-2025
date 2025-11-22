package lr3;

//Напишите программу, в которой пользователем вводится два целых числа.
//Программа выводит все целые числа — начиная с наименьшего (из двух введенных чисел)
//и заканчивая наибольшим (из двух введенных чисел).
//Предложите разные версии программы (с использованием разных операторов цикла).


import java.io.PrintWriter;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int a = in.nextInt();
        int b = in.nextInt();
        int firstNum = Math.min(a, b);
        int size = Math.max(a, b) - firstNum + 1;


        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result [i] = firstNum;
            firstNum++;

        }
        for (int number :result) {
            out.print(number + " ");
        }
        out.flush();

    }
}