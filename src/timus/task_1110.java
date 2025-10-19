package timus;

//Даны целые числа N, M и Y. Напишите программу, которая найдёт все целые числа X в диапазоне [0, M – 1], такие что X^N mod M = Y.
//        Исходные данные
//Ввод содержит единственную строку с числами N, M и Y (0 < N < 999, 1 < M < 999, 0 < Y < 999), записанными через пробел.
//Результат
//Выведите все числа X через пробел в одной строке. Числа должны идти в порядке возрастания. Если искомых чисел нет, выведите −1.
//Пример
//исходные данные	результат
//2 6 4
//        2 4


import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class task_1110 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        BigInteger n = in.nextBigInteger();
        BigInteger m = in.nextBigInteger();
        BigInteger y = in.nextBigInteger();
        BigInteger base = BigInteger.valueOf(0);
        int[] numbers = new int[m.intValue()];
        int j = 0;
        boolean check = false;

        for (int i = 0; i < numbers.length; i++){
            BigInteger result = base.modPow(n,m);
            base = base.add(BigInteger.ONE);
            if (result.equals(y)){
                numbers[j] = i;
                j += 1;
                check = true;
            }
        }
        if (check) {
            for (int number : numbers) {
                if (number == 0) {
                    break;
                }
                System.out.print(number + " ");
            }
        } else {
            j = -1;
            System.out.println(j);
        }
        out.flush();
    }
}
