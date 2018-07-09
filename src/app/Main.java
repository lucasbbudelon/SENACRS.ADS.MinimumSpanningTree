package app;

import model.Edge;
import model.Graph;
import model.Vertex;

public class Main {

    
    public static void main(String[] args) {

        Graph completeGraph = help.FileReaderHelper.readFile("database.txt");
        Graph mst = completeGraph.getMinimumSpanningTree();
        
        for (Edge edge : mst.getEdges()) {
            System.out.println(edge.toString());
        }
    }    
}
