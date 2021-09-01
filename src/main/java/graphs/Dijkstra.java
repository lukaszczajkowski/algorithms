package graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dijkstra {

    public static int[] dijkstraAlgorithm(int start, int[][][] edges) {
        int numOfVertices = edges.length;
        int[] shortestPaths = new int[numOfVertices];
        Arrays.fill(shortestPaths, Integer.MAX_VALUE);
        shortestPaths[start] = 0;

        Set<Integer> visited = new HashSet<>();

        while (visited.size() != numOfVertices) {
            int vertexWithShortestPath = findVertixWithShortestPath(shortestPaths, visited);

            if (vertexWithShortestPath == -1) {
                break;
            }

            int currentVertexDistance = shortestPaths[vertexWithShortestPath];

            visited.add(vertexWithShortestPath);

            for (int[] edge : edges[vertexWithShortestPath]) {
                int destinationVertex = edge[0];
                int destinationVertexDistance = edge[1];
                int potentialNewDistance = currentVertexDistance + destinationVertexDistance;
                int currentDestinationShortestDistance = shortestPaths[destinationVertex];

                if (!visited.contains(destinationVertex) && potentialNewDistance < currentDestinationShortestDistance) {
                    shortestPaths[destinationVertex] = potentialNewDistance;
                }
            }
        }

        return calculateFinalShortestPaths(shortestPaths);
    }

    private static int[] calculateFinalShortestPaths(int[] shortestPaths) {
        int[] finalShortestPaths = new int[shortestPaths.length];

        for (int vertex = 0; vertex < finalShortestPaths.length; vertex++) {
            finalShortestPaths[vertex] = shortestPaths[vertex];

            if (shortestPaths[vertex] == Integer.MAX_VALUE) {
                finalShortestPaths[vertex] = -1;
            }
        }

        return finalShortestPaths;
    }

    private static int findVertixWithShortestPath(int[] shortestPaths, Set<Integer> visited) {
        int shortestPath = Integer.MAX_VALUE;
        int vertex = -1;

        for (int currentVertex = 0; currentVertex < shortestPaths.length; currentVertex++) {
            if (!visited.contains(currentVertex) && shortestPaths[currentVertex] < shortestPath) {
                shortestPath = shortestPaths[currentVertex];
                vertex = currentVertex;
            }
        }

        return vertex;
    }
}
