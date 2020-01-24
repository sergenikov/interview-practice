package com.sergenikov.fundamentals.bfs;

import com.sergenikov.fundamentals.datastructures.Node;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

public class BFSTest {

    private BFS fixture;

    @Before
    public void setup() {
        fixture = new BFS();
    }

    @Test
    public void search_should_returnNode_when_nodeExists() {

        Node node = new Node(5, new Node(7, null));

        List<Integer> actual = this.fixture.search(node, 7);

        assertEquals(Arrays.asList(5, 7), actual);

    }

}