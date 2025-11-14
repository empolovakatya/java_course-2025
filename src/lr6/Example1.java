package lr6;
//
//Напишите программу с классом, в котором есть два поля: символьное и текстовое.
//В классе должен быть перегруженный метод для присваивания значений полям.
//Если метод вызывается с символьным аргументом,
//то соответствующее значение присваивается символьному полю.
//Если метод вызывается с текстовым аргументом, то он определяет значение текстового ноля.
//Методу аргументом также может передаваться символьный массив.
//Если массив состоит из одного элемента, то он определяет значение символьного поля.
//В противном случае (если в массиве больше одного элемента)
//из символов массива формируется текстовая строка и присваивается значением текстовому полю.

class MyClass1{
    private char symbol;
    private String text;

    public void setValue(char symbol){
        this.symbol = symbol;
    }

    public void setValue(String text){
        this.text = text;
    }

    public void setValue(char[] charArray) {
        if (charArray.length == 1){
            this.symbol = charArray[0];
        } else {
            this.text = new String(charArray);
        }
    }

    public void printValue(){
        System.out.println("Символ: " + symbol);
        System.out.println("Текст: " + text);
    }
}

public class Example1 {
    public static void main(String[] args) {
        MyClass1 test = new MyClass1();
        test.setValue('g');
        test.printValue();
        test.setValue("Тест");
        test.printValue();
        char[] symbol = {'U'};
        char[] sentence = {'T', 'e', 's', 't', ' ', 's', 't', 'r', 'i', 'n', 'g'};
        test.setValue(sentence);
        test.printValue();
        test.setValue(symbol);
        test.printValue();
    }

}
