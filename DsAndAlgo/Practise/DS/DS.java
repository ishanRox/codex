import java.util.Arrays;
import java.util.stream.Stream;

/**
 * DS
 */
public class DS {

    public static void main(String[] args) {
        int factor1[] = { 10 };
        Stream<Integer> noStream1 = Arrays.asList(5, 4, 3, 2, 1).stream().map(e -> e * factor1[0]);
       

        noStream1.forEach(System.out::println);
        factor1[0] = 1000;       factor1[0] = 122000;
    }
}

class LinkedList {
    Node head;

    public void delete(int data) {
        Node temp = head;
        while (temp != null) {
            if (data == temp.next.data) {


            }
            temp = temp.next;
        }
    }

    public void append(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAfter(Node previouse, int data) {
        Node newNode = new Node(data);
        newNode.next = previouse.next;
        previouse.next = newNode;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }
}