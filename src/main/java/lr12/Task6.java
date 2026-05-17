package lr12;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

//Напишите функцию, которая суммирует элементы в массиве целых чисел при помощи многопоточности.
//Количество потоков должно быть равно количеству ядер процессора.

public class Task6 {
    public static long sumArray(int[] arr) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        int size = arr.length;
        int chunk = (size + cores - 1) / cores;

        AtomicLong totalSum = new AtomicLong(0);
        Thread[] threads = new Thread[cores];

        for (int i = 0; i < cores; i++) {
            final int from = i * chunk;
            final int to = Math.min(from + chunk, size);

            threads[i] = new Thread(() -> {
                long localSum = 0;
                for (int j = from; j < to; j++) localSum += arr[j];
                totalSum.addAndGet(localSum);
            });
            threads[i].start();
        }

        for (Thread t : threads) t.join();
        return totalSum.get();
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = new Random().ints(1_000_000, -1000, 1000).toArray();
        long sum = sumArray(arr);
        System.out.println("Ядер процессора: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Сумма элементов (многопоточно): " + sum);
        // Проверка
        long expected = 0;
        for (int v : arr) expected += v;
        System.out.println("Проверка (обычный цикл): " + expected);
        System.out.println("Результат верный: " + (sum == expected));
    }
}
