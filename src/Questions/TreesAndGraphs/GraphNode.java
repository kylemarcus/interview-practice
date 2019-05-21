package Questions.TreesAndGraphs;

import java.util.ArrayList;

public class GraphNode {
    public String name;
    public ArrayList<GraphNode> edges;
    public boolean visited = false;

    public GraphNode(String s) {
        name = s;
        edges = new ArrayList<>();
    }

    public void addEdge(GraphNode gn) {
        edges.add(gn);
    }
}
