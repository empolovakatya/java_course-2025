package lr11.task7;

// Напишите функцию, которая принимает на вход список строк и возвращает новый список,
// содержащий только те строки, которые имеют длину больше заданного значения.

import java.util.List;
import java.util.stream.Collectors;

public class Example7 {
    public static void main(String[] args) {
        String string = "Напишите функцию, которая принимает на вход список " +
                "строк и возвращает новый список " +
                "содержащий только те строки, " +
                "которые имеют длину больше заданного значения";

        List<String> strings = List.of(string.split(" "));
        System.out.println("\n" + "Строка после сплита: " + "\n");
        for (String e : strings) {
            System.out.println("\"" + e + "\" - длина: " + e.length());
        }

        int minLength = 5;
        List<String> stringsAfter = filterByMinLength(strings, minLength);

        System.out.println("\n" + "Строки с длиной больше " + minLength + ": " + "\n");
        for (String e : stringsAfter) {
            System.out.println("\"" + e + "\" - длина: " + e.length());
        }

        // Дополнительный пример с другим значением
        int minLength2 = 7;
        List<String> stringsAfter2 = filterByMinLength(strings, minLength2);

        System.out.println("\n" + "Строки с длиной больше " + minLength2 + ": " + "\n");
        for (String e : stringsAfter2) {
            System.out.println("\"" + e + "\" - длина: " + e.length());
        }
    }

    public static List<String> filterByMinLength(List<String> list, int minLength) {
        return list.stream()
                .filter(s -> s.length() > minLength)
                .collect(Collectors.toList());
    }
}