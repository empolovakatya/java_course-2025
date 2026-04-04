package lr7.task5;

//5.	Напишите программу, в которой есть суперкласс с приватным текстовым полем,
//конструктор с текстовым параметром и метод, при вызове которого в консольном окне
//отображается название класса и значение поля. На основе суперкласса создаются два подкласса
//        (оба на основе одного и того же суперкласса).
//В одном из классов появляется защищенное целочисленное поле,
//там есть конструктор с двумя параметрами и переопределен метод
//для отображения значений полей объекта и названия класса.
//Во втором подклассе появляется защищенное символьное поле,
//конструктор с двумя параметрами и переопределен метод,
//отображающий в консоли название класса и значения полей.
//В главном методе создайте объекты каждого из классов.
//Проверьте работу метода, отображающего значения полей объектов,
//для каждого из объектов. Вызовите этот же метод через
//объектную переменную суперкласса, которая ссылается на объект производного класса.

class SuperClass {
    private String textField;

    public SuperClass(String text) {
        textField = text;
    }

    public void displayInfo () {
        System.out.println("Класс: SuperClass");
        System.out.println("text:" + textField);
    }

    public String getTextField() {
        return textField;
    }
}

class FirstSubClass extends SuperClass{
    protected int numberField;

    public FirstSubClass(String text, int number) {
        super(text);
        numberField = number;
    }

    @Override
    public void displayInfo () {
        System.out.println("Класс: FirstSubClass");
        System.out.println("text: " + getTextField());
        System.out.println("number: " + numberField);
    }
}

class SecondSubClass extends SuperClass{
    protected char symbolField;

    public SecondSubClass(String text, char symbol) {
        super(text);
        symbolField = symbol;
    }

    @Override
    public void displayInfo () {
        System.out.println("Класс: SecondSubClass");
        System.out.println("text: " + getTextField());
        System.out.println("char: " + symbolField);
    }
}

public class Main {
    public static void main(String[] args) {
        SuperClass superObj = new SuperClass("Текст суперкласса");
        FirstSubClass subObj1 = new FirstSubClass("Текст для 1 класса наследника", 42);
        SecondSubClass subObj2 = new SecondSubClass("Текст для 2 класса наследника", 'X');

        System.out.println("\nПрямой вызов методов");
        superObj.displayInfo();
        subObj1.displayInfo();
        subObj2.displayInfo();

        System.out.println("\nВызов через переменную суперкласса");
        SuperClass ref;
        ref = subObj1;
        ref.displayInfo();
        ref = subObj2;
        ref.displayInfo();
    }
}
