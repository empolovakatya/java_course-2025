package lr10.task2;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.*;
import java.util.stream.*;

public class XmlEmployeeManager {

    private static final String FILE_PATH = "src/main/java/lr10/task2/employees.xml";

    public static void main(String[] args) throws Exception {
        // Создаём файл если не существует
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            createEmptyXml(file);
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nУправление сотрудниками (XML)");
            System.out.println("1. Показать всех сотрудников");
            System.out.println("2. Добавить сотрудника");
            System.out.println("3. Найти по отделу");
            System.out.println("4. Найти по году приёма на работу");
            System.out.println("5. Удалить сотрудника по имени");
            System.out.println("0. Выход");
            System.out.print("Выберите пункт: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> printAll();
                case "2" -> addEmployee(scanner);
                case "3" -> searchByDepartment(scanner);
                case "4" -> searchByYear(scanner);
                case "5" -> deleteEmployee(scanner);
                case "0" -> running = false;
                default  -> System.out.println("Неверный выбор.");
            }
        }
        System.out.println("Программа завершена.");
    }

    private static void createEmptyXml(File file) throws Exception {
        file.getParentFile().mkdirs();
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.newDocument();
        doc.appendChild(doc.createElement("employees"));
        saveDocument(doc);
        System.out.println("Создан новый файл: " + FILE_PATH);
    }

    private static void printAll() throws Exception {
        Document doc = loadDocument();
        NodeList list = doc.getElementsByTagName("employee");
        if (list.getLength() == 0) {
            System.out.println("Список сотрудников пуст.");
            return;
        }
        for (int i = 0; i < list.getLength(); i++) {
            printEmployee((Element) list.item(i), i + 1);
        }
    }

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

        Document doc = loadDocument();
        Element emp = doc.createElement("employee");
        addChild(doc, emp, "name",       name);
        addChild(doc, emp, "position",   position);
        addChild(doc, emp, "department", department);
        addChild(doc, emp, "year",       year);
        addChild(doc, emp, "salary",     salary);
        doc.getDocumentElement().appendChild(emp);

        saveDocument(doc);
        System.out.println("Сотрудник \"" + name + "\" добавлен.");
    }


    private static void searchByDepartment(Scanner scanner) throws Exception {
        System.out.print("Введите отдел: ");
        String department = scanner.nextLine().trim();

        List<Element> found = filterEmployees(el ->
                getText(el, "department").equalsIgnoreCase(department));

        printFound(found, "отделу «" + department + "»");
    }

    private static void searchByYear(Scanner scanner) throws Exception {
        System.out.print("Введите год приёма: ");
        String year = scanner.nextLine().trim();

        List<Element> found = filterEmployees(el ->
                getText(el, "year").equals(year));

        printFound(found, "году приёма «" + year + "»");
    }

    private static void deleteEmployee(Scanner scanner) throws Exception {
        System.out.print("Введите имя сотрудника для удаления: ");
        String name = scanner.nextLine().trim();

        Document doc = loadDocument();
        NodeList list = doc.getElementsByTagName("employee");
        boolean deleted = false;

        for (int i = 0; i < list.getLength(); i++) {
            Element el = (Element) list.item(i);
            if (getText(el, "name").equalsIgnoreCase(name)) {
                el.getParentNode().removeChild(el);
                deleted = true;
                break;
            }
        }

        if (deleted) {
            saveDocument(doc);
            System.out.println("Сотрудник \"" + name + "\" удалён.");
        } else {
            System.out.println("Сотрудник \"" + name + "\" не найден.");
        }
    }

    private static Document loadDocument() throws Exception {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        return builder.parse(new File(FILE_PATH));
    }

    private static void saveDocument(Document doc) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT,   "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        transformer.transform(new DOMSource(doc), new StreamResult(new File(FILE_PATH)));
    }

    private static void addChild(Document doc, Element parent, String tag, String text) {
        Element child = doc.createElement(tag);
        child.setTextContent(text);
        parent.appendChild(child);
    }

    private static String getText(Element el, String tag) {
        NodeList nl = el.getElementsByTagName(tag);
        return nl.getLength() > 0 ? nl.item(0).getTextContent() : "";
    }

    private static List<Element> filterEmployees(java.util.function.Predicate<Element> predicate)
            throws Exception {
        NodeList list = loadDocument().getElementsByTagName("employee");
        return IntStream.range(0, list.getLength())
                .mapToObj(i -> (Element) list.item(i))
                .filter(predicate)
                .collect(Collectors.toList());
    }

    private static void printEmployee(Element el, int idx) {
        System.out.println("Сотрудник №" + idx);
        System.out.println("  Имя:                  " + getText(el, "name"));
        System.out.println("  Должность:            " + getText(el, "position"));
        System.out.println("  Отдел:                " + getText(el, "department"));
        System.out.println("  Год приёма на работу: " + getText(el, "year"));
        System.out.println("  Зарплата:             " + getText(el, "salary"));
        System.out.println("-".repeat(45));
    }

    private static void printFound(List<Element> found, String criteria) {
        if (found.isEmpty()) {
            System.out.println("Сотрудников по " + criteria + " не найдено.");
        } else {
            System.out.println("Найдено по " + criteria + ": " + found.size());
            for (int i = 0; i < found.size(); i++) {
                printEmployee(found.get(i), i + 1);
            }
        }
    }
}