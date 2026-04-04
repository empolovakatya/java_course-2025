package lr6;

//Напишите программу со статическим методом,
//аргументом которому передается произвольное количество целочисленных аргументов.
//Результатом метод возвращает массив из двух элементов:
//это значения наибольшего и наименьшего значений среди аргументов, переданных методу.

import java.util.Arrays;

class MyCLass10{
    public static int[] getMaxAndMin(int... ints){
        int max = MathUtils.findMax(ints);
        int min = MathUtils.findMin(ints);
        return new int[] {max, min};
    }
}


public class Example10 {
    public static void main(String[] args) {
        int [] array = MyCLass10.getMaxAndMin(4, 12, 7, 25, 9, 18);
        System.out.println("Результат: " + Arrays.toString(array));
    }
}
