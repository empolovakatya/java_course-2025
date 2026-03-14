package lr9.task7;

//В кругу стоят N человек, пронумерованных от 1 до N. При ведении счета по кругу
//вычеркивается каждый второй человек, пока не останется один.
//Составить две программы, моделирующие процесс.
//Одна из программ должна использовать класс ArrayList, а вторая — LinkedList.
//Какая из двух программ работает быстрее? Почему?

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task7 {
    static int logic(List<Integer> list, int step) {
        int index = 0;
        while (list.size() > 1) {
            index = (index + step - 1) % list.size();
            list.remove(index);
            if (index == list.size()) index = 0;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int N = 100;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long start = System.nanoTime();
        int resultAL = logic(arrayList, 2);
        long timeAL = System.nanoTime() - start;

        start = System.nanoTime();
        int resultLL = logic(linkedList, 2);
        long timeLL = System.nanoTime() - start;

        System.out.println("ArrayList:  последний = " + resultAL + ", время = " + timeAL + " нс");
        System.out.println("LinkedList: последний = " + resultLL + ", время = " + timeLL + " нс");
        System.out.println("ArrayList быстрее для случайного доступа (O(1) get), LinkedList — для вставок/удалений в середине (O(1) remove с итератором).");

    }
}
