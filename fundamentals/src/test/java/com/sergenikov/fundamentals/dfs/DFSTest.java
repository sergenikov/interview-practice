package com.sergenikov.fundamentals.bfs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.sergenikov.fundamentals.datastructures.graph.AdjListGraph;
import com.sergenikov.fundamentals.datastructures.graph.Node;
import com.sergenikov.fundamentals.datastructures.graph.Graph;

import com.sergenikov.fundamentals.dfs.DFS;

public class DFSTest {

    private DFS fixture;

    @Before
    public void setup() {
	this.fixture = new DFS();
    }
    
    @Test
    public void search_should_findNode_inUndirectedGraph() {
        Graph graph = new AdjListGraph();

        graph.addVertex(100);
        graph.addVertex(200);
        graph.addVertex(300);
        graph.addVertex(400);

        graph.addEdge(100, 200);
        graph.addEdge(100, 300);
        graph.addEdge(200, 400);
        graph.addEdge(200, 100);
        graph.addEdge(300, 100);
        graph.addEdge(400, 200);

        Node actualRecursive = this.fixture.recursive(graph, 100, 400);
        Node actualIterative = this.fixture.iterative(graph, 100, 400);

	assertEquals(actualRecursive, actualIterative);
	
        assertNotNull(actualRecursive);
	assertNotNull(actualIterative);
        assertEquals(new Node(400), actualRecursive);
    }

    @Test
    public void search_should_findNode_inDirectedAcyclicGraph() {
        Graph graph = new AdjListGraph();

        graph.addVertex(100);
        graph.addVertex(200);
        graph.addVertex(300);
        graph.addVertex(400);

        graph.addEdge(100, 200);
        graph.addEdge(100, 300);
        graph.addEdge(200, 400);

        Node actualRecursive = this.fixture.recursive(graph, 100, 400);
        Node actualIterative = this.fixture.iterative(graph, 100, 400);

	assertEquals(actualRecursive, actualIterative);

        assertNotNull(actualRecursive);
	assertNotNull(actualIterative);
	assertEquals(new Node(400), actualRecursive);
    }

    @Test
    public void search_should_findNode_inDirectedCylicGraph() {
        Graph graph = new AdjListGraph();

        graph.addVertex(100);
        graph.addVertex(200);
        graph.addVertex(300);
        graph.addVertex(400);

        graph.addEdge(100, 200);
        graph.addEdge(100, 300);
        graph.addEdge(200, 400);
        graph.addEdge(300, 200);

        Node actualRecursive = this.fixture.recursive(graph, 100, 400);
        Node actualIterative = this.fixture.iterative(graph, 100, 400);

	assertEquals(actualRecursive, actualIterative);

	assertNotNull(actualRecursive);
	assertNotNull(actualIterative);
        assertEquals(new Node(400), actualRecursive);
    }

    @Test
    public void search_should_returnNull_when_nodeDoesntExist() {
        Graph graph = new AdjListGraph();

        graph.addVertex(100);
        graph.addVertex(200);
        graph.addVertex(300);

        graph.addEdge(100, 200);
        graph.addEdge(100, 300);
        graph.addEdge(200, 100);
        graph.addEdge(300, 100);

	Node actualRecursive = this.fixture.recursive(graph, 100, 400);
        Node actualIterative = this.fixture.iterative(graph, 100, 400);

	assertNull(actualRecursive);
	assertNull(actualIterative);
    } 
}
