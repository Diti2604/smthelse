import java.util.*;

class Node {
    public int val;
    public List<Node> neighbours;

    public Node() {
        val = 0;
        neighbours = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbours = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbours) {
        val = _val;
        neighbours = _neighbours;
    }
}

class cloneGraphEx {
    Node[] nodes = new Node[101];

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        nodes[node.val] = new Node(node.val);

        for (var neighbor : node.neighbours) {
            if (nodes[neighbor.val] == null)
                cloneGraph(neighbor);

            nodes[node.val].neighbours.add(nodes[neighbor.val]);
        }
        return nodes[node.val];
    }
}