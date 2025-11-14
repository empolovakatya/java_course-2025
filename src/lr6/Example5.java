package lr6;

//Напишите программу со статическим методом,
//которым вычисляется сумма квадратов натуральных чисел 12 + 22 + 32 + ... + п2.
//Число п передается аргументом методу.
//Для проверки результата можно использовать формулу 12 + 22 +32+…+n2=(n+l) (2n + 1)/6

class SumOfSquares {
    public static int Calculate(int n) {
        int result = 0;
        while (n > 0){
            result += n*n;
            n--;
        }
        return result;
    }
}

public class Example5 {
    public static void main(String[] args) {
        System.out.println(SumOfSquares.Calculate(10)); // 385
    }
}
