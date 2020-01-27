package com.sergenikov.fundamentals.datastructures.graph;

import com.sergenikov.fundamentals.datastructures.graph.Node;
import java.util.List;

public interface Graph {    

    void addEdge(int n1, int n2);
    void addVertex(int n);
    void removeEdge(int n1, int n2);
    void removeVertex(int n);
    List<Node> getAdjacentNodes(int n);

}
