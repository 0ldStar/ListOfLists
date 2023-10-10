package com.mycompany.app.Structs;

import java.io.Serializable;

import com.mycompany.app.ForEachCallbackInterface;

public class CustomList<T> implements Serializable {
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

    public T pop(int ind) {
        T res = null;
        if (head != null) {
            Node<T> tmp = head;
            Node<T> prev = head;
            for (int i = 0; tmp != null; i++) {
                if (i == ind) {
                    if (tmp == head)
                        head = tmp.next;
                    else
                        prev.next = tmp.next;
                    len--;
                    return tmp.value;
                }
                prev = tmp;
                tmp = tmp.next;
            }
        }
        return res;
    }

    public void insert(int ind, T value) /* throws Exception */ {
        if (ind <= len) {
            if (ind == 0) {
                Node<T> tmp = new Node<T>(value);
                tmp.next = head;
                head = tmp;
                len++;
            } else {
                Node<T> tmp = head;
                Node<T> prev = head;
                int i = 0;
                while (tmp != null) {
                    if (i == ind) {
                        Node<T> newNode = new Node<T>(value);
                        prev.next = newNode;
                        newNode.next = tmp;
                        len++;
                        return;
                    }
                    prev = tmp;
                    tmp = tmp.next;
                    i++;
                }
            }
        }
        // throw new Exception("ABOBA");
    }

    public void forEach(ForEachCallbackInterface<T> callback) {
        Node<T> tmp = head;

        while (tmp != null) {
            callback.toDo(tmp.value);
            tmp = tmp.next;
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
