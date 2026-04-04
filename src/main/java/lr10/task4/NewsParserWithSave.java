package lr10.task4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NewsParserWithSave {

    private static final String URL         = "http://fat.urfu.ru/index.html";
    private static final String FILE_PATH   = "src/main/java/lr10/task4/news.txt";
    private static final int    MAX_RETRIES = 3;
    private static final int    TIMEOUT_MS  = 10_000;

    public static void main(String[] args) {
        Document doc = null;

        // Попытка подключения с повтором при ошибке
        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                System.out.println("Попытка подключения " + attempt + " из " + MAX_RETRIES + "...");
                doc = Jsoup.connect(URL)
                        .userAgent("Mozilla/5.0")
                        .timeout(TIMEOUT_MS)
                        .get();
                System.out.println("Подключение успешно!");
                break;

            } catch (IOException e) {
                System.err.println("Ошибка подключения (попытка " + attempt + "): " + e.getMessage());

                if (attempt == MAX_RETRIES) {
                    System.err.println("Все попытки исчерпаны. Программа завершается.");
                    return;
                }

                System.out.println("Повторная попытка через 2 секунды...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        List<String> results = new ArrayList<>();
        String header = "=".repeat(50) + "\n"
                + "Сайт: " + URL + "\n"
                + "Дата парсинга: " + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))
                + "\n" + "=".repeat(50);

        System.out.println(header);
        results.add(header);

        try {
            Elements newsParent = doc
                    .select("body > table > tbody > tr > td > div > table > " +
                            "tbody > tr:nth-child(5) > td:nth-child(3) > table > tbody > " +
                            "tr > td:nth-child(1)");

            for (int i = 3; i < 20; i++) {
                if (!(i % 2 == 0)) {
                    List<Node> nodes = newsParent.get(0).childNodes();

                    String topic = ((Element) nodes.get(i))
                            .getElementsByClass("blocktitle")
                            .get(0).childNodes().get(0).toString();

                    String date = ((Element) nodes.get(i))
                            .getElementsByClass("blockdate")
                            .get(0).childNodes().get(0).toString();

                    String topicLine = "Тема : " + topic;
                    String dateLine  = "Дата : " + date;

                    System.out.println(topicLine);
                    System.out.println(dateLine);
                    System.out.println();

                    results.add(topicLine);
                    results.add(dateLine);
                    results.add("");
                }
            }

        } catch (Exception e) {
            String errorMsg = "Ошибка при парсинге страницы: " + e.getMessage();
            System.err.println(errorMsg);
            results.add(errorMsg);
        }

        // Сохранение результатов в файл
        saveToFile(results);
    }

    private static void saveToFile(List<String> lines) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
            System.out.println("Результаты сохранены в файл: " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Ошибка сохранения файла: " + e.getMessage());
        }
    }
}