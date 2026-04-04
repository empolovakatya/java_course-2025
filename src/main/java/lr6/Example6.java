package lr6;

//Напишите программу со статическим методом,
//которому аргументом передается целочисленный массив и целое число.
//Результатом метод возвращает ссылку на новый массив,
//который получается из исходного массива (переданного первым аргументом методу),
//если в нем взять несколько начальных элементов.
//        Количество элементов, которые нужно взять из исходного массива,
//определяются вторым аргументом метода. Если второй аргумент метода больше длины массива,
//переданного первым аргументом, то методом создается копия исходного массива и
//возвращается ссылка на эту копию.


import java.util.Arrays;

class ArraySlice{
    public static int[] doSlice(int[] array, int length){
        if (length <= array.length){
            int [] newArray = new int [length];
            for (int i = 0; i < length; i++){
                newArray[i] = array[i];
            }
            return newArray;
        } else {
            int [] newArray = array;
            return newArray;
        }
    }
}

public class Example6 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Исходный массив: " + Arrays.toString(numbers));

        System.out.println("doSlice(numbers, 2): " +
                Arrays.toString(ArraySlice.doSlice(numbers, 2)));

        System.out.println("doSlice(numbers, 5): " +
                Arrays.toString(ArraySlice.doSlice(numbers, 5)));

        System.out.println("doSlice(numbers, 7): " +
                Arrays.toString(ArraySlice.doSlice(numbers, 7)));

        System.out.println("doSlice(numbers, 0): " +
                Arrays.toString(ArraySlice.doSlice(numbers, 0)));
    }

}
