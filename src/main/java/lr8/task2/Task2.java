package lr8.task2;

import java.io.*;

//Задание 2. Создать проект, позволяющий из одного, предварительно созданного
// программными средствами файла, переписать данные, соответствующие условию -
// в исходном файле содержится две строки в формате UTF-8 и 5 чисел типа double.
// В результирующий файл переписать вторую строку и положительные числа.


public class Task2 {
    public static void main(String[] args) {
        String inputFile = "input_data.bin";
        String outputFile = "output_data.bin";

        try {
            // 1. Создание исходного файла с данными
            createInputFile(inputFile);
            System.out.println("Исходный файл создан: " + inputFile);

            // 2. Чтение исходного файла и фильтрация данных
            filterAndWriteData(inputFile, outputFile);
            System.out.println("Результирующий файл создан: " + outputFile);

            // 3. Вывод содержимого обоих файлов для проверки
            System.out.println("\n Содержимое исходного файла ");
            displayFileContent(inputFile);

            System.out.println("\n Содержимое результирующего файла ");
            displayFileContent(outputFile);

        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Создает исходный файл с двумя строками UTF-8 и 5 числами double
     */
    private static void createInputFile(String filename) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(filename)))) {

            // Запись двух строк в формате UTF-8
            dos.writeUTF("Первая строка - Java программирование");
            dos.writeUTF("Вторая строка - Лабораторная работа №8");

            // Запись 5 чисел типа double (положительные и отрицательные)
            double[] numbers = {3.14159, -2.71828, 1.61803, -0.57721, 2.30258};

            System.out.println("Записываемые числа:");
            for (double num : numbers) {
                dos.writeDouble(num);
                System.out.printf("  %.5f%n", num);
            }
        }
    }

    /**
     * Фильтрует данные: берет вторую строку и только положительные числа
     */
    private static void filterAndWriteData(String inputFile, String outputFile)
            throws IOException {

        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(inputFile)));

             DataOutputStream dos = new DataOutputStream(
                     new BufferedOutputStream(
                             new FileOutputStream(outputFile)))) {

            // Чтение и пропуск первой строки
            String firstLine = dis.readUTF();
            System.out.println("\nПропущена первая строка: \"" + firstLine + "\"");

            // Чтение второй строки и запись в выходной файл
            String secondLine = dis.readUTF();
            dos.writeUTF(secondLine);
            System.out.println("Записана вторая строка: \"" + secondLine + "\"");

            // Чтение 5 чисел double и фильтрация положительных
            System.out.println("\nФильтрация чисел:");
            int positiveCount = 0;

            for (int i = 0; i < 5; i++) {
                double number = dis.readDouble();

                if (number > 0) {
                    dos.writeDouble(number);
                    positiveCount++;
                    System.out.printf("  [✓] Положительное число записано: %.5f%n", number);
                } else {
                    System.out.printf("  [✗] Отрицательное число пропущено: %.5f%n", number);
                }
            }

            System.out.println("\nЗаписано положительных чисел: " + positiveCount);
        }
    }

    /**
     * Отображает содержимое файла (для проверки)
     */
    private static void displayFileContent(String filename) throws IOException {
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(filename)))) {

            try {
                // Пытаемся прочитать строку UTF-8
                String line = dis.readUTF();
                System.out.println("Строка: \"" + line + "\"");

                // Читаем числа double до конца файла
                System.out.print("Числа: ");
                while (true) {
                    try {
                        double num = dis.readDouble();
                        System.out.printf("%.5f ", num);
                    } catch (EOFException e) {
                        break; // Конец файла
                    }
                }
                System.out.println();

            } catch (EOFException e) {
                System.out.println("Файл пуст или имеет неверный формат");
            }
        }
    }
}
