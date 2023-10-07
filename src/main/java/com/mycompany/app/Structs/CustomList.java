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

    public void pop(int ind) {
        if (head != null) {
            Node<T> tmp = head;
            Node<T> prev = head;
            for (int i = 0; tmp != null; i++) {
                if (i == ind) {
                    if (tmp == head)
                        head = tmp.next;
                    else
                        prev.next = tmp.next;
                    return;
                }
                prev = tmp;
                tmp = tmp.next;
            }
        }
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

    public boolean isEmpty() {
        return head == null;
    }

    private int len;
    private Node<T> head;
}
