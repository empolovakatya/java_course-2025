package lr4;

//Напишите программу, в которой создается двумерный числовой массив
//и этот массив заполняется «змейкой»:
//сначала первая строка (слева направо), затем последний столбец (сверху вниз),
//вторая строка (справа налево) и так далее, как показано на рисунке:

public class Example7 {
    public static void main(String[] args) {
        int size = 10;
        int[][] nums = new int[size][size];

        System.out.println("Массив чисел");
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < size; j++) {
                    nums[i][j] = j;
                    System.out.print(nums[i][j] + " ");
                }
            } else {
                for (int j = size - 1; j >= 0; j--) {
                    nums[i][j] = j;
                    System.out.print(nums[i][j] + " ");
                }
            }
            System.out.println(" ");
        }
    }
}
