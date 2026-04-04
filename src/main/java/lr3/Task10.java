package lr3;

import java.util.*;

//Напишите программу, в которой создается целочисленный массив,
//заполняется случайными числами и после этого значения элементов
//в массиве сортируются в порядке убывания значений.

public class Task10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = in.nextInt();
        System.out.println("Размер массива равен " + size);
        int[] nums = new int[size];
        int[] reverseNums = new int[size];
        Random random = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10);
            System.out.println("Элемент массива [" + i + "] = " + nums[i]);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            reverseNums[i] = nums[size - 1 - i];
        }
        System.out.println("Произведена сортировка массива");
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Элемент массива [" + i + "] после сортировки = " + reverseNums[i]);
        }
    }
}
