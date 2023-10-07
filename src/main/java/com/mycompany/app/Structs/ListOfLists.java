package com.mycompany.app.Structs;

public class ListOfLists<T> {
    public ListOfLists() {
        head = null;
    }

    public ListOfLists(int maxLen) {
        this.maxLen = maxLen;
    }

    public void push(T value) {
        if (head == null) {
            head = new Node<CustomList<T>>();
            head.value = new CustomList<T>(value);
        } else {
            Node<CustomList<T>> tmp = head;
            Node<CustomList<T>> prev = head;

            while (tmp != null) {
                if (tmp.value.getLength() < maxLen) {
                    tmp.value.push(value);
                    return;
                }
                prev = tmp;
                tmp = tmp.next;
            }
            prev.next = new Node<CustomList<T>>();
            prev.next.value = new CustomList<T>(value);
        }
    }

    public void pop(int ind) {
        if (head != null) {
            Node<CustomList<T>> tmp = head;
            Node<CustomList<T>> prev = head;
            while (tmp != null) {
                if (ind < tmp.value.getLength()) {
                    tmp.value.pop(ind);
                    if (tmp.value.isEmpty()) {
                        if (tmp == head)
                            head = tmp.next;
                        else
                            prev.next = tmp.next;
                    }
                    return;
                }
                ind -= tmp.value.getLength();
                prev = tmp;
                tmp = tmp.next;
            }
        }
    }

    public void print() {
        if (head != null) {
            System.out.println("List of lists");
            Node<CustomList<T>> tmp = head;

            while (tmp != null) {
                tmp.value.print();
                tmp = tmp.next;
            }
        } else {
            System.out.println("List if lists is empty");
        }
    }

    private int maxLen = 2;
    private Node<CustomList<T>> head;
}
