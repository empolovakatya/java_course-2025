package lr5;

//Напишите программу с классом, в котором есть закрытое символьное поле
//и три открытых метода. Один из методов позволяет присвоить значение полю.
//Еще один метод при вызове возвращает результатом код символа.
//Третий метод позволяет вывести в консольное окно символ (значение поля) и его код.

class Symbol{
    private char symbol;

    public void setSymbol(char s){
        symbol = s;
    }

    public int getSymbolCode(){
        return (int)  symbol;
    }

    public void printInfo(){
        System.out.println("Символ: " + symbol);
        System.out.println("Код символа: " + (int)symbol);
    }

}

public class Example1 {
    public static void main(String[] args) {
        Symbol symbol1 = new Symbol();
        symbol1.setSymbol('K');
        int code = symbol1.getSymbolCode();
        System.out.println(code);
        symbol1.printInfo();


    }
}
