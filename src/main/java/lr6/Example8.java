package lr6;

//Напишите программу со статическим методом,
//аргументом которому передается целочисленный массив,
//а результатом возвращается среднее значение для элементов массива
//        (сумма значений элементов, деленная на количество элементов в массиве).


class Average {
    public static float Calculate(int[] numbers){
        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        return (float) (sum / numbers.length);
    }
}




public class Example8 {
    public static void main(String[] args) {
        System.out.println(Average.Calculate(new int []{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 67})); // 11.0
    }
}
