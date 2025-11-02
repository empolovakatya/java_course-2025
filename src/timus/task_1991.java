package timus;

//Исходные данные
//В первой строке входных данных находятся числа n и k (1 ≤ n, k ≤ 10 000).
//Во второй строке находятся n чисел ai (0 ≤ ai ≤ 100 000) — количество бум-бумов в i-й тележке.
//Результат
//Выведите два числа — количество неиспользованных бум-бумов и количество выживших дроидов.
//        Пример
//исходные данные	результат
//4 5
//        2 7 5 0
//                                  2 8


import java.util.Scanner;

public class task_1991 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int [] result = new int[n];
        int droid = 0;
        int bumbum = 0;

        for (int i = 0; i < n; i++) {
            result[i] = k - in.nextInt();
        }

        for (int num : result){
            if (num > 0) {
                droid += num;
            } else {
                bumbum += num;
            }
        }
        System.out.println(-bumbum + " " + droid);
    }
}