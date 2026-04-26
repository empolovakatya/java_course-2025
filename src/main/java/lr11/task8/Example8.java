package lr11.task8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

//8.	Напишите функцию, которая принимает на вход список целых чисел и возвращает новый список,
//содержащий только те числа, которые больше заданного значения.
public class Example8 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random();

        System.out.println("\n" + "Список до: " + "\n");
        for (int i =0; i < 10; i++) {
            integers.add(random.nextInt(1000));
            System.out.println(integers.get(i));
        }
        int integer = 500;

        List<Integer> integersAfter = filterNumbers(integers, integer);

        System.out.println("\n" + "Список после : " + "\n");

        for (Integer i: integersAfter) {
            System.out.println(i);
        }
    }
    public static List<Integer> filterNumbers(List<Integer> list, int number) {
        return list.stream().filter(x -> x > number).collect(Collectors.toList());
    }
}
