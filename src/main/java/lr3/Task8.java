package lr3;

//Напишите программу, в которой создается символьный массив из 10 элементов.
//Массив заполнить большими (прописными) буквами английского алфавита.
//Буквы берутся подряд, но только согласные (то есть гласные буквы ’ А',1Е' и ' I'
//        при присваивании значений элементам массива нужно пропустить).
//Отобразите содержимое созданного массива в консольном окне.


import java.io.PrintWriter;

public class Task8 {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        int size = 10;
        int unicode = 66;
        char[] chars = new char[size];

        for (int i = 0; i < chars.length; i++){
            if (unicode == 69 || unicode == 73 || unicode == 79) {
                continue;
            }
            char a = (char) unicode;
            chars[i] = a;
            unicode += 2;
        }
        for (char element : chars) {
            out.print(element + " ");
        }
        out.flush();
    }
}
