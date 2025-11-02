package timus;

//Исходные данные
//n (0 ≤ n ≤ 100)
//Результат
//Три различных целых числа (а, b, c) таких, что аn + bn = cn, 1 ≤ a, b, c ≤ 100.
//Если решений несколько, вывести то, где a минимально.
//Если и таких несколько, вывести то, где минимально b и т.д.
//        Вывести −1, если решения нет.


import java.io.PrintWriter;
import java.util.Scanner;

public class task_1349 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = in.nextInt();
        int [] result = new int[3];

        if (n == 1) {
            for (int i = 0; i < result.length; i++) {
                result[i] = i+n;
                out.print(result[i] + " ");
            }
        } else if (n == 2) {
            for (int i = 0; i < result.length; i++) {
                result[i] = i+3;
                out.print(result[i] + " ");
            }
        } else {
            out.print(-1);
        }
        out.flush();
    }
}
