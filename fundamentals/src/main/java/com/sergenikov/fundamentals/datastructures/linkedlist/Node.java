package com.sergenikov.fundamentals.datastructures.linkedlist;

public class Node<K> {

    private Node<K> next;
    private K value;

    public Node(K value) {
	this.value = value;
    }
}
