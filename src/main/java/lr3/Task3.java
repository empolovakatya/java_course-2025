package lr3;

//Напишите программу, которая выводит последовательность чисел Фибоначчи.
//Первые два числа в этой последовательности равны 1,
//а каждое следующее число равно сумме двух предыдущих
// (получается последовательность 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 и так далее).
//Количество чисел в последовательности вводится пользователем.
//Предложите версии программы, использующие разные операторы цикла.

import java.io.PrintWriter;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int size = in.nextInt();
        int [] fibonacci = new int[size];

        fibonacci[0] = 1;
        fibonacci[1] = 1;

        for (int i=2; i<size; i++){
            fibonacci[i]=fibonacci[i-1]+fibonacci[i-2];
        }

        for (int number : fibonacci){
            out.print(number + " ");
        }
        out.flush();

    }
}
