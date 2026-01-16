package lr8.task3;
//Задание 3. Создать проект, позволяющий из одного текстового файла,
// содержащего несколько строк (тип String) заранее подготовленного текста
// на русском языке (Пушкин, Лермонтов или другой российский классик на Ваш вкус),
// построчно переписать в другой текстовый файл слова начинающиеся с согласных букв.
//        Требования:
//        –	слова из предложения выделять методом split();
//–	в новом файле следует указать номер строки, в которой искомые слова находились в исходном файле;
//–	для каждой строки указать количество выбранных слов.

import java.io.*;
import java.util.regex.Pattern;

public class Task3 {
    // Паттерн для согласных букв русского алфавита
    private static final Pattern CONSONANT_PATTERN = Pattern.compile(
            "^[бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ]",
            Pattern.UNICODE_CASE);

    public static void main(String[] args) {
        String inputFile = "pushkin.txt";
        String outputFile = "result.txt";

        try {
            // 1. Создаем файл с текстом Пушкина
            createTextFile(inputFile);
            System.out.println("Создан файл с текстом: " + inputFile);

            // 2. Обрабатываем текст и сохраняем результат
            processTextFile(inputFile, outputFile);
            System.out.println("Результат сохранен в: " + outputFile);

            // 3. Выводим содержимое обоих файлов
            System.out.println("\nИсходный текст");
            displayFile(inputFile);

            System.out.println("\nРезультат обработки");
            displayFile(outputFile);

        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Создает файл с текстом Пушкина
     */
    private static void createTextFile(String filename) throws IOException {
        String[] pushkinText = {
                "У лукоморья дуб зелёный;",
                "Златая цепь на дубе том:",
                "И днём и ночью кот учёный",
                "Всё ходит по цепи кругом;",
                "Идёт направо — песнь заводит,",
                "Налево — сказку говорит.",
                "Там чудеса: там леший бродит,",
                "Русалка на ветвях сидит;",
                "Там на неведомых дорожках",
                "Следы невиданных зверей;",
                "Избушка там на курьих ножках",
                "Стоит без окон, без дверей;",
                "Там лес и дол видений полны;",
                "Там о заре прихлынут волны",
                "На брег песчаный и пустой,",
                "И тридцать витязей прекрасных",
                "Чредой из вод выходят ясных,",
                "И с ними дядька их морской;",
                "Там королевич мимоходом",
                "Пленяет грозного царя;",
                "Там в облаках перед народом",
                "Через леса, через моря",
                "Колдун несёт богатыря;",
                "В темнице там царевна тужит,",
                "А бурый волк ей верно служит;",
                "Там ступа с Бабою Ягой",
                "Идёт, бредёт сама собой,",
                "Там царь Кащей над златом чахнет;",
                "Там русский дух… там Русью пахнет!",
                "И там я был, и мёд я пил;",
                "У моря видел дуб зелёный;",
                "Под ним сидел, и кот учёный",
                "Свои мне сказки говорил."
        };

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(filename), "UTF-8"))) {

            for (String line : pushkinText) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    /**
     * Обрабатывает текст: находит слова, начинающиеся с согласных
     */
    private static void processTextFile(String inputFile, String outputFile)
            throws IOException {

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(inputFile), "UTF-8"));

             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(
                             new FileOutputStream(outputFile), "UTF-8"))) {

            String line;
            int lineNumber = 0;
            int totalWords = 0;

            writer.write("СЛОВА, НАЧИНАЮЩИЕСЯ С СОГЛАСНЫХ БУКВ\n");
            writer.write("=".repeat(60) + "\n\n");

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String[] words = extractWords(line);

                if (words.length > 0) {
                    StringBuilder consonantWords = new StringBuilder();
                    int consonantCount = 0;

                    for (String word : words) {
                        if (startsWithConsonant(word)) {
                            consonantCount++;
                            consonantWords.append(word).append(" ");
                        }
                    }

                    if (consonantCount > 0) {
                        writer.write("Строка " + lineNumber + ":\n");
                        writer.write("  Текст: \"" + line + "\"\n");
                        writer.write("  Слова: " + consonantWords.toString().trim() + "\n");
                        writer.write("  Количество: " + consonantCount + " слов(о)\n");
                        writer.write("-".repeat(40) + "\n");

                        totalWords += consonantCount;
                        System.out.printf("Строка %2d: найдено %d слов%n",
                                lineNumber, consonantCount);
                    }
                }
            }

            writer.write("\n" + "=".repeat(60) + "\n");
            writer.write("ИТОГО:\n");
            writer.write("  Обработано строк: " + lineNumber + "\n");
            writer.write("  Найдено слов, начинающихся с согласных: " + totalWords + "\n");
            writer.write("=".repeat(60) + "\n");

            System.out.println("\nВсего найдено слов: " + totalWords);
        }
    }

    /**
     * Извлекает слова из строки с помощью split()
     */
    private static String[] extractWords(String line) {
        // Удаляем знаки препинания и разбиваем по пробелам
        String cleaned = line.replaceAll("[.,;:!?—…\"]", "");
        return cleaned.split("\\s+");
    }

    /**
     * Проверяет, начинается ли слово с согласной буквы
     */
    private static boolean startsWithConsonant(String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        return CONSONANT_PATTERN.matcher(word).find();
    }

    /**
     * Отображает содержимое файла
     */
    private static void displayFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filename), "UTF-8"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}