package lr3;


import java.io.PrintWriter;
import java.util.Scanner;

public class Example3_ver2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int size = in.nextInt();
        int[] fibonacci = new int[size];

        fibonacci[0] = 1;
        fibonacci[1] = 1;
        int i = 2;

        while (i < size) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            i++;
        }

        for (int number : fibonacci) {
            out.print(number + " ");
        }
        out.flush();
    }
}
