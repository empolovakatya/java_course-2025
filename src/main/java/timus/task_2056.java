package timus;

import java.util.Scanner;

public class task_2056 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        boolean hasThree = false;
        boolean allFive = true;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            int grade = scanner.nextInt();
            if (grade == 3) {
                hasThree = true;
            }
            if (grade != 5) {
                allFive = false;
            }
            sum += grade;
        }

        double average = sum / n;

        if (hasThree) {
            System.out.println("None");
        } else if (allFive) {
            System.out.println("Named");
        } else if (average >= 4.5) {
            System.out.println("High");
        } else {
            System.out.println("Common");
        }

        scanner.close();
    }
}