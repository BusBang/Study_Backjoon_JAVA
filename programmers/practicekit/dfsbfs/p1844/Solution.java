import java.util.*;

public class Solution {

    public static void main(String[] args)throws Exception {
        Solution sol = new Solution();
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(sol.solution(maps));
    }

    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        int[][] dist = new int[n][m];
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        if(maps[0][0] == 0) return -1;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];
            if (y == n - 1 && x == m - 1) return dist[y][x];

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (0 <= ny
                        && ny < n
                        && 0 <= nx
                        && nx < m
                        && maps[ny][nx] == 1
                        && dist[ny][nx] == 0) {
                    dist[ny][nx] = dist[y][x] + 1;
                    q.offer(new int[]{ny, nx});
                }
            }
        }
        return -1;
    }
}
