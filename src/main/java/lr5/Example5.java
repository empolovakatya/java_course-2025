package lr5;

//Напишите программу с классом, у которого есть закрытое целочисленное поле.
//Значение полю присваивается с помощью открытого метода.
//Методу аргументом может передаваться целое число, а также метод может вызываться без аргументов.
//Если методы вызывается без аргументов, то поле получает нулевое значение.
//Если метод вызывается с целочисленным аргументом, то это значение присваивается полю.
//Однако если переданное аргументом методу значение превышает 100,
//то значением полю присваивается число 100.
//Предусмотрите в классе конструктор,
//который работает по тому же принципу что и метод для присваивания значения полю.
//Также в классе должен быть метод, позволяющий проверить значение поля.

class MyProgram5{
    private int number;

    MyProgram5 (){
        this.number = 0;
    }

    MyProgram5 (int number) {
        if (number <= 100) {
            this.number = number;
        } else {
            this.number = 100;
        }
    }


    public void setNumber(){
        this.number = 0;
    }

    public void setNumber(int number){
        if (number <= 100) {
            this.number = number;
        } else {
            this.number = 100;
        }
    }

    public void printValue(){
        System.out.println("Число: " + number);
    }

}


public class Example5 {
    public static void main(String[] args) {
        MyProgram5 number = new MyProgram5();
        MyProgram5 number1 = new MyProgram5(8);
        MyProgram5 number2 = new MyProgram5(150);

        number.printValue();
        number1.printValue();
        number2.printValue();

        number.setNumber(98);
        number1.setNumber(4);
        number2.setNumber();

        number.printValue();
        number1.printValue();
        number2.printValue();
    }
}
