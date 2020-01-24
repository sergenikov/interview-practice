package com.sergenikov.fundamentals.datastructures;

public class Node {

    private Node next;
    private int value;

    public Node(int value, Node next) {
        this.next = next;
        this.value = value;
    }

    public Node getNext() {
        return this.next;
    }

    public int getValue() {
        return this.value;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
