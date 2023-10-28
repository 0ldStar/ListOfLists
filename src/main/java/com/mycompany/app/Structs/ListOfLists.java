package com.mycompany.app.Structs;

import java.io.Serializable;

import com.mycompany.app.ForEachCallbackInterface;

public class ListOfLists<T extends Comparable<T>> implements Serializable {
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
            len++;
        } else {
            Node<CustomList<T>> tmp = head;
            Node<CustomList<T>> prev = head;

            while (tmp != null) {
                if (tmp.value.getLength() < maxLen) {
                    tmp.value.push(value);
                    len++;
                    return;
                }
                prev = tmp;
                tmp = tmp.next;
            }
            prev.next = new Node<CustomList<T>>();
            prev.next.value = new CustomList<T>(value);
            len++;
        }
    }

    public T pop(int ind) throws IndexOutOfBoundsException {
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
                    len--;
                    return res;
                }
                ind -= tmp.value.getLength();
                prev = tmp;
                tmp = tmp.next;
            }
            throw new IndexOutOfBoundsException("Index out of bounds: " + ind);
        } else {
            throw new NullPointerException();
        }
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
            len++;
        } else {
            Node<CustomList<T>> tmp = head;
            while (tmp != null) {
                if (ind < tmp.value.getLength()) {
                    tmp.value.insert(ind, value);
                    balancing(tmp);
                    len++;
                    return;
                }
                ind -= tmp.value.getLength();
                tmp = tmp.next;
            }
        }
    }

    public void balancing() {
        Node<CustomList<T>> tmp = head;
        Node<CustomList<T>> prev = head;
        while (tmp != null) {
            while ((tmp.value.getLength() < maxLen) && (tmp.next != null) && (tmp.next.value != null)) {
                tmp.value.push(tmp.next.value.pop(0));
            }
            if ((tmp.next == null) && (tmp.value.getLength() == 0))
                prev.next = null;
            prev = tmp;
            tmp = tmp.next;
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
                // System.out.print("Value: ");
                // System.out.println(value);
            }
            node = node.next;
        }
    }

    public void forEach(ForEachCallbackInterface<T> callback) {
        Node<CustomList<T>> tmp = head;

        while (tmp != null) {
            CustomList<T> customList = tmp.value;
            customList.forEach(callback);
            tmp = tmp.next;
        }
    }

    public void sort() {

        for (int i = len / 2 - 1; i >= 0; i--)
            heapify(len, i);

        for (int i = len - 1; i >= 0; i--) {
            T swap = getElement(0);
            setElement(0, getElement(i));
            setElement(i, swap);

            heapify(i, 0);
        }
        balancing();
    }

    private void heapify(int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && getElement(l).compareTo(getElement(largest)) > 0)
            largest = l;

        if (r < n && getElement(r).compareTo(getElement(largest)) > 0)
            largest = r;
        if (largest != i) {
            swapElements(i, largest);
            heapify(n, largest);
        }
    }

    private void swapElements(int first, int second) {
        T swap = getElement(first);
        setElement(first, getElement(second));
        setElement(second, swap);
    }

    private void setElement(int ind, T element) {
        if (head != null) {
            Node<CustomList<T>> tmp = head;
            while (tmp != null) {
                if (ind < tmp.value.getLength()) {
                    tmp.value.setElement(ind, element);
                    return;
                }
                ind -= tmp.value.getLength();
                tmp = tmp.next;
            }
            throw new IndexOutOfBoundsException("Index out of bounds: " + ind);
        }
    }

    public T getElement(int ind) throws IndexOutOfBoundsException, NullPointerException {
        T res;
        if (head != null) {
            Node<CustomList<T>> tmp = head;
            while (tmp != null) {
                if (ind < tmp.value.getLength()) {
                    res = tmp.value.getElement(ind);
                    return res;
                }
                ind -= tmp.value.getLength();
                tmp = tmp.next;
            }
            throw new IndexOutOfBoundsException("Index out of bounds: " + ind);
        } else {
            throw new NullPointerException();
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
    private int len = 0;
}
