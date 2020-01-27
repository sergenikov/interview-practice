package com.sergenikov.fundamentals.datastructures.graph;

import java.util.Map;
import java.util.List;
import java.util.LinkedList;
import java.util.HashMap;

public class AdjListGraph implements Graph {

	private Map<Node, List<Node>> adjList;

	public AdjListGraph() {
		this.adjList = new HashMap<>();
	}

	/**
	 * Assume no duplicates are allowed to add. (Adding same node twice will create
	 * that node twice.)
	 **/
	@Override
	public void addEdge(int n1, int n2) {
		Node node1 = new Node(n1);
		Node node2 = new Node(n2);
		this.adjList.get(node1).add(node2);
		this.adjList.get(node2).add(node1);
	}

	/**
	 * Assume no duplicates in the Graph
	 **/
	@Override
	public void addVertex(int n) {
		System.out.println("Adding vertex n " + n);

		Node node = new Node(n);

		if (!this.adjList.containsKey(node)) {
			this.adjList.put(node, new LinkedList<>());
		}
	}

	@Override
	public void removeEdge(int n1, int n2) {
		Node node1 = new Node(n1);
		Node node2 = new Node(n2);

		List<Node> node1Edges = this.adjList.get(node1);
		List<Node> node2Edges = this.adjList.get(node2);

		if (node1Edges != null) {
			node1Edges.remove(node2);
		}

		if (node2Edges != null) {
			node2Edges.remove(node1);
		}
	}

	@Override
	public void removeVertex(int n) {

		Node node = new Node(n);

		this.adjList.remove(node); // removing the node will unlike the list freeing it for gc

		// remove from other nodes' lists
		this.adjList.forEach((k, v) -> {
			if (v.contains(node)) {
				v.remove(node);
			}
		});
	}

	public Map<Node, List<Node>> getAdjList() {
		return this.adjList;
	}

    @Override
    public List<Node> getAdjacentNodes(int n) {
	return this.adjList.get(new Node(n));
    }
}
