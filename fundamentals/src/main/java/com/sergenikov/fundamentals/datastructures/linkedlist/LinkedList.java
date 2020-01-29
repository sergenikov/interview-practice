package com.sergenikov.fundamentals.datastructures.linkedlist;

import java.util.Objects;

public class LinkedList<K> {

    private Node<K> head;
    private Node<K> tail;

    public LinkedList() {
	this.head = null;
    }
    
    public LinkedList(K value) {
	this.head = new Node<>(value, null);
    }

    /**
     * Runs in O(1) because there is a tail pointer. 
     * @return true of the list changed as a result of the call
     */
    public boolean add(K k) {

	Node<K> node = new Node(k, null);
	
	this.tail.next = node;
	this.tail = node;
	
	return false;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        LinkedList<?> that = (LinkedList<?>) object;
        return java.util.Objects.equals(head, that.head);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), head);
    }
}
