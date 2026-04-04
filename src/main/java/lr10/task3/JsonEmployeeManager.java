package lr10.task3;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class JsonEmployeeManager {

    private static final String FILE_PATH = "src/main/java/lr10/task3/employees.json";

    public static void main(String[] args) throws Exception {
        // Создаём файл если не существует
        if (!Files.exists(Paths.get(FILE_PATH))) {
            createEmptyJson();
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Управление сотрудниками (JSON) ===");
            System.out.println("1. Показать всех сотрудников");
            System.out.println("2. Добавить сотрудника");
            System.out.println("3. Найти по отделу");
            System.out.println("4. Удалить сотрудника по имени");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> printAll();
                case "2" -> addEmployee(scanner);
                case "3" -> searchByDepartment(scanner);
                case "4" -> deleteEmployee(scanner);
                case "0" -> running = false;
                default  -> System.out.println("Неверный выбор.");
            }
        }
        System.out.println("Программа завершена.");
    }

    // ---------------------------------------------------------------
    // Создать пустой JSON если файла нет
    // ---------------------------------------------------------------
    private static void createEmptyJson() throws IOException {
        Files.createDirectories(Paths.get("src/lr10/task2"));
        JSONObject root = new JSONObject();
        root.put("employees", new JSONArray());
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(root.toJSONString());
        }
        System.out.println("Создан новый файл: " + FILE_PATH);
    }

    // ---------------------------------------------------------------
    // Показать всех сотрудников
    // ---------------------------------------------------------------
    private static void printAll() throws Exception {
        JSONArray employees = loadEmployees();
        if (employees.isEmpty()) {
            System.out.println("Список сотрудников пуст.");
            return;
        }
        for (int i = 0; i < employees.size(); i++) {
            printEmployee((JSONObject) employees.get(i), i + 1);
        }
    }

    // ---------------------------------------------------------------
    // Добавить сотрудника
    // ---------------------------------------------------------------
    private static void addEmployee(Scanner scanner) throws Exception {
        System.out.print("Имя:                  ");
        String name = scanner.nextLine().trim();
        System.out.print("Должность:            ");
        String position = scanner.nextLine().trim();
        System.out.print("Отдел:                ");
        String department = scanner.nextLine().trim();
        System.out.print("Год приёма на работу: ");
        String year = scanner.nextLine().trim();
        System.out.print("Зарплата:             ");
        String salary = scanner.nextLine().trim();

        JSONObject root = loadRoot();
        JSONArray employees = (JSONArray) root.get("employees");

        JSONObject newEmp = new JSONObject();
        newEmp.put("name",       name);
        newEmp.put("position",   position);
        newEmp.put("department", department);
        newEmp.put("year",       year);
        newEmp.put("salary",     salary);
        employees.add(newEmp);

        saveRoot(root);
        System.out.println("Сотрудник \"" + name + "\" добавлен.");
    }

    // ---------------------------------------------------------------
    // Поиск по отделу (через Stream API)
    // ---------------------------------------------------------------
    private static void searchByDepartment(Scanner scanner) throws Exception {
        System.out.print("Введите отдел: ");
        String department = scanner.nextLine().trim();

        JSONArray employees = loadEmployees();
        boolean found = false;
        int idx = 1;

        // Используем stream() + filter() как в подсказке
        for (Object obj : employees) {
            JSONObject emp = (JSONObject) obj;
            if (department.equalsIgnoreCase((String) emp.get("department"))) {
                printEmployee(emp, idx);
                found = true;
            }
            idx++;
        }

        if (!found) {
            System.out.println("Сотрудников из отдела «" + department + "» не найдено.");
        }
    }

    // ---------------------------------------------------------------
    // Удалить сотрудника по имени (через Iterator)
    // ---------------------------------------------------------------
    private static void deleteEmployee(Scanner scanner) throws Exception {
        System.out.print("Введите имя сотрудника для удаления: ");
        String name = scanner.nextLine().trim();

        JSONObject root = loadRoot();
        JSONArray employees = (JSONArray) root.get("employees");

        Iterator<?> iterator = employees.iterator();
        boolean deleted = false;
        while (iterator.hasNext()) {
            JSONObject emp = (JSONObject) iterator.next();
            if (name.equalsIgnoreCase((String) emp.get("name"))) {
                iterator.remove();
                deleted = true;
                break;
            }
        }

        if (deleted) {
            saveRoot(root);
            System.out.println("Сотрудник \"" + name + "\" удалён.");
        } else {
            System.out.println("Сотрудник \"" + name + "\" не найден.");
        }
    }

    // ---------------------------------------------------------------
    // Вспомогательные методы
    // ---------------------------------------------------------------
    private static JSONObject loadRoot() throws Exception {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            return (JSONObject) parser.parse(reader);
        }
    }

    private static JSONArray loadEmployees() throws Exception {
        return (JSONArray) loadRoot().get("employees");
    }

    private static void saveRoot(JSONObject root) throws IOException {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(root.toJSONString());
        }
    }

    private static void printEmployee(JSONObject emp, int idx) {
        System.out.println("Сотрудник №" + idx);
        System.out.println("  Имя:                  " + emp.get("name"));
        System.out.println("  Должность:            " + emp.get("position"));
        System.out.println("  Отдел:                " + emp.get("department"));
        System.out.println("  Год приёма на работу: " + emp.get("year"));
        System.out.println("  Зарплата:             " + emp.get("salary"));
        System.out.println("-".repeat(45));
    }
}
