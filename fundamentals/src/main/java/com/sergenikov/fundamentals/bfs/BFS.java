package com.sergenikov.fundamentals.bfs;

import com.sergenikov.fundamentals.datastructures.graph.AdjListGraph;
import com.sergenikov.fundamentals.datastructures.graph.Node;
import java.util.*;

public class BFS {

    final Queue<Node> queue;
    final Set<Node> visitTracker;

    public BFS() {
	this.queue = new LinkedList<>();
	this.visitTracker = new HashSet<>();
    }

    // @param - int - value is the value of the node to find
    // @return target node in graph or null
    public Node search(final AdjListGraph graph, int start, int target) {

	final Node startNode = new Node(start);

	this.queue.add(startNode);
	this.visitTracker.add(startNode);

	while (!this.queue.isEmpty()) {

	    Node currentNode = this.queue.poll();

	    if (currentNode.getValue() == target) {
		return currentNode;
	    }

	    for (Node n : graph.getAdjList().get(currentNode)) {
		if (!this.visitTracker.contains(n)) {
		    this.visitTracker.add(n);
		    this.queue.add(n);
		}
	    }
	    
	}
	
        return null;
    }

}
