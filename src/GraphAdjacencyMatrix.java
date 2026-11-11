import java.util.*;
public class GraphAdjacencyMatrix {
    private double[][] matrix;
    private HashMap<String, Integer> index;
    private List<String> vertices;

    public GraphAdjacencyMatrix(GraphAdjacencyList graph){
        vertices = new ArrayList<>(graph.getVertices());
        Collections.sort(vertices);
        index = new HashMap<>();
        for(int i = 0; i < vertices.size(); i++){
            index.put(vertices.get(i), i);
        }
        matrix = new double[vertices.size()][vertices.size()];
        for(int i = 0; i < matrix.length; i++){
            Arrays.fill(matrix[i], Double.POSITIVE_INFINITY);
            matrix[i][i] = 0;
        }
        buildMatrix(graph);
    }

    private void buildMatrix(GraphAdjacencyList graph){
        HashMap<String, List<Edge>> list = graph.getAdjList();
        for(String vertex : list.keySet()){
            int row = index.get(vertex);
            for(Edge edge : list.get(vertex)){
                int col = index.get(edge.getDest());
                matrix[row][col] = edge.getWeight();
            }
        }
    }
    public void printMatrix(){
        System.out.println("   ");
        for(String vertex : vertices){
            System.out.printf("%8s", vertex);
        }
        System.out.println();
        for(int i = 0; i < matrix.length; i++){
            System.out.printf("%3s", vertices.get(i));
            for(int j = 0; j < matrix.length; j++){
                if(matrix[i][j] == Double.POSITIVE_INFINITY){
                    System.out.printf("%8s", "-");
                }
                else{
                    System.out.printf("%8.1f", matrix[i][j]);
                }
            }
            System.out.println();
        }
    }
    public double[][] getMatrix() {
        return matrix;
    }
}
