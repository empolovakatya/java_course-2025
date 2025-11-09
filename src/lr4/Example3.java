package lr4;

//Напишите программу, в которой создается двумерный массив, который выводи прямоугольник из цифр 2;

public class Example3 {
    public static void main(String[] args) {
        int length = 11;
        int width = 15;
        int [][] rectangle = new int[length][width];

        for (int i = 0; i < length; i++){
            for (int j = 0; j < width; j++){
                rectangle[i][j] = 2;
            }
        }

        for (int i = 0; i < length; i++){
            System.out.println(" ");
            for (int j = 0; j < width; j++){
                System.out.print(rectangle[i][j]);
            }
        }
    }
}
