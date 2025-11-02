package lr3;

//Напишите программу, в которой создается одномерный символьный массив
//из 10 элементов. Массив заполняется буквами «через одну»,
//начиная с буквы ' а ': то есть массив заполняется буквами 'а', 'с', ' е', 'д' и так далее.
//Отобразите массив в консольном окне в прямом и обратном порядке.
//Размер массива задается переменной.

import java.io.PrintWriter;

public class Example7 {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        int size = 10;
        int unicode = 97;
        char[] chars = new char[size];

        for (int i = 0; i < chars.length; i++){
            char a = (char) unicode;
            chars[i] = a;
            unicode += 2;
        }
        for (char element : chars) {
            out.print(element + " ");
        }
        for (int i = 9; i >= 0; i--){
            out.print(chars[i] + " ");
        }

        out.flush();
    }
}
