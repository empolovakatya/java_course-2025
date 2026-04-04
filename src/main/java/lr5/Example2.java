package lr5;

//Напишите программу с классом, у которого есть два символьных поля и метод.
//Он возвращает результат, и у него нет аргументов.
//При вызове метод выводит в консольное окно все символы из кодовой таблицы,
//которые находятся «между» символами, являющимися значениями полей объекта
//        (из которого вызывается метод).
//Например, если полям объекта присвоены значения ‘A’ и ‘D’,
//то при вызове метода в консольное окно должны выводиться все символы от ‘A’ до ‘D’ включительно.

class Interval{
    private char symbol1;
    private char symbol2;

    public void setInterval(char first, char last){
        symbol1 = first;
        symbol2 = last;
    }

    public char[] getInterval() {
        int index1 = (int) symbol1;
        int index2 = (int) symbol2;
        int start = index1 < index2 ? index1 : index2;
        int end = index1 < index2 ? index2 : index1;
        char [] interval = new char [end - start + 1];
        for (int i = 0; i < interval.length; i++){
            interval[i] = (char) (i+start);
        }
        return interval;
    }
}

public class Example2 {
    public static void main(String[] args) {
        Interval interval = new Interval();
        interval.setInterval('A', 'D');
        for (char element : interval.getInterval()){
            System.out.print(element + " ");
        }
    }
}
