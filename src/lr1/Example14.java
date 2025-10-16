package lr1;

//Напишите программу, в которой пользователь вводит число,
//а программой отображается последовательность из четырех чисел:
//число, на единицу меньше введённого, введенное число и число, на единицу больше введенного.
//Четвертое число должно быть квадратом суммы первых трех чисел.


import java.util.Scanner;

public class Example14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число: ");
        int num = in.nextInt();
        int firstNum = num-1;
        int thirdNum = num+1;
        int fourthNum = (firstNum + num + thirdNum)*(firstNum + num + thirdNum);
        System.out.println(firstNum);
        System.out.println(num);
        System.out.println(thirdNum);
        System.out.println(fourthNum);
        in.close();
    }

}
