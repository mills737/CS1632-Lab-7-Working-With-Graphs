public class Edge {
    private String dest;
    private double weight;

    public Edge(String dest, double weight) {
        this.dest = dest;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public String getDest() {
        return dest;
    }
    @Override
    public String toString() {
        return "("  + dest + ", " + weight + ")";
    }
}
