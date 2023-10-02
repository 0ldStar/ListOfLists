package com.mycompany.app.Structs;

public class Node<T> {
    public Node() {
        value = null;
        next = null;
    }

    public Node(T value) {
        this.value = value;
        next = null;
    }

    public T value;
    public Node<T> next;
}
