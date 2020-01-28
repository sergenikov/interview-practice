package com.sergenikov.fundamentals.datastructures.linkedlist;


public class LinkedList<K> {

    private Node<K> start;

    public LinkedList(K value) {
	this.start = new Node<>(value);
    }
    
}
