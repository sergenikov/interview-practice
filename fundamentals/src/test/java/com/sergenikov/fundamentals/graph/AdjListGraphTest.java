package com.sergenikov.fundamentals.graph;

import com.sergenikov.fundamentals.datastructures.graph.Node;
import com.sergenikov.fundamentals.datastructures.graph.AdjListGraph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class AdjListGraphTest {

    private AdjListGraph fixture;

    @Before
    public void setup() {
        fixture = new AdjListGraph();
    }

    @Test
    public void addVertex_should_addVertexWithoutEdgesToGraph_when_addingNewVertex() {

        this.fixture.addVertex(100);

        assertNotNull(this.fixture.getAdjList().get(new Node(100)));
    }

    @Test
    public void addVertex_should_addVertexAndEdgesToGraph_when_addingNewVertex() {

        this.fixture.addVertex(100);
        this.fixture.addVertex(200);

        this.fixture.addEdge(100, 200);

        Node n1 = new Node(100);
        Node n2 = new Node(200);

        assertNotNull(this.fixture.getAdjList().get(n1));
        assertNotNull(this.fixture.getAdjList().get(n2));

        assertEquals(1, this.fixture.getAdjList().get(n1).size());
        assertEquals(1, this.fixture.getAdjList().get(n2).size());
    }

    @Test
    public void removeVertex_should_doNothing_when_removingFromEmptyList() {
        this.fixture.removeVertex(100);
    }

    @Test
    public void removeVertex_should_removeVertexFromAllLinkingNodes_when_aLinkedNode() {

        this.fixture.addVertex(100);
        this.fixture.addVertex(200);
        this.fixture.addVertex(300);

        this.fixture.addEdge(100, 200);
        this.fixture.addEdge(100, 300);

        Node n1 = new Node(100);
        Node n2 = new Node(200);
        Node n3 = new Node(300);

        assertEquals(2, this.fixture.getAdjList().get(n1).size());
        assertEquals(1, this.fixture.getAdjList().get(n2).size());
        assertEquals(1, this.fixture.getAdjList().get(n3).size());

        this.fixture.removeVertex(100);

        assertFalse(this.fixture.getAdjList().containsKey(n1));

        assertEquals(0, this.fixture.getAdjList().get(n2).size());
        assertEquals(0, this.fixture.getAdjList().get(n3).size());
    }

    @Test
    public void removeEdges_should_removeEdges_when_edgesPresent() {

        this.basic3NodeGraph();

        this.fixture.removeEdge(100, 200);

        assertEquals(1, this.fixture.getAdjList().get(new Node(100)).size());
        assertEquals(0, this.fixture.getAdjList().get(new Node(200)).size());
        assertEquals(1, this.fixture.getAdjList().get(new Node(300)).size());

    }

    private void basic3NodeGraph() {
        this.fixture.addVertex(100);
        this.fixture.addVertex(200);
        this.fixture.addVertex(300);

        this.fixture.addEdge(100, 200);
        this.fixture.addEdge(100, 300);

        Node n1 = new Node(100);
        Node n2 = new Node(200);
        Node n3 = new Node(300);

        assertEquals(2, this.fixture.getAdjList().get(n1).size());
        assertEquals(1, this.fixture.getAdjList().get(n2).size());
        assertEquals(1, this.fixture.getAdjList().get(n3).size());
    }

}