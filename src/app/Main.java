package app;

import model.Edge;
import model.Tree;
import model.Vertex;

public class Main {

    
    public static void main(String[] args) {

        Tree tree = help.FileReaderHelper.readFile();
        Tree mst = tree.getMinimumSpanningTree();
        
        for (Edge edge : mst.getEdges()) {
            System.out.println(edge.toString());
        }
    }    
}
