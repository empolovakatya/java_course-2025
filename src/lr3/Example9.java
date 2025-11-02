package lr3;

//Напишите программу, в которой создается массив и заполняется случайными числами.
//Массив отображается в консольном окне.
//В этом массиве необходимо определить элемент с минимальным значением.
//        В частности, программа должна вывести значение элемента
//с минимальным значением и индекс этого элемента.
//Если элементов с минимальным значением несколько,
//должны быть выведены индексы всех этих элементов.

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Example9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = in.nextInt();
        System.out.println("Размер массива равен " + size);
        int[] nums = new int[size];
        Random random = new Random();
        int equal = 0;

        for (int i = 0; i < nums.length; i++){
            nums[i] = random.nextInt(10);
            System.out.println("Элемент массива ["+i+"] = " + nums[i]);
        }
        Arrays.sort(nums);
        System.out.println("Произведена сортировка массива");
        for (int i = 0; i < nums.length; i++) {
            System.out.println("Элемент массива ["+i+"] после сортировки = " + nums[i]);
        }
        for (int num : nums) {
            if (nums[0] == num) {
                equal += 1;
            }
            }
        if (equal > 1) {
            for (int j = 0; j < equal; j++) {
                System.out.println("Минимальный элемент массива [" + j + "] = " + nums[j]);
            }
        }
    }

}
