package T332;

import java.util.*;

/*
Seven bridges problem.
 */
public class Solution {

    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> neighbors = new HashMap<>();
        LinkedList<String> routes = new LinkedList<>();
        for (String[] ticket: tickets)
            neighbors.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        visit("JFK", neighbors, routes);
        return routes;
    }

    private void visit(String airport, Map<String, PriorityQueue<String>> neighbors, LinkedList<String> routes) {
        while (neighbors.containsKey(airport) && !neighbors.get(airport).isEmpty())
            visit(neighbors.get(airport).poll(), neighbors, routes);
        routes.addFirst(airport);
    }

}
