package com.sergenikov.fundamentals.datastructures.graph;

public interface Graph {    

    void addEdge(int n1, int n2);
    void addVertex(int n);
    void removeEdge(int n1, int n2);
    void removeVertex(int n);

}
