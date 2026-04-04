package lr7.task4;

//4.	Напишите программу, в которой использована цепочка наследования из трех классов.
//В первом классе есть открытое символьное поле. Во втором классе появляется открытое текстовое поле.
//В третьем классе появляется открытое целочисленное поле.
//В каждом из классов должен быть конструктор, позволяющий создавать объект
//на основе значений полей, переданных аргументами конструктору,
//а также конструктор создания копии.

class FirstClass {
    public char symbol;

    public FirstClass(char symbol) {
        this.symbol = symbol;
    }

    public FirstClass(FirstClass original){
        this.symbol = original.symbol;
    }

    @Override
    public String toString() {
        return "FirstClass{" +
                "symbol=" + symbol +
                '}';
    }
}

class SecondClass extends FirstClass {
    public String text;


    public SecondClass(char symbol, String text) {
        super(symbol);
        this.text = text;
    }

    public SecondClass(SecondClass original) {
        super(original);
        this.text = original.text;
    }

    @Override
    public String toString() {
        return "SecondClass{" +
                "text='" + text + '\'' +
                ", symbol=" + symbol +
                '}';
    }
}

class FinalClass extends SecondClass{
    public int num;

    public FinalClass(char symbol, String text, int num) {
        super(symbol, text);
        this.num = num;
    }

    public FinalClass(FinalClass original) {
        super(original);
        this.num = original.num;
    }

    @Override
    public String toString() {
        return "FinalClass{" +
                "num=" + num +
                ", text='" + text + '\'' +
                ", symbol=" + symbol +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Создание оригинальных объектов:");

        FirstClass original1 = new FirstClass('A');
        SecondClass original2 = new SecondClass('B', "Hello");
        FinalClass original3 = new FinalClass('C', "World", 100);

        System.out.println("original1: " + original1);
        System.out.println("original2: " + original2);
        System.out.println("original3: " + original3);

        System.out.println("\n2. Создание копий объектов:");

        FirstClass copy1 = new FirstClass(original1);
        SecondClass copy2 = new SecondClass(original2);
        FinalClass copy3 = new FinalClass(original3);

        System.out.println("copy1: " + copy1);
        System.out.println("copy2: " + copy2);
        System.out.println("copy3: " + copy3);

        System.out.println("\n3. Проверка, что это разные объекты:");
        System.out.println("original1 == copy1: " + (original1 == copy1));
        System.out.println("original2 == copy2: " + (original2 == copy2));
        System.out.println("original3 == copy3: " + (original3 == copy3));

        System.out.println("\n4. Проверка независимости копий:");

        original1.symbol = 'X';
        original2.symbol = 'Y';
        original2.text = "Changed";
        original3.symbol = 'Z';
        original3.text = "Modified";
        original3.num = 999;

        System.out.println("После изменения оригиналов:");
        System.out.println("original1: " + original1);
        System.out.println("copy1: " + copy1);
        System.out.println("original2: " + original2);
        System.out.println("copy2: " + copy2);
        System.out.println("original3: " + original3);
        System.out.println("copy3: " + copy3);
    }
}
