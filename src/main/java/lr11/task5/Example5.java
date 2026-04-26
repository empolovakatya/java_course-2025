package lr11.task5;

// Напишите функцию, которая принимает на вход список строк и возвращает новый список,
// содержащий только те строки, которые содержат заданную подстроку.

import java.util.List;
import java.util.stream.Collectors;

public class Example5 {
    public static void main(String[] args) {
        String string = "Напишите функцию, Которая принимает на вход список " +
                "строк и возвращает новый список " +
                "Cодержащий только те строки, " +
                "которые содержат заданную подстроку";

        List<String> strings = List.of(string.split(" "));
        System.out.println("\n" + "Строка после сплита: " + "\n");
        for (String e : strings) {
            System.out.println(e);
        }

        String substring = "ок";
        List<String> stringsAfter = filterBySubstring(strings, substring);

        System.out.println("\n" + "Строки, содержащие подстроку \"" + substring + "\": " + "\n");
        for (String e : stringsAfter) {
            System.out.println(e);
        }
    }

    public static List<String> filterBySubstring(List<String> list, String substring) {
        return list.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }
}