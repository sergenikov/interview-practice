package com.sergenikov.fundamentals.datastructures.linkedlist;

import java.lang.Override;
import java.util.Objects;

public class Node<K> {

    private Node<K> next;
    private K value;

    public Node(K value, Node<K> next) {
        this.value = value;
        this.next = next;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Node<?> node = (Node<?>) object;
        return java.util.Objects.equals(next, node.next) &&
                java.util.Objects.equals(value, node.value);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), next, value);
    }

    @Override
    public java.lang.String toString() {
        return "Node{" +
                "next=" + next +
                ", value=" + value +
                '}';
    }
}
