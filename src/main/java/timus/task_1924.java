package timus;

import java.util.Scanner;

public class task_1924 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n % 4 == 3 || n % 4 == 0) {
            System.out.println("black");
        } else {
            System.out.println("grimy");
        }
    }
}