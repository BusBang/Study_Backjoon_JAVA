import java.io.*;
import java.util.*;

public class Main {
    //문제
    //N×M크기의 배열로 표현되는 미로가 있다.
    //
    //1 0	1	1	1	1
    //1	0	1	0	1	0
    //1	0	1	0	1	1
    //1	1	1	0	1	1
    //미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때,
    // (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
    // 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
    //위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
    //입력
    //첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
    //출력
    //첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

    // 🤔 “DFS 문제를 BFS로 풀면 메모리 걱정이 덜한가?”
    //케이스에 따라 다름이에요.
    //BFS 메모리: “한 레벨(프런티어)에 있는 노드 전부”를 큐에 저장 → 분기(너비)가 큰 그래프면 메모리 많이 먹음.
    //DFS 메모리: 현재 경로(깊이)만 스택/재귀로 저장 → 깊이가 깊으면 재귀 스택 위험(스택 오버플로).
    //
    //요약
    //**최단거리(무가중치)**가 필요하면 → BFS가 정답.
    //연결성/갯수 세기면 둘 다 가능. (깊이가 깊으면 반복형 DFS 추천)
    //상태공간이 넓은 탐색이면 DFS가 보통 메모리는 더 적게 듦.
    //실무 팁: 자바는 재귀 제한 때문에 ArrayDeque로 반복형 DFS/BFS 쓰면 안전+빠름

    // ✅ 풀이 아이디어
    //BFS로 격자 최단거리: dist[y][x] = dist[cur]+1
    //방문 체크(visited) 또는 dist != 0로 재방문 방지

    static int N, M;
    static int[][] map;     // 미로 정보
    static int[][] dist;    // 0 이면 미방문
    static final int[] dy = {-1, 1, 0, 0};  // 위, 아래, 왼, 오른쪽의 y 변화
    static final int[] dx = {0, 0, -1, 1};  // 위, 아래, 왼, 오른쪽의 x 변화

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';    // 숫자 변환
                dist[i][j] = -1;    // 방문/벽 구분
            }
        }

        System.out.println(bfs(0, 0));
    }
    static int bfs(int sy, int sx) {
        if (map[sy][sx] == 0) return 0; // 시작이 벽이면 불가능.

        ArrayDeque<int[]> q = new ArrayDeque<>();
        // 나의 위치는 startY, startX 이고, 이동한 거리는 1칸.
        dist[sy][sx] = 1;   // 시작 칸에서 출발
        q.add(new int[]{sy, sx});

        while (!q.isEmpty()) {
            // queue에서 다음으로 이동할 칸(y,x)를 꺼내온다.
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];

            // 도착 즉시 반환
            if (y == N - 1 && x == M - 1) return dist[y][x];

            // 상하좌우 4방향으로 한 칸씩 탐색
            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];   // 상하로 한 칸 가기
                int nx = x + dx[dir];   // 좌우로 한 칸 가기

                // 배열 밖으로 가면 안 됨
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                // 벽
                if (map[ny][nx] == 0) continue;
                // 이미 방문
                if (dist[ny][nx] != -1) continue;

                // (ny, nx)까지 거리는 현재 거리 +1 이고, 다음에 이 칸도 탐색해야하니 큐에 넣기
                dist[ny][nx] = dist[y][x] + 1;  // 한 칸 더 갔으니까 거리 +1
                q.add(new int[]{ny, nx});   // 다음 순서에 이 칸도 재 탐색해보기
            }
        }
        return 0; // 도착 불가
    }



}
