package lr7.task3;

//3.	Напишите программу, в которой на основе суперкласса создается подкласс,
//а на основе этого подкласса создается еще один подкласс (цепочка наследования из трех классов).
//В первом суперклассе есть открытое целочисленное поле,
//метод с одним параметром для присваивания значения полю и
//конструктор с одним параметром. Во втором классе появляется открытое символьное поле,
//метод с двумя параметрами для присваивания значения полям (перегрузка метода из суперкласса)
//и конструктор с двумя параметрами. В третьем классе появляется открытое текстовое ноле,
//метод с тремя аргументами для присваивания значений полям (перегрузка метода из суперкласса)
//и конструктор с тремя параметрами. Для каждого класса определите метод toString () так,
//чтобы он возвращал строку с названием класса и значениями всех полей объекта.

class NumberField {
    public int number;

    public void setValue(int number) {
        this.number = number;
    }

    public NumberField(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "NumberField{" +
                "number=" + number +
                '}';
    }
}

class NumberAndSymbol extends NumberField {
    public char symbol;

    public NumberAndSymbol(int number, char symbol) {
        super(number);
        this.symbol = symbol;
    }

    public void setValue(int number, char symbol) {
        super.setValue(number);
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "NumberAndSymbol{" +
                "symbol=" + symbol +
                ", number=" + number +
                '}';
    }
}

class FinalClass extends NumberAndSymbol{
    public String text;


    public FinalClass(int number, char symbol, String text) {
        super(number, symbol);
        this.text = text;
    }

    public void setValue(int number, char symbol,String text) {
        super.setValue(number);
        super.setValue(symbol);
        this.text = text;
    }

    @Override
    public String toString() {
        return "FinalClass{" +
                "text='" + text + '\'' +
                ", symbol=" + symbol +
                ", number=" + number +
                '}';
    }
}


public class Main {
    public static void main(String[] args) {

        NumberField obj1 = new NumberField(10);
        NumberAndSymbol obj2 = new NumberAndSymbol(20, 'A');
        FinalClass obj3 = new FinalClass(30, 'B', "Hello");

        System.out.println("\n1. Объект NumberField:");
        System.out.println(obj1.toString());

        System.out.println("\n2. Объект NumberAndSymbol:");
        System.out.println(obj2.toString());

        System.out.println("\n3. Объект FinalClass:");
        System.out.println(obj3.toString());
    }
}
