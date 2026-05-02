package linkedList.pratice;

import java.util.Scanner;

public class class_1 {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;
    static Node tail;
    static int size;

    void addFirst(int data) {
        // 1. create a new node
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // 2.
        newNode.next = head;

        // 3.
        head = newNode;
    }

    void addLast(int data) {
        // 1. create new node
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // 2.
        tail.next = newNode;

        // 3.
        tail = newNode;
    }

    void add(int idx, int data) {
        if (idx == 0) {
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;

        temp.next = newNode;
    }

    void print() {
        Node temp = head;

        while (temp != null) {
            if (head == null) {
                System.out.println("LL is Empty");
                return;
            }
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    int removeFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    int search(int key) {
        Node temp = head;
        int i = 0;

        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        class_1 list = new class_1();

        // add
        list.addFirst(5);
        list.addLast(6);
        list.add(1, 7);
        list.print();
        System.out.println("size of LL : " + list.size);

        // remove`
        list.removeFirst();
        list.print();
        System.out.println("size of LL : " + list.size);

        list.removeLast();
        list.print();
        System.out.println("size of LL : " + list.size);

        System.out.println("element found at idx : " + list.search(7));


        Scanner sc = new Scanner(System.in);
        class_1 list2 = new class_1();

        int choice;
        do {
            System.out.println("\n--- Choose the options--");
            System.out.println("1. Add First");
            System.out.println("2. Add Last");
            System.out.println("3. Remove First");
            System.out.println("4. Remove Last");
            System.out.println("5. Search");
            System.out.println("6. Print");
            System.out.println("7. Size");
            System.out.println("8. Exit");
            System.out.println("Enter your choice : ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter value : ");
                    list2.addFirst(sc.nextInt());
                    break;

                case 2:
                    System.out.println("Enter value : ");
                    list2.addLast(sc.nextInt());
                    break;

                case 3:
                    list2.removeFirst();
                    break;

                case 4:
                    list2.removeLast();
                    break;

                case 5:
                    System.out.println("Enter the value to search : ");
                    int key = sc.nextInt();
                    list2.search(key);
                    break;

                case 6:
                    list2.print();
                    break;

                case 7:
                    System.out.println(list2.size);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        } while (choice != 8);
        sc.close();
    }
}