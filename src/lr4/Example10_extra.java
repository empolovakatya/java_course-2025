package lr4;

//(дополнительная задача). Напишите программу «Шифр Цезаря»,
//в которой необходимо реализовать собственный алфавит,
//остальные условия идентичны задаче 8.


import java.util.Scanner;

public class Example10_extra {
    public static void main(String[] args) {
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char [] letters = alphabet.toCharArray();
        Scanner in = new Scanner(System.in);
        int index;

        System.out.println(letters.length);

        System.out.println("Введите текст для шифрования");
        String value = in.nextLine().toLowerCase().trim();

        System.out.println("Введите ключ для шифрования");
        int key = in.nextInt();
        in.nextLine();

        char [] chars = value.toCharArray();
        int [] ints = new int[value.length()];

        for(int i = 0; i < chars.length; i ++){
            ints[i] = chars[i] + key;
            for (int el : ints){
                if (el > letters.length){
                    index = el % letters.length;
//                    chars[i] = letters[index];
                } else if (el < 0) {
                    index = letters.length - el%letters.length;
//                    chars[i] = letters[index];
                } else {
                    index = el;
                }
                chars[i] = letters[index];
            }


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
                    ints[i] = letters[i] - key;
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
