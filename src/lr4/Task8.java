package lr4;

import java.util.Scanner;



//Напишите программу «Шифр Цезаря», которая зашифровывает введенный текст.
//Используете кодовую таблицу символов. При запуске программы в консоль
//необходимо вывести сообщение: «Введите текст для шифрования»,
//после ввода текста, появляется сообщение: «Введите ключ».
//После того как введены все данные, необходимо вывести
//преобразованную строку с сообщением «Текст после преобразования: ».
//Далее необходимо задать вопрос пользователю:
//«Выполнить обратное преобразование? (y/n)»,
//если пользователь вводит «y»,
//тогда выполнить обратное преобразование.
//Если пользователь вводит «n»,
//того программа выводит сообщение «До свидания!».
//Если пользователь вводит что-то другое,
//отличное от «y» или «n», то программа ему выводит сообщение:
//«Введите корректный ответ».


public class Task8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите текст для шифрования");
        String value = in.nextLine().toLowerCase().trim();

        System.out.println("Введите ключ для шифрования");
        int key = in.nextInt();
        in.nextLine();

        char [] chars = value.toCharArray();
        int [] ints = new int[value.length()];

        for(int i = 0; i < chars.length; i ++){
            ints[i] = chars[i] + key;
            chars[i] = (char) ints[i];
        }

        System.out.println("Текст после преобразования");
        for (char element : chars){
            System.out.print(element);
        }
        System.out.println(" ");

        while(true) {
            System.out.println("Выполнить обратное преобразование? (y/n)");
            String response = in.nextLine().toLowerCase().trim();
            if (response.equals("y")) {
                for (int i = 0; i < chars.length; i++) {
                    ints[i] = chars[i] - key;
                    chars[i] = (char) ints[i];
                }
                for (char element : chars){
                    System.out.print(element);
                }
                System.out.println(" ");
                break;
            } else if (response.equals("n")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Введите корректный ответ");
            }
        }
    }
}
