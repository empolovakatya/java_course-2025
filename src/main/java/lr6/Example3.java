package lr6;

//Напишите программу с классом, в котором есть статические методы,
//которым можно передавать произвольное количество целочисленных аргументов
//        (или целочисленный массив). Методы, на основании переданных аргументов или массива,
//позволяют вычислить: наибольшее значение, наименьшее значение,
//а также среднее значение из набора чисел.

class MathUtils{
    public static int findMax(int... ints){
        int max = ints[0];
        for (int num : ints) {
            if (num > max){
                max = num;
            }
        }
        return max;
    }

    public static int findMin(int... ints){
        int min = ints[0];
        for (int num : ints) {
            if (num < min){
                min = num;
            }
        }
        return min;
    }

    public static float findAverage(int... ints){
        float average = 0;
        for (int num : ints) {
            average += num;
        }
        return average / ints.length;
    }
}


public class Example3 {
    public static void main(String[] args) {
        int[] numbersArray = {4, 12, 7, 25, 9, 18};
        System.out.println("Работа с массивом:");
        System.out.println("Максимум: " + MathUtils.findMax(numbersArray));
        System.out.println("Минимум: " + MathUtils.findMin(numbersArray));
        System.out.println("Среднее: " + MathUtils.findAverage(numbersArray));

        System.out.println("Работа с произвольным количеством аргументов:");
        System.out.println("Максимум: " + MathUtils.findMax(4, 12, 7, 25, 9, 18));
        System.out.println("Минимум: " + MathUtils.findMin(4, 12, 7, 25, 9, 18));
        System.out.println("Среднее: " + MathUtils.findAverage(4, 12, 7, 25, 9, 18));

        System.out.println("Работа с одним аргументом:");
        System.out.println("Максимум: " + MathUtils.findMax(10));
        System.out.println("Минимум: " + MathUtils.findMin(10));
        System.out.println("Среднее: " + MathUtils.findAverage(10));
    }
}
