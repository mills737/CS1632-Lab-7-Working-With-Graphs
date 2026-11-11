import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GraphAdjacencyList {
    private HashMap<String, List<Edge>> adjList;
    public GraphAdjacencyList() {
        adjList = new HashMap<>();
    }
    public void fileRead(String fileName) throws FileNotFoundException{
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                line = line.replace("\uFEFF", "");
                if (line.isEmpty()){continue;}
                line = line.replace("\uFEFF", "");
                String[] values = line.split("\\s+");
                String src = values[0];
                String dest = values[1];
                double weight = Double.parseDouble(values[2]);

                adjList.putIfAbsent(src, new ArrayList<>());
                adjList.putIfAbsent(dest, new ArrayList<>());
                adjList.get(src).add(new Edge(dest, weight));
            }
            fileScanner.close();

        }
        public void printGraph(){
        for(String vertex : adjList.keySet()){
            System.out.print(vertex + " -> ");
            for(Edge edge : adjList.get(vertex)){
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }

    public HashMap<String, List<Edge>> getAdjList() {
        return adjList;
    }

    public Set<String> getVertices(){
        return adjList.keySet();
    }
}
