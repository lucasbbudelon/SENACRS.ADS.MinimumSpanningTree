package help;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import model.Edge;
import model.Graph;

public class FileReaderHelper {

    public static Graph readFile(String database) {

        try (Scanner file = new Scanner(new FileReader(database))) {

            Graph graph = new Graph();
            boolean loadFirtLine = false;

            while (file.hasNext()) {
                try (Scanner sc = new Scanner(file.nextLine())) {

                    if (loadFirtLine) {
                        Edge edge = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
                        graph.add(edge);
                    } else {
                        graph.setTotalVertices(sc.nextInt());
                        graph.setTotalEdges(sc.nextInt());
                        loadFirtLine = true;
                    }
                }
            }
            return graph;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
