package T133;

import java.util.*;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}

public class Solution {

    private Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(node, cloneNode);
        for (UndirectedGraphNode neighbor: node.neighbors) {
            if (!map.containsKey(neighbor))
                map.put(neighbor, cloneGraph(neighbor));
            cloneNode.neighbors.add(map.get(neighbor));
        }
        return cloneNode;
    }

    public static void main(String[] args) {
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node0);
        node1.neighbors.add(node0);
        node2.neighbors.add(node0);
        node2.neighbors.add(node1);
        node2.neighbors.add(node2);
        UndirectedGraphNode cnode0 = new Solution().cloneGraph(node0);
        System.out.println(cnode0.neighbors.size());
        System.out.println(cnode0.neighbors.get(0).neighbors.size());
        System.out.println(cnode0.neighbors.get(1).neighbors.size());
    }
}
