package help;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import model.Edge;
import model.Tree;

public class FileReaderHelper {

    public static Tree readFile() {

        try (Scanner file = new Scanner(new FileReader("grafo.txt"))) {

            Tree tree = new Tree();
            boolean loadFirtLine = false;

            while (file.hasNext()) {
                try (Scanner sc = new Scanner(file.nextLine())) {

                    if (loadFirtLine) {
                        Edge edge = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
                        tree.add(edge);
                    } else {
                        tree.setTotalVertices(sc.nextInt());
                        tree.setTotalEdges(sc.nextInt());
                        loadFirtLine = true;
                    }
                }
            }
            return tree;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
