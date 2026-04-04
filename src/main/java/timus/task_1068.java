package timus;

import java.util.Scanner;

public class task_1068 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int a = Math.min(1, N);
        int b = Math.max(1, N);

        int count = b - a + 1;

        int sum = (a + b) * count / 2;

        System.out.println(sum);
        scanner.close();
    }
}
