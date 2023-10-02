package com.mycompany.app.Structs;

public class CustomList<T> {
    public CustomList() {
        head = null;
    }

    public CustomList(T value) {
        head = null;
        push(value);
    }

    public void push(T value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            Node<T> tmp = head;

            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = new Node<>(value);
        }
        len++;
    }

    public void print() {
        if (head != null) {
            Node<T> tmp = head;
            while (tmp != null) {
                System.out.print(tmp.value);
                System.out.print(" ");
                tmp = tmp.next;
            }
        }
        System.out.println("Len = " + Integer.toString(len));
    }

    public int getLength() {
        return len;
    }

    private int len;
    private Node<T> head;
}
