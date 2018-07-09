/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author lucas.budelon
 */
public class Tree {

    private Set<Edge> edges = new HashSet<>();
    private int totalEdges;

    private Set<Vertex> vertices = new HashSet<>();
    private int totalVertices;

    private final List<Edge> ordened = new ArrayList<>();

    public Tree() {
    }

    public final Set<Edge> getEdges() {
        return edges;
    }

    public final int getTotalEdges() {
        return totalEdges;
    }

    public final void setTotalEdges(int totalEdges) {
        this.totalEdges = totalEdges;
    }

    public final Set<Vertex> getVertices() {
        return vertices;
    }

    public final int getTotalVertices() {
        return totalVertices;
    }

    public final void setTotalVertices(int totalVertices) {
        this.totalVertices = totalVertices;
    }

    public void add(Edge edge) {
        this.edges.add(edge);
        this.vertices.add(edge.getSource());
        this.vertices.add(edge.getDestiny());
    }

    public Tree getMinimumSpanningTree() {

        Tree mst = new Tree();

        for (Edge edge : this.getEdgesOrdened()) {

            if (this.isNotCycle(mst.getVertices(), edge)) {
                mst.add(edge);
            }
        }

        return mst;
    }

    private boolean isNotCycle(Set<Vertex> vertices, Edge edge) {
        boolean containsSource = vertices.contains(edge.getSource());
        boolean containsDestiny = vertices.contains(edge.getDestiny());
        boolean notContainBoth = !(containsSource && containsDestiny);
        boolean containsOnlyOne = containsSource ^ containsDestiny;

        return notContainBoth || containsOnlyOne;
    }

    private List<Edge> getEdgesOrdened() {
        if (ordened.isEmpty()) {
            toOrderEdges();
        }
        return ordened;
    }

    private Tree toOrderEdges() {
        List<Edge> list = new ArrayList<>(edges);
        Collections.sort(list);
        this.ordened.addAll(list);
        return this;
    }
}
