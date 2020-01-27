
package com.sergenikov.fundamentals.dfs;

import com.sergenikov.fundamentals.datastructures.graph.AdjListGraph;
import com.sergenikov.fundamentals.datastructures.graph.Node;

import java.util.*;

public class DFS {

    Set<Node> visitedTracker;

    public Node recursive(AdjListGraph graph, int start, int target) {
	this.visitedTracker = new HashSet<>();
	return this.recursive(graph, start, target);
    }

    /*
     * @return - found node or null
     */
    private Node recursiveWorker(AdjListGraph graph, int start, int target) {
	
	System.out.print(" " + start);
	
	Node startNode = new Node(start);

	if (startNode.getValue() == target) {
	    return startNode;
	}

	this.visitedTracker.add(startNode);

	for (Node n : graph.getAdjList().get(startNode)) {
	    
	    if (!this.visited.contains(n)){
		return this.recursive(graph, n.getValue(), target);		
	    }

	}
	return null;
    }

    public Node iterative(AdjListGraph graph, int start, int target) {
	
	this.visitedTracker = new HashSet<>();

	final Stack<Node> stack = new Stack<>();

	Node startNode = new Node(start);

	this.visitedTracker.add(startNode);
	stack.push(startNode);

	while(!stack.isEmpty()){
	    
	    Node current = stack.poll();

	    if (current.getValue() == target) {
		return current;
	    }

	    for (Node n : graph.getAdjacentNodes(current)) {
		if (!this.visitedTracker.contains(n)) {
		    this.visitedTracker.add(n);
		    stack.push(n);
		}
	    }

	}

    }

}
