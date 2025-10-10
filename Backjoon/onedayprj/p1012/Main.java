import java.io.*;
import java.util.*;

public class Main {
    // BOJ 1012 – 유기농 배추
    //2차원 BFS로 “몇 개의 덩어리가 있는지” 세는 문제.
    //(미로 탐색보다 한 단계 심화, 거리 대신 연결된 영역 개수)
    //
    //🧩 문제 요약
    //M×N 밭에 배추가 심어져 있고 (1은 배추, 0은 빈 땅).
    //서로 상하좌우로 인접한 배추들은 하나의 덩어리(군집).
    //밭 전체에서 군집 개수를 구하라.
    //즉, BFS로 연결된 영역 개수 세기 문제.
    // 핵심 아이디어
    //
    //미로처럼 map[y][x]를 만들고,
    //1인 곳을 발견하면 BFS로 연결된 모든 배추를 방문 처리 → 군집 +1.
    //상하좌우 탐색은 dy/dx 배열 재활용.

    static int M, N, K;
    static int[][] field;
    static boolean[][] visited;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // test case

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());   // row
            N = Integer.parseInt(st.nextToken());   // column
            K = Integer.parseInt(st.nextToken());   // cabbage num
            field = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void bfs(int sy, int sx) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[sy][sx] = true;
        q.add(new int[]{sy, sx});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (visited[ny][nx]) continue;
                if (field[ny][nx] == 0) continue;

                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});
            }
        }

    }

}
