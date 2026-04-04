package lr5;

//Напишите программу с классом, в котором есть два закрытых целочисленных поля
//        (назовем их max и min).
//Значение поля max не может быть меньше значения поля min.
//Значения полям присваиваются с помощью открытого метода.
//Метод может вызываться с одним или двумя целочисленными аргументами.
//При вызове метода значения полям присваиваются так:
//сравниваются текущие значения полей и значения аргументов, переданных методу.
//Самое большое из значений присваивается полю max,
//а самое маленькое из значений присваивается полю min.
//        Предусмотрите конструктор, который работает по тому же принципу,
//что и метод для присваивания значений полям.
//В классе также должен быть метод, отображающий в консольном окне значения полей объекта.

class MyProgram6 {
    private int max;
    private int min;

    MyProgram6 (int value){
        this.max = value;
        this.min = value;
    }

    MyProgram6 (int value1, int value2){
        this.max = Math.max(value1, value2);
        this.min = Math.min(value1, value2);
    }

    public void setValue(int value){
        this.max = this.max < value ? value : this.max;
        this.min = this.min > value ? value : this.min;
    }

    public void setValue(int value1, int value2){
        int maxValue = Math.max(value1, value2);
        this.max = Math.max(this.max, maxValue);
        int minValue = Math.min(value1, value2);
        this.min = Math.min(minValue, this.min);
    }


    public void printValue(){
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }


}

public class Example6 {
    public static void main(String[] args) {
        MyProgram6 test = new MyProgram6(6, 9);
        MyProgram6 test1 = new MyProgram6(10);

        test.printValue();
        test.setValue(4);
        test.printValue();
        test.setValue(89, 3);
        test.printValue();

        test1.printValue();
        test1.setValue(7);
        test1.printValue();
        test1.setValue(56);
        test1.printValue();
        test1.setValue(0, 15);
        test1.printValue();
    }
}
