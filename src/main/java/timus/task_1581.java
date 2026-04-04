package timus;

import java.util.Scanner;

public class task_1581 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            int cur = a[i];
            int count = 0;
            while (i < n && a[i] == cur) {
                count++;
                i++;
            }
            if (sb.length() > 0) sb.append(" ");
            sb.append(count).append(" ").append(cur);
        }
        System.out.println(sb);
    }
}