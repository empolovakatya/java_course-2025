package lr9.task8;

import java.util.Scanner;

public class Task8 {

    static class Node {
        int value;
        Node next;
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static class LinkedList {
        Node head;

        void createHead(int[] values) {
            head = null;
            for (int v : values) {
                head = new Node(v, head);
            }
        }

        void createTail(int[] values) {
            head = null;
            Node tail = null;
            for (int v : values) {
                Node newNode = new Node(v, null);
                if (tail == null) { head = tail = newNode; }
                else { tail.next = newNode; tail = newNode; }
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            Node ref = head;
            while (ref != null) {
                sb.append(ref.value);
                if (ref.next != null) sb.append(", ");
                ref = ref.next;
            }
            return sb.append("]").toString();
        }

        void addFirst(int value) {
            head = new Node(value, head);
        }

        void addLast(int value) {
            Node newNode = new Node(value, null);
            if (head == null) { head = newNode; return; }
            Node ref = head;
            while (ref.next != null) ref = ref.next;
            ref.next = newNode;
        }

        void insert(int index, int value) {
            if (index == 0) { addFirst(value); return; }
            Node ref = head;
            int k = 0;
            while (ref != null && k < index - 1) { ref = ref.next; k++; }
            if (ref == null) throw new IndexOutOfBoundsException("Нет элемента с индексом " + index);
            ref.next = new Node(value, ref.next);
        }

        void removeFirst() {
            if (head != null) head = head.next;
        }

        void removeLast() {
            if (head == null) return;
            if (head.next == null) { head = null; return; }
            Node ref = head;
            while (ref.next.next != null) ref = ref.next;
            ref.next = null;
        }

        void remove(int index) {
            if (index == 0) { removeFirst(); return; }
            Node ref = head;
            int k = 0;
            while (ref.next != null && k < index - 1) { ref = ref.next; k++; }
            if (ref.next == null) throw new IndexOutOfBoundsException("Нет элемента с индексом " + index);
            ref.next = ref.next.next;
        }

        void createHeadRec(int[] values, int index) {
            if (index < 0) return;
            head = new Node(values[index], head);
            createHeadRec(values, index - 1);  // голова — первый элемент
        }

        private Node buildTail(int[] values, int index) {
            if (index == values.length) return null;
            return new Node(values[index], buildTail(values, index + 1));
        }

        void createTailRec(int[] values) {
            head = buildTail(values, 0);
        }

        private String toStringRec(Node node) {
            if (node == null) return "]";
            return node.value + (node.next != null ? ", " : "") + toStringRec(node.next);
        }

        String toStringRec() {
            return "[" + toStringRec(head);
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        int[] data = {1, 2, 3, 4, 5};

        System.out.println("=== createTail ===");
        list.createTail(data);
        System.out.println(list);

        System.out.println("=== addFirst(0) ===");
        list.addFirst(0);
        System.out.println(list);

        System.out.println("=== addLast(6) ===");
        list.addLast(6);
        System.out.println(list);

        System.out.println("=== insert(3, 99) ===");
        list.insert(3, 99);
        System.out.println(list);

        System.out.println("=== removeFirst ===");
        list.removeFirst();
        System.out.println(list);

        System.out.println("=== removeLast ===");
        list.removeLast();
        System.out.println(list);

        System.out.println("=== remove(2) ===");
        list.remove(2);
        System.out.println(list);

        System.out.println("=== createHeadRec ===");
        list.createHeadRec(data, data.length - 1);
        System.out.println(list.toStringRec() + " (рекурсивный вывод)");

        System.out.println("=== createTailRec ===");
        list.createTailRec(data);
        System.out.println(list.toStringRec() + " (рекурсивный вывод)");
    }
}