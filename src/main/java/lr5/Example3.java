package lr5;

//Напишите программу с классом, у которого есть два целочисленных поля.
//В классе должны быть описаны конструкторы, позволяющие создавать объекты без передачи аргументов,
//с передачей одного аргумента и с передачей двух аргументов.

class Numbers{
    private int number1;
    private int number2;

    public Numbers(){
        number1 = 0;
        number2 = 0;
    }

    public Numbers(int n){
        number1 = n;
        number2 = n;
    }

    public Numbers(int n1, int n2){
        number1 = n1;
        number2 = n2;
    }

    public void printValues(){
        System.out.println("Number 1: " + number1 + ", Number 2: " + number2);
    }

}


public class Example3 {
    public static void main(String[] args) {
        Numbers numbers = new Numbers();
        numbers.printValues();
        Numbers numbers1 = new Numbers(6);
        numbers1.printValues();
        Numbers numbers2 = new Numbers(2, 10);
        numbers2.printValues();

    }
}
