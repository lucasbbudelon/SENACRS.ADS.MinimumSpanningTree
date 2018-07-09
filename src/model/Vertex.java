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
public class Vertex implements Comparable<Vertex> {

    private int index;

    public Vertex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Vertex)) {
            return false;
        }
        Vertex castOther = (Vertex) other;
        return index == castOther.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

    @Override
    public int compareTo(Vertex o) {
        if (this.index > o.index) {
            return 1;
        } else if (this.index < o.index) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return Integer.toString(this.index);
    }
}
