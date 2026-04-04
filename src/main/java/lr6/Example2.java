package lr6;

//Напишите программу с классом, в котором есть закрытое статическое целочисленное ноле
//с начальным нулевым значением. В классе должен быть описан статический метод,
//при вызове которого отображается текущее значение статического поля,
//после чего значение поля увеличивается на единицу.

class Counter {
    private static int number = 0;

    public static void getNumber(){
        System.out.println("Текущее значение: " + number);
        number++;
    }
}

public class Example2 {
    public static void main(String[] args) {
        Counter.getNumber();
        Counter.getNumber();
        Counter.getNumber();
    }


}
