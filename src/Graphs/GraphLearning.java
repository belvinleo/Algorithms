package Graphs;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GraphLearning {
    private static class GraphWithList{
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer, List<int[]>> weightedGraph = new HashMap<>(); // Each int[] is {neighbor, weight}

        // Add an edge between u and v
        public void addEdgeUndirected(int u, int v) {
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // For undirected graph
        }

        public void addEdgeDirected(int u, int v){
            adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        // Print the adjacency list
        public void printList() {
            for (int node : adjList.keySet()) {
                System.out.print(node + " -> " + adjList.get(node));
                System.out.println();
            }
        }
    }

    private class GraphWithMatrix{
        int[][] adjMatrix;
        int numNodes;

        public GraphWithMatrix(int n) {
            this.numNodes = n;
            adjMatrix = new int[n][n];
        }

        public void addEdgeUndirected(int u, int v) {
            adjMatrix[u][v] = 1;
            adjMatrix[v][u] = 1; // For undirected graph
        }

        public void addEdgeDirected(int u, int v){
            adjMatrix[u][v] = 1;
        }

        public void addEdgeWeighted(int u, int v, int weight) {
            adjMatrix[u][v] = weight;
            adjMatrix[v][u] = weight; // Omit this line for directed graphs
        }

        public void printMatrix() {
            for (int i = 0; i < numNodes; i++) {
                for (int j = 0; j < numNodes; j++) {
                    System.out.print(adjMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        GraphLearning.GraphWithList graph = new GraphWithList();

        graph.addEdgeUndirected(0, 1);
        graph.addEdgeUndirected(0, 2);
        graph.addEdgeUndirected(1, 3);
        graph.addEdgeUndirected(2, 3);
        graph.addEdgeUndirected(3, 4);
    }
}
