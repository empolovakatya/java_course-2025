package lr4;

//Напишите программу, в которой создается двумерный массив, который выводит прямоугольный треугольник;

public class Task4 {
    public static void main(String[] args) {
        int figure = 11;
        int z = 1;
        char [][] triangle = new char [figure][figure];

        for (int i = 0; i < figure; i++){
            for (int j = 0; j < z; j++){
                triangle[i][j] = '*';
            }
            z += 1;
        }

        for (int i = 0; i < figure; i++){
            for (int j = 0; j < figure; j++){
                if (triangle[i][j] == '*') {
                    System.out.print(triangle[i][j]);
                }
            }
            System.out.println(" ");
        }
    }

}
