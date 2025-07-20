package Graphs;

public class GraphProblems {
    public int findCircleNum(int[][] isConnected){
        int n = isConnected.length;
        int provinces = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, isConnected, visited);
                provinces++;
            }
        }
        return provinces;
    }
    private void dfs(int city, int[][] isConnected, boolean[] visited){
        visited[city] = true;
        for(int neighbor = 0; neighbor < isConnected.length; neighbor++){
            if (isConnected[city][neighbor] == 1 && !visited[neighbor]){
                dfs(neighbor, isConnected, visited);
            }
        }
    }
}
