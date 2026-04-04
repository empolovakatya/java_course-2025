package lr6;

//Напишите программу со статическим методом,
//аргументом которому передастся символьный массив,
//а результатом возвращается ссылка на целочисленным массив,
//состоящий из кодов символов из массива- аргумента.

import java.util.Arrays;

class SymbolToInt {
    public static int[] Convert (char [] symbols){
        int [] result = new int[symbols.length];
        int i = 0;
        for (char symbol : symbols) {
            result [i] = symbol;
            i++;
        }
        return result;
    }
}

public class Example7 {
    public static void main(String[] args) {
        char [] symbols = new char[]{'a', 'b', 'c'};
        int [] numbers = SymbolToInt.Convert(symbols);
        System.out.println(Arrays.toString(numbers));
    }
}
