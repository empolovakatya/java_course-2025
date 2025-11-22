package lr4;

//Напишите программу, в которой создается и инициализируется двумерный числовой массив.
//Затем из этого массива удаляется строка и столбец
//        (создается новый массив, в котором по сравнению с исходным удалена одна строка и один столбец).
//Индекс удаляемой строки и индекс удаляемого столбца определяется с помощью генератора случайных чисел.

import java.util.Random;

public class Task6 {
    public static void main(String[] args) {
        int size = 10;
        int [][] nums = new int[size][size];
        Random random = new Random();
        int [][] changedNums = new int [size][size];
        int indexRow = random.nextInt(size-1);
        int indexColumn = random.nextInt(size-1);
        System.out.println("indexRow: " + indexRow);
        System.out.println("indexColumn: " + indexColumn);


        System.out.println("Массив чисел");
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                nums[i][j] = random.nextInt(100);
                System.out.print(nums[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("Измененный массив чисел");
        for (int i = 0; i < size; i++){
            if (i == indexRow){
                continue;
            }
            for (int j = 0; j < size; j++){
                if (j == indexColumn) {
                    continue;
                }
                changedNums[i][j] = nums [i][j];
                System.out.print(changedNums[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
