import java.util.*;

public class Solution {
    public static void main(String[] args) throws  Exception{
        Solution sol = new Solution();
        System.out.println(sol.solution(3, new int[][] {{1,1,0}, {1,1,0}, {0,0,1}}));
    }

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int compnents = 0;
        for (int i=0; i < n; i++) {
            if(!visited[i]) {
                compnents++;
                dfs(i, n, computers, visited);
            }
        }
        return compnents;
    }

    private void dfs(int u, int n, int[][] g, boolean[] visited) {
        visited[u] = true;
        for (int v = 0; v < n; v++) {
            if(g[u][v] == 1 && !visited[v]) dfs(v, n, g, visited);
        }
    }
}
