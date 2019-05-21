package Questions.TreesAndGraphs;

import Questions.IQuestion;

import java.util.Stack;

public class RouteBetweenNodes implements IQuestion {
    @Override
    public void run() {
        GraphNode s = new GraphNode("S");
        GraphNode e = new GraphNode("E");
        GraphNode a = new GraphNode("A");
        GraphNode b = new GraphNode("B");
        GraphNode c = new GraphNode("C");
        GraphNode d = new GraphNode("D");

        b.addEdge(e);
        c.addEdge(a);
        c.addEdge(b);
        d.addEdge(a);
        d.addEdge(c);
        s.addEdge(c);

        boolean route = hasRoute(s, e);
        System.out.println(route);
    }

    private static boolean hasRoute(GraphNode gn1, GraphNode gn2) {
        Stack<GraphNode> stack = new Stack<>();
        gn1.visited = true;
        stack.push(gn1);

        while (!stack.empty()) {
            GraphNode gn = stack.pop();
            if (gn.name.equals(gn2.name)) {
                return true;
            }
            for (GraphNode edgeNode : gn.edges) {
                if (!edgeNode.visited) {
                    edgeNode.visited = true;
                    stack.add(edgeNode);
                }
            }
        }

        return false;
    }
}
