package lr4;

//Напишите программу, в которой создается двумерный целочисленный массив.
//Он заполняется случайными числами.
//Затем в этом массиве строки и столбцы меняются местами:
//первая строка становится первым столбцом,
//вторая строка становиться вторым столбцом и так далее.
//Например, если исходный массив состоял из 3 строк и 5 столбцов,
//то в итоге получаем массив из 5 строк и 3 столбцов.


import java.util.Random;

public class Example5 {
    public static void main(String[] args) {
        int [][] nums = new int[3][5];
        Random random = new Random();
        int [][] transportedNums = new int [5][3];

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 5; j++){
                nums[i][j] = random.nextInt(100);
            }
        }
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 3; j++){
                transportedNums[i][j] = nums [j][i];
                System.out.print(transportedNums[i][j] + " ");
            }
            System.out.println(" ");
        }

    }
}
