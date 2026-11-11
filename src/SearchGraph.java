import java.util.*;
public class SearchGraph {
    private GraphAdjacencyList graph;

    public SearchGraph(GraphAdjacencyList graph) {
        this.graph = graph;
    }
    public void breadthFirstSearch(String start){
        LinkedList<String> visited = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        while(!queue.isEmpty()){
            String current = queue.poll();
            System.out.println(current + " ");
            for(Edge edge : graph.getAdjList().get(current)){
                String next = edge.getDest();
                if(!visited.contains(next)){
                    visited.add(next);
                    queue.add(next);
                }
            }
        }
        System.out.println();
    }
}
