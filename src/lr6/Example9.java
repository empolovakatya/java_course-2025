package lr6;

//Напишите программу со статическим методом,
//аргументом которому передается одномерный символьный массив.
//В результате вызова метода элементы массива попарно меняются местами:
//первый — с последним, второй — с предпоследним и так далее.

import java.util.Arrays;

class ArraySwap {
    public static void doSwap(char[] symbols) {
        if (symbols.length > 1) {
            for (int i = 0; i < symbols.length / 2; i++) {
                int j = symbols.length - 1 - i;
                char a = symbols[i];
                symbols[i] = symbols[j];
                symbols[j] = a;
            }
        }
    }
}


public class Example9 {
    public static void main(String[] args) {
        char[] array = new char[]{'A', 'B', 'C', 'D'};
        ArraySwap.doSwap(array);
        System.out.println(Arrays.toString(array)); // [D, C, B, A]
    }
}

