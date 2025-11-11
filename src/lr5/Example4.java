package lr5;

//Напишите программу с классом, у которого есть символьное и целочисленное поле.
//В классе должны быть описаны версии конструктора с двумя аргументами
//        (целое число и символ – определяют значения полей),
//а также с одним аргументом типа double.
//В последнем случае действительная часть аргумента определяет код символа
//        (значение символьного поля), а дробная часть (с учетом десятых и сотых)
//определяет значение целочисленного поля. Например, если аргументом передается
//число 65.1267, то значением символьного поля будет символ ‘A’ с годом 65,
//а целочисленное поле получит значение 12 (в дробной части учитываются только десятые и сотые).

class MyProgram4{
    char symbol;
    int number;

    MyProgram4(char symbol, int number){
        this.symbol = symbol;
        this.number = number;
    }

    MyProgram4(double number) {
        int charCode = (int) number;
        this.symbol = (char) charCode;

        double diff = number - charCode;
        this.number = (int) (diff * 100);
    }

    public void printValue(){
        System.out.println("Символ: " + symbol);
        System.out.println("Число: " + number);
    }

}

public class Example4 {
    public static void main(String[] args) {
        MyProgram4 test1 = new MyProgram4(65.1267);
        MyProgram4 test2 = new MyProgram4('N', 78);
        test1.printValue();
        test2.printValue();
    }
}
