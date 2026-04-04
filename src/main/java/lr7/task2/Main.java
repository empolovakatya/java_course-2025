package lr7.task2;

//2.	Напишите программу, в которой есть суперкласс с приватным текстовым полем.
//В базовом классе (суперклассе) должен быть метод для присваивания значения полю
//с текстовым параметром. Объект суперкласса создается передачей одного текстового аргумента
//        конструктору. Добавьте метод, который возвращает длину текстовой строки.
//На основе суперкласса создается подкласс. В подклассе появляется дополнительное открытое
//        (публичное) целочисленное поле. В классе должны быть такие версии метода
//для присваивания значений полям (используется переопределение и перегрузка метода из суперкласса):
//        без параметров, с текстовым параметром, с целочисленным параметром,
//с текстовым и целочисленным параметром.
//У конструктора подкласса два параметра (целочисленный и текстовый).

class SuperClassText{
    private String value;

    public SuperClassText(String text) {
        value = text;
    }

    public void setValue(String text) {
        value = text;
    }

    public String getValue() {
        return value;
    }

    public int getLength(){
        return value.length();
    }
}


class SubClassTextAndNum extends SuperClassText {
    public int num;

    public SubClassTextAndNum(String text, int num) {
        super(text);
        this.num = num;
    }

    @Override
    public void setValue(String text) {
        super.setValue(text);
    }

    public void setValue(int num) {
        this.num = num;
    }

    public void setValue() {
        this.num = 0;
        super.setValue("");
    }

    public void setValue(String text, int num) {
        this.num = num;
        super.setValue(text);
    }

    public void printInfo() {
        System.out.println("Text: '" + getValue() + "', Number: " + num + ", Text length: " + getLength());
    }
}


public class Main {
    public static void main(String[] args) {

        SuperClassText superObj = new SuperClassText("Hello");
        System.out.println("Исходный текст: '" + superObj.getValue() + "'");
        System.out.println("Длина текста: " + superObj.getLength());

        superObj.setValue("Hello World");
        System.out.println("После изменения: '" + superObj.getValue() + "'");
        System.out.println("Новая длина: " + superObj.getLength());

        SubClassTextAndNum subObj = new SubClassTextAndNum("Test", 10);
        System.out.println("Создан объект:");
        subObj.printInfo();

        System.out.println("\n--- Тест setValue() без параметров ---");
        subObj.setValue();
        subObj.printInfo();

        System.out.println("\n--- Тест setValue(String) ---");
        subObj.setValue("New Text");
        subObj.printInfo();

        System.out.println("\n--- Тест setValue(int) ---");
        subObj.setValue(42);
        subObj.printInfo();

        System.out.println("\n--- Тест setValue(String, int) ---");
        subObj.setValue("Final Text", 100);
        subObj.printInfo();


        SuperClassText polyObj = new SubClassTextAndNum("Polymorphism", 123);
        System.out.println("Текст через ссылку суперкласса: '" + polyObj.getValue() + "'");
        System.out.println("Длина текста: " + polyObj.getLength());
    }
}
