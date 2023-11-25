package DesignPattern;

import java.util.*;

public class ShortestPath {
    private Map<Integer, List<Integer>> graph;

    public ShortestPath() {
        this.graph = new HashMap<>();
    }

    public void addEdge(int src, int dest) {
        graph.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
        graph.computeIfAbsent(dest, k -> new ArrayList<>()).add(src);
    }

    public List<Integer> shortestPath(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> distance = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();

        queue.add(start);
        distance.put(start, 0);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph.getOrDefault(current, Collections.emptyList())) {
                if (!distance.containsKey(neighbor)) {
                    queue.add(neighbor);
                    distance.put(neighbor, distance.get(current) + 1);
                    parent.put(neighbor, current);

                    if (neighbor == end) {
                        // Reconstruct the shortest path
                        List<Integer> path = new ArrayList<>();
                        while (parent.containsKey(neighbor)) {
                            path.add(neighbor);
                            if(parent.get(neighbor)!=null){
                                neighbor =(int) parent.get(neighbor);
                            }
                        }
                        Collections.reverse(path);
                        return path;
                    }
                }
            }
        }

        return Collections.emptyList(); // No path found
    }

    public static void main(String[] args) {
        ShortestPath graphExample = new ShortestPath();

        // Adding edges to the graph
        graphExample.addEdge(0, 1);
        graphExample.addEdge(0, 2);
        graphExample.addEdge(1, 2);
        graphExample.addEdge(1, 3);
        graphExample.addEdge(2, 4);
        graphExample.addEdge(3, 4);

        int startNode = 0;
        int endNode = 4;

        List<Integer> shortestPath = graphExample.shortestPath(startNode, endNode);

        if (shortestPath.isEmpty()) {
            System.out.println("No path exists between " + startNode + " and " + endNode);
        } else {
            System.out.println("Shortest path from " + startNode + " to " + endNode + ": " + shortestPath);
        }
    }
}