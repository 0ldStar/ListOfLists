package com.mycompany.app.Structs;

import java.io.Serializable;

public class Node<T> implements Serializable {
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
