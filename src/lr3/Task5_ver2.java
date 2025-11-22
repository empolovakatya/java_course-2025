package lr3;

//Напишите программу, в которой вычисляется сумма чисел, удовлетворяющих таким критериям:
//при делении числа на 5 в остатке получается 2, или при делении на 3 в остатке получается 1.
//Количество чисел в сумме вводится пользователем.
//Программа отображает числа, которые суммируются, и значение суммы.
//Предложите версии программы, использующие разные операторы цикла.


import java.io.PrintWriter;
import java.util.Scanner;

public class Task5_ver2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int amount = in.nextInt();
//        int number = 0;
        int sum = 0;
        int size = 0;

        for (int number = 0; size < amount; number++) {
            if (number % 5 == 2 || number % 3 == 1) {
                sum += number;
                size++;
                out.print(number + " ");
            }
        }

        out.println("Сумма чисел равна:" + sum);
        out.flush();
    }
}
