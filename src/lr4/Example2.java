package lr4;

//Напишите программу, которая выводит в консольное окно прямоугольный треугольник;


public class Example2 {
    public static void main(String[] args) {
        int figure = 11;
        int i;
        int j;
        int z = 1;

        for (i=1; i <= figure; i++){
            System.out.println(" ");
            for (j = 1; j <= z; j++){
                System.out.print("*");
            }
            z += 1;
        }
    }
}
