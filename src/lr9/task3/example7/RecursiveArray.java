package lr9.task3.example7;

import java.util.Scanner;

public class RecursiveArray {
    public static void inputArray(int[] arr, int index, Scanner scanner) {
        if (index >= arr.length) return;
        arr[index] = scanner.nextInt();
        inputArray(arr, index + 1, scanner);
    }

    public static void outputArray(int[] arr, int index) {
        if (index >= arr.length) {
            System.out.println();
            return;
        }
        System.out.println(arr[index] + " ");
        outputArray(arr, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = scanner.nextInt();

        int [] array = new int[size];

        System.out.println("Ввод элементов массива:");
        inputArray(array, 0, scanner);

        System.out.println("Вывод элементов массива:");
         outputArray(array, 0);

         scanner.close();
    }
}
