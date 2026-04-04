package lr10.task5;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExcelReaderImproved {

    private static final String SHEET_NAME = "Товары";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Чтение Excel файла");

        boolean running = true;
        while (running) {
            System.out.print("\nВведите путь к файлу Excel (.xlsx): ");
            String filePath = scanner.nextLine().trim();

            boolean success = readFile(filePath);

            if (!success) {
                System.out.print("Попробовать ещё раз? (да/нет): ");
                String answer = scanner.nextLine().trim().toLowerCase();
                if (!answer.equals("да") && !answer.equals("д")) {
                    running = false;
                }
            } else {
                running = false;
            }
        }

        System.out.println("Программа завершена.");
    }

    private static boolean readFile(String filePath) {

        if (filePath.isEmpty()) {
            printError(
                    "Путь к файлу не указан.",
                    "Введите корректный путь, например: src/main/java/lr10/task5/example3.xlsx"
            );
            return false;
        }

        File file = new File(filePath);
        if (!file.exists()) {
            printError(
                    "Файл не найден: " + filePath,
                    "Убедитесь, что файл существует по указанному пути.\n" +
                            "  Совет: сначала запустите WriteExcelFileExample для создания файла."
            );
            return false;
        }

        if (!filePath.endsWith(".xlsx") && !filePath.endsWith(".xls")) {
            printError(
                    "Неверное расширение файла: " + filePath,
                    "Программа поддерживает только форматы .xlsx и .xls.\n" +
                            "  Убедитесь, что файл является таблицей Excel."
            );
            return false;
        }

        try (FileInputStream inputStream = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheet(SHEET_NAME);
            if (sheet == null) {
                System.err.println("\n[ОШИБКА] Лист «" + SHEET_NAME + "» не найден в файле.");
                System.err.println("  Доступные листы в файле:");
                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                    System.err.println("    - " + workbook.getSheetName(i));
                }
                System.err.println("  Рекомендация: проверьте название листа " +
                        "или измените константу SHEET_NAME в коде.");
                return false;
            }

            if (sheet.getPhysicalNumberOfRows() == 0) {
                printError(
                        "Лист «" + SHEET_NAME + "» пуст.",
                        "Убедитесь, что файл содержит данные."
                );
                return false;
            }

            System.out.println("\nЧтение листа «" + SHEET_NAME + "»...");
            System.out.println("=".repeat(60));

            int rowCount = 0;
            for (Row row : sheet) {
                for (Cell cell : row) {
                    System.out.print(getCellValue(cell) + "\t");
                }
                System.out.println();
                rowCount++;
            }

            System.out.println("=".repeat(60));
            System.out.println("Прочитано строк: " + rowCount);
            System.out.println("Файл успешно прочитан.");
            return true;

        } catch (IOException e) {
            printError(
                    "Ошибка чтения файла: " + e.getMessage(),
                    "Возможные причины:\n" +
                            "  - Файл открыт в другой программе (закройте Excel).\n" +
                            "  - Нет прав на чтение файла."
            );
        } catch (Exception e) {
            printError(
                    "Неизвестная ошибка: " + e.getMessage(),
                    "Убедитесь, что файл не повреждён и повторите попытку."
            );
        }

        return false;
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) return "";
        return switch (cell.getCellType()) {
            case STRING  -> cell.getStringCellValue();
            case NUMERIC -> {
                if (DateUtil.isCellDateFormatted(cell)) {
                    yield cell.getLocalDateTimeCellValue().toString();
                }
                double val = cell.getNumericCellValue();
                // Убираем лишний .0 у целых чисел
                yield (val == Math.floor(val))
                        ? String.valueOf((long) val)
                        : String.valueOf(val);
            }
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula();
            case BLANK   -> "";
            default      -> "НЕИЗВЕСТНЫЙ ТИП";
        };
    }

    private static void printError(String message, String recommendation) {
        System.err.println("\n[ОШИБКА] " + message);
        System.err.println("  Рекомендация: " + recommendation);
    }
}