import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try{
            GraphAdjacencyList graph = new GraphAdjacencyList();
            graph.fileRead("data/Graph.txt");
            System.out.println("Adjacency List: ");
            graph.printGraph();

            GraphAdjacencyMatrix matrix = new GraphAdjacencyMatrix(graph);
            System.out.println("Adjacency Matrix: ");
            matrix.printMatrix();

            SearchGraph search = new  SearchGraph(graph);
            System.out.println("Breadth First Search Starting at A: ");
            search.breadthFirstSearch("A");
        }
        catch (Exception e){
            System.out.println("Error Reading File: " + e.getMessage());
        }
    }
}
