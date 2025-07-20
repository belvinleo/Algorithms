package Graphs;

import java.util.*;

public class GraphTraversal {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    public void addEdge(int u, int v){
        adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    }

    void BFS(int start){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.offer(start);

        while (!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node + " ");
            for(int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }

//            for (int neighbor = 0; neighbor < matrix.length; neighbor++) {
//                if (matrix[node][neighbor] == 1 && !visited[neighbor]) {
//                    visited[neighbor] = true;
//                    queue.offer(neighbor);
//                }
//            }

        }
        System.out.println();
    }

    void DFS(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);
        System.out.println();
    }

    void dfsHelper(int node, Set<Integer> visited) {
        visited.add(node);
        System.out.print(node + " ");

        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }

//        for (int neighbor = 0; neighbor < matrix.length; neighbor++) {
//            if (matrix[node][neighbor] == 1 && !visited[neighbor]) {
//                dfsHelper(neighbor, visited, matrix);
//            }
//        }

    }

    public static void main(String[] args) {
        GraphTraversal graph = new GraphTraversal();

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.BFS(0);
        graph.DFS(0);
    }
}
