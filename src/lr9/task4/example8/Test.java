package lr9.task4.example8;

public class Test {

    public static void main(String[] args) {
        Node node0 = new Node(0, null);
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        Node ref = node0;
        while (ref != null){
            System.out.println(" " + ref.value);
            ref = ref.next;
        }
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Способ 1: создание с головы
    public static Node createFromHead() {
        Node head = null;
        for (int i = 5; i >= 1; i--) {
            head = new Node(i, head);
        }
        return head;
    }

    // Способ 2: создание с хвоста
    public static Node createFromTail() {
        Node head = new Node(1, null);
        Node tail = head;

        for (int i = 2; i <= 5; i++) {
            tail.next = new Node(i, null);
            tail = tail.next;
        }
        return head;
    }


}