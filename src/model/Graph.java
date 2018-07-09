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
import java.util.Collection;

/**
 *
 * @author lucas.budelon
 */
public class Graph {

    private Set<Edge> edges = new HashSet<>();
    private int totalEdges;

    private Set<Vertex> vertices = new HashSet<>();
    private int totalVertices;

    private final List<Edge> ordened = new ArrayList<>();

    public Graph() {
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

    public Graph getMinimumSpanningTree() {

        Graph minimumTree = new Graph();
        Graph dryBranches = new Graph();

        this.createBranches(minimumTree, dryBranches);
        this.connectBranches(minimumTree, dryBranches);

        return minimumTree;
    }

    private void createBranches(Graph minimumTree, Graph dryBranches) {

        boolean containsSource, containsDestiny, containBoth, containsOnlyOne;

        for (Edge edge : this.getEdgesOrdened()) {

            containsSource = minimumTree.containVertex(edge.getSource());
            containsDestiny = minimumTree.containVertex(edge.getDestiny());
            containsOnlyOne = containsSource ^ containsDestiny;
            containBoth = containsSource && containsDestiny;

            if (!containBoth || containsOnlyOne) {
                minimumTree.add(edge);
            } else {
                dryBranches.add(edge);
            }
        }
    }

    private void connectBranches(Graph minimumTree, Graph dryBranches) {

        int sourceIndex = 0, destinyIndex = 0;
        
        for (Edge newEdge : dryBranches.getEdgesOrdened()) {

            if (minimumTree.validateEdgesMinimumSpanningTree()) {

                for (Edge edge : minimumTree.getEdgesOrdened()) {

                    if (newEdge.containVertex(edge.getDestiny())) {
                        sourceIndex = edge.getSource().getIndex();
                    } 
                    
                    if (newEdge.containVertex(edge.getSource())) {
                        destinyIndex = edge.getDestiny().getIndex();
                    }
                }
                
                if (sourceIndex != destinyIndex){
                    minimumTree.add(newEdge);
                }
            } 
        }
    }

    private boolean validateEdgesMinimumSpanningTree() {
        return (this.edges.size() - this.vertices.size()) < -1;
    }

    private boolean containVertex(Vertex vertex) {
        return this.vertices.contains(vertex);
    }

    private List<Edge> getEdgesOrdened() {
        if (ordened.isEmpty()) {
            toOrderEdges();
        }
        return ordened;
    }

    private Graph toOrderEdges() {
        List<Edge> list = new ArrayList<>(edges);
        Collections.sort(list);
        this.ordened.addAll(list);
        return this;
    }
}
