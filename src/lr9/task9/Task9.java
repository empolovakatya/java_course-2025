package lr9.task9;

import java.util.*;

//Необходимо произвести вычисление времени работы нижеперечисленных операций,
//количество элементов коллекциях и сами коллекции указаны в индивидуальном варианте.
//После выполнения вычислений необходимо заполнить таблицы и привести скриншоты кода программы
//и данных вывода в консоль.

public class Task9 {

    static long measureAdd(List<Integer> list, int n, String position) {
        list.clear();
        for (int i = 0; i < n; i++) list.add(i);
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            switch (position) {
                case "start"  -> list.add(0, i);
                case "end"    -> list.add(i);
                case "middle" -> list.add(list.size() / 2, i);
            }
        }
        return System.currentTimeMillis() - start;
    }

    static long measureRemove(List<Integer> list, int n, String position) {
        list.clear();
        for (int i = 0; i < n * 2; i++) list.add(i);
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            if (list.isEmpty()) break;
            switch (position) {
                case "start"  -> list.remove(0);
                case "end"    -> list.remove(list.size() - 1);
                case "middle" -> list.remove(list.size() / 2);
            }
        }
        return System.currentTimeMillis() - start;
    }

    static long measureGet(List<Integer> list, int n) {
        for (int i = 0; i < n; i++) list.add(i);
        Random rnd = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) list.get(rnd.nextInt(list.size()));
        return System.currentTimeMillis() - start;
    }

    public static void main(String[] args) {
        int N = 8_000_000; // вариант 8 * 1 000 000

        List<Integer> arrayList = new ArrayList<>();

        System.out.println("N = " + N);
        System.out.printf("%-30s | ArrayList%n", "Операция");
        System.out.println("-".repeat(45));
        System.out.printf("%-30s | %d мс%n", "Добавление в начало",   measureAdd(arrayList, N / 100, "start"));
        System.out.printf("%-30s | %d мс%n", "Добавление в конец",    measureAdd(arrayList, N, "end"));
        System.out.printf("%-30s | %d мс%n", "Добавление в середину", measureAdd(arrayList, N / 100, "middle"));
        System.out.printf("%-30s | %d мс%n", "Удаление с начала",     measureRemove(arrayList, N / 100, "start"));
        System.out.printf("%-30s | %d мс%n", "Удаление с конца",      measureRemove(arrayList, N / 100, "end"));
        System.out.printf("%-30s | %d мс%n", "Удаление из середины",  measureRemove(arrayList, N / 100, "middle"));
        System.out.printf("%-30s | %d мс%n", "Получение по индексу",  measureGet(arrayList, N / 10));

        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> sortedSet = new TreeSet<>();

        long start, end;

        System.out.println("\n=== HashSet vs SortedSet (TreeSet) — добавление N элементов ===");
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) hashSet.add(i);
        System.out.println("HashSet add:    " + (System.currentTimeMillis() - start) + " мс");

        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) sortedSet.add(i);
        System.out.println("SortedSet add:  " + (System.currentTimeMillis() - start) + " мс");

        System.out.println("\n=== Удаление N элементов ===");
        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) hashSet.remove(i);
        System.out.println("HashSet remove:   " + (System.currentTimeMillis() - start) + " мс");

        start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) sortedSet.remove(i);
        System.out.println("SortedSet remove: " + (System.currentTimeMillis() - start) + " мс");
    }
}