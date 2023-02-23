package udemy.alishev.adv.collections;

import java.util.Arrays;

/**
 * Односвязанный список
 */
public class MyLinkedList {
    private Node head;
    private int size;

    public void add(int value) {
        // если это первое добавление
        if (head == null) {
            this.head = new Node(value);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;
    }

    public int get(int index) {
        int currentIndex = 0;
        Node temp = head;
        while (temp != null) {
            if (currentIndex == index) {
                return temp.getValue();
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        throw new IllegalArgumentException();
    }

    public void remove(int index) {
        if (size == 0) {
            System.out.println("List is empty, cannot delete anything!");
            return;
        }

        if (index >= size){
            System.out.println("Invalid index!");
            return;
        }

        if (index == 0) {
            head = head.getNext();
            size--;
            return;
        }

        int currentIndex = 0;
        Node temp = head;

        while (temp != null) {
            if (currentIndex == index - 1) {
                // получаем узел который надо удалить, а потом у него получаем следующий и линкуем как бы перепрыгивая через того что надо удалить
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
    }

    @Override
    public String toString() {
        int[] result = new int[size];
        int index = 0;
        Node temp = head;
        while (temp != null) {
            result[index] = temp.getValue();
            index++;
            temp = temp.getNext();
        }
        return Arrays.toString(result);
    }

    private static class Node {
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(7);
        myLinkedList.add(3);
        System.out.println(myLinkedList);

        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));

        myLinkedList.remove(3);
        System.out.println(myLinkedList);
        myLinkedList.remove(1);
        System.out.println(myLinkedList);
        myLinkedList.remove(1);
        System.out.println(myLinkedList);
        myLinkedList.remove(0);
        System.out.println(myLinkedList);
        myLinkedList.remove(0);
        System.out.println(myLinkedList);


    }
}
