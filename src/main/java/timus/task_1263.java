package timus;

import java.util.Scanner;

public class task_1263 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // число кандидатов
        int m = scanner.nextInt(); // число избирателей

        int[] votes = new int[n + 1]; // индексы от 1 до N

        for (int i = 0; i < m; i++) {
            int candidate = scanner.nextInt();
            votes[candidate]++;
        }

        for (int i = 1; i <= n; i++) {
            double percent = (double) votes[i] / m * 100;
            System.out.printf("%.2f%%\n", percent);
        }

        scanner.close();
    }
}