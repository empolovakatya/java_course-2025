package lr9.task6;

import java.util.HashMap;
import java.util.Map;

//Заполнить HashMap 10 объектами <Integer, String>. Найти строки у которых ключ> 5.
//        Если ключ = 0, вывести строки через запятую. Перемножить все ключи, где длина строки>5.
public class Task6 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "hello");
        map.put(1, "world");
        map.put(2, "java");
        map.put(3, "programming");
        map.put(4, "hi");
        map.put(5, "code");
        map.put(6, "lambda");
        map.put(7, "stream");
        map.put(8, "collections");
        map.put(9, "framework");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey() > 5) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }

        if (map.containsKey(0)){
            System.out.println(String.join(", ", map.values()));
        }

        int product = 1;
        int count = 0;
        for (Map.Entry<Integer, String> entry: map.entrySet()) {
            if (entry.getValue().length() > 5) {
                product *= entry.getKey();
                count++;
            }
        }
        if (count > 0) {
            System.out.println("\nПроизведение ключей (длина строки > 5): " + product);
            System.out.println("Количество учтенных элементов: " + count);
        } else {
            System.out.println("\nНет элементов с длиной строки > 5");
        }

    }
}
