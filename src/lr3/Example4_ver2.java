package lr3;

import java.io.PrintWriter;
import java.util.Scanner;

public class Example4_ver2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int a = in.nextInt();
        int b = in.nextInt();
        int firstNum = Math.min(a, b);
        int size = Math.max(a, b) - firstNum + 1;


        int[] result = new int[size];
        int i = 0;
        while(i < size) {
            result [i] = firstNum;
            firstNum++;
            i++;

        }
        for (int number :result) {
            out.print(number + " ");
        }
        out.flush();

    }

}
