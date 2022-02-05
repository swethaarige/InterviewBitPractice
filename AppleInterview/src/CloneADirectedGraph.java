import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given the root node of a directed graph, clone this graph by creating its deep copy so that the
cloned graph has the same vertices and edges as the original graph.
Let’s look at the below graphs as an example. If the input graph is G = (V, E) where V is
set of vertices and E is set of edges, then the output graph (cloned graph) G’ = (V’, E’)
such that V = V’ and E = E’.
Hint Hash table Depth first traversal
Runtime Complexity
Linear, O(n).

Memory Complexity
Logarithmic, O(n). ‘n’ is the number of vertices in the graph.
Solution Breakdown
We use depth-first traversal and create a copy of each node while traversing the graph.
To avoid getting stuck in cycles, we’ll use a hashtable to store each completed node and
will not revisit nodes that exist in the hashtable. The hashtable key will be a node in
the original graph, and its value will be the corresponding node in cloned graph.
 */
public class CloneADirectedGraph {
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        Node pNew = new Node(node.name);
        map.put(node, pNew);

        for(Node neighbor: node.children){
            if(map.containsKey(neighbor)){
                map.get(node).children.add(map.get(neighbor));
            }else{
                map.get(node).children.add(cloneGraph(neighbor));
            }
        }

        return map.get(node);
    }
}
