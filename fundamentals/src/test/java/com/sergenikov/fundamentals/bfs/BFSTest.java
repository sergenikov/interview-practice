package com.sergenikov.fundamentals.bfs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.sergenikov.fundamentals.datastructures.graph.AdjListGraph;
import com.sergenikov.fundamentals.datastructures.graph.Node;

import org.junit.Before;
import org.junit.Test;

public class BFSTest {

    private BFS fixture;

    @Before
    public void setup() {
        this.fixture = new BFS();
    }

    @Test
    public void search_should_findNode_inUndirectedGraph() {
        AdjListGraph graph = new AdjListGraph();

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

        Node actualNode = this.fixture.search(graph, 100, 400);

        assertNotNull(actualNode);
        assertEquals(new Node(400), actualNode);
    }

    @Test
    public void search_should_findNode_inDirectedAcyclicGraph() {
        AdjListGraph graph = new AdjListGraph();

        graph.addVertex(100);
        graph.addVertex(200);
        graph.addVertex(300);
        graph.addVertex(400);

        graph.addEdge(100, 200);
        graph.addEdge(100, 300);
        graph.addEdge(200, 400);

        Node actualNode = this.fixture.search(graph, 100, 400);

        assertNotNull(actualNode);
        assertEquals(new Node(400), actualNode);
    }

    @Test
    public void search_should_findNode_inDirectedCylicGraph() {
        AdjListGraph graph = new AdjListGraph();

        graph.addVertex(100);
        graph.addVertex(200);
        graph.addVertex(300);
        graph.addVertex(400);

        graph.addEdge(100, 200);
        graph.addEdge(100, 300);
        graph.addEdge(200, 400);
        graph.addEdge(300, 200);

        Node actualNode = this.fixture.search(graph, 100, 400);

        assertNotNull(actualNode);
        assertEquals(new Node(400), actualNode);
    }

    @Test
    public void search_should_returnNull_when_nodeDoesntExist() {
        AdjListGraph graph = new AdjListGraph();

        graph.addVertex(100);
        graph.addVertex(200);
        graph.addVertex(300);

        graph.addEdge(100, 200);
        graph.addEdge(100, 300);
        graph.addEdge(200, 100);
        graph.addEdge(300, 100);

        Node actualNode = this.fixture.search(graph, 100, 400);

        assertNull(actualNode);
    }
}