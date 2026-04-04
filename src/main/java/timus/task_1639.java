package timus;

import java.util.Scanner;

public class task_1639 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int totalMoves = m * n - 1;

        if (totalMoves % 2 == 1) {
            System.out.println("[:=[first]");
        } else {
            System.out.println("[second]=:]");
        }
    }
}