/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author lucas.budelon
 */
public class Edge implements Comparable<Edge> {

    private Vertex source;

    private Vertex destiny;

    private int weight;

    public Edge(int source, int destiny, int weight) {
        this.source = new Vertex(source);
        this.destiny = new Vertex(destiny);
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestiny() {
        return destiny;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Edge)) {
            return false;
        }
        Edge castOther = (Edge) other;
        return Objects.equals(source, castOther.source)
                && Objects.equals(destiny, castOther.destiny)
                && Objects.equals(weight, castOther.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destiny, weight);
    }

    @Override
    public int compareTo(Edge o) {
        if (this.weight > o.weight) {
            return 1;
        } else if (this.weight < o.weight) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return this.source + " - " + this.destiny + " : " + this.weight;
    }
}
