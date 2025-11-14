package lr6;

//Напишите программу, в которой описан статический метод для вычисления двойного факториала числа,
//переданного аргументом методу. По определению, двойной факториал числа п (обозначается как n!!)
//    — это произведение через одно всех чисел, не больших числа п.
//То есть n!! = п * (n - 2) * (п - 4)* ...
//        (последний множитель равен 1 для нечетного п и равен 2 для четного n).
//Например, 6!! = 6 х 4 х 2 = 48 и 5!! = 5 х 3 х 1 = 15.

class DoubleFactorial {
    public static int calculate(int n) {
        int result = 1;
        if (n % 2 == 0) {
            while (n >= 2) {
                result *= n;
                n -= 2;
            }
        } else {
            while (n >= 1) {
                result *= n;
                n -= 2;
            }
        }
        return result;
    }
}


public class Example4 {
    public static void main(String[] args) {
        int result = DoubleFactorial.calculate(9);
        System.out.println(result); // 945
    }
}

