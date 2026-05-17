package lr12;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

//Напишите функцию, которая находит максимальный элемент в массиве целых чисел при помощи многопоточности.
//Количество потоков должно быть равно количеству ядер процессора.

public class Task5 {
    public static int findMax(int[] arr) throws InterruptedException {
        int cores = Runtime.getRuntime().availableProcessors();
        int size = arr.length;
        int chunk = (size + cores - 1) / cores;

        int[] localMax = new int[cores];
        Arrays.fill(localMax, Integer.MIN_VALUE);

        Thread[] threads = new Thread[cores];

        for (int i = 0; i < cores; i++) {
            final int idx = i;
            final int from = i * chunk;
            final int to = Math.min(from + chunk, size);

            threads[i] = new Thread(() -> {
                for (int j = from; j < to; j++) {
                    if (arr[j] > localMax[idx]) localMax[idx] = arr[j];
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) t.join();

        int max = Integer.MIN_VALUE;
        for (int v : localMax) if (v > max) max = v;
        return max;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = new Random().ints(1_000_000, -100_000, 100_000).toArray();
        int max = findMax(arr);
        System.out.println("Ядер процессора: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Максимальный элемент: " + max);
        // Проверка через стандартный метод
        int expected = Arrays.stream(arr).max().getAsInt();
        System.out.println("Проверка (Arrays.stream): " + expected);
        System.out.println("Результат верный: " + (max == expected));
    }
}
