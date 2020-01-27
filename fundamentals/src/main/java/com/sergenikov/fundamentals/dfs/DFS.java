
package com.sergenikov.fundamentals.dfs;

import com.sergenikov.fundamentals.datastructures.graph.AdjListGraph;
import com.sergenikov.fundamentals.datastructures.graph.Node;
import com.sergenikov.fundamentals.datastructures.graph.Graph;

import java.util.*;

public class DFS {

    Set<Node> visitedTracker;

    public Node recursive(Graph graph, int start, int target) {
	this.visitedTracker = new HashSet<>();
	return this.recursiveWorker(graph, start, target);
    }

    /*
     * @return - found node or null
     */
    private Node recursiveWorker(Graph graph, int start, int target) {
	
	System.out.print(" " + start);
	
	Node startNode = new Node(start);

	if (startNode.getValue() == target) {
	    return startNode;
	}

	this.visitedTracker.add(startNode);

	for (Node n : graph.getAdjacentNodes(startNode.getValue())) {
	    
	    if (!this.visitedTracker.contains(n)) {
		return this.recursiveWorker(graph, n.getValue(), target);		
	    }

	}
	return null;
    }

    public Node iterative(Graph graph, int start, int target) {
	
	this.visitedTracker = new HashSet<>();

	final Stack<Node> stack = new Stack<>();

	Node startNode = new Node(start);

	this.visitedTracker.add(startNode);
	stack.push(startNode);

	while(!stack.isEmpty()) {
	    
	    Node current = stack.pop();

	    if (current.getValue() == target) {
		return current;
	    }

	    for (Node n : graph.getAdjacentNodes(current.getValue())) {
		if (!this.visitedTracker.contains(n)) {
		    this.visitedTracker.add(n);
		    stack.push(n);
		}
	    }
	}
	return null;
    }
}
