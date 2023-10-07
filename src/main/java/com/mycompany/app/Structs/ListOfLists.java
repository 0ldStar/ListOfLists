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

    public T pop(int ind) {
        T res = null;
        if (head != null) {
            Node<CustomList<T>> tmp = head;
            Node<CustomList<T>> prev = head;
            while (tmp != null) {
                if (ind < tmp.value.getLength()) {
                    res = tmp.value.pop(ind);
                    if (tmp.value.isEmpty()) {
                        if (tmp == head)
                            head = tmp.next;
                        else
                            prev.next = tmp.next;
                    }
                    return res;
                }
                ind -= tmp.value.getLength();
                prev = tmp;
                tmp = tmp.next;
            }
        }
        return res;
    }

    public void insert(int ind, T value) {
        if (ind == 0) {
            if (head == null) {
                head = new Node<CustomList<T>>();
                head.value = new CustomList<T>(value);
            } else {
                head.value.insert(ind, value);
                balancing(head);
            }
        } else {
            Node<CustomList<T>> tmp = head;
            while (tmp != null) {
                if (ind < tmp.value.getLength()) {
                    tmp.value.insert(ind, value);
                    balancing(tmp);
                    return;
                }
                ind -= tmp.value.getLength();
                tmp = tmp.next;
            }
        }
    }

    private void balancing(Node<CustomList<T>> node) {
        while (node != null) {
            if (node.value.getLength() > maxLen) {
                T value = node.value.pop(node.value.getLength() - 1);
                if (node.next != null) {
                    node.next.value.insert(0, value);
                } else {
                    node.next = new Node<CustomList<T>>();
                    node.next.value = new CustomList<T>(value);
                }
                System.out.print("Value: ");
                System.out.println(value);
            }
            node = node.next;
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
