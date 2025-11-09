package lr4;

//Напишите программу, которая выводить в консольное окно прямоугольник,
//размеры сторон которого, ширина: 23 колонки, высота: 11 строк;

public class Example1 {
    public static void main(String[] args) {
        int figure = 11;
        int i;
        int j;

        for (i=1; i <= figure; i++){
            System.out.println(" ");
            for (j = -12; j < figure; j++){
                System.out.print("*");
            }
        }
    }
}
