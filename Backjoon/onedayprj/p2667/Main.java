import java.io.*;
import java.util.*;

public class Main {
    // 백준 2667 단지번호붙이기
    //풀이 아이디어 (BFS)

    //지도는 N x N(1과 0으로 구성).
    //상하좌우로 연결된 1들의 연결요소를 각각 단지로 본다.
    //모든 칸을 훑다가 아직 방문하지 않은 1을 만나면 BFS 시작 → 해당 단지의 집 수를 센다.
    //모든 단지 크기를 모아 오름차순 정렬해서 출력.
    //복잡도: O(N^2) (각 칸을 최대 한 번씩만 방문)
    //
    //실수 포인트 체크
    //입력이 줄 단위 문자열이므로 board[y][x] = line[x] - '0' 형태로 파싱.
    //방문 체크는 큐에 넣을 때 바로 하기(중복 방지).
    //범위 체크는 0 <= ny < N & 0 <= nx < N.
    //
    //출력은
    //단지 수
    //각 단지 크기 (오름차순, 줄바꿈)
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int y=0; y < N; y++) {
            String line = br.readLine().trim();
            for (int x = 0; x < N; x++) {
                board[y][x] = line.charAt(x) - '0';
            }
        }

        visited = new boolean[N][N];
        List<Integer> sizes = new ArrayList<>();

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[y][x] && board[y][x] == 1) {
                    sizes.add(bfs(y, x));
                }
            }
        }
        Collections.sort(sizes);

        StringBuilder sb = new StringBuilder();
        sb.append(sizes.size()).append('\n');
        for (int s : sizes) sb.append(s).append('\n');
        System.out.println(sb.toString());
    }

    static int bfs(int sy, int sx) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sy, sx});
        visited[sy][sx] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int y = cur[0], x = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (ny < 0 || ny >= N || nx >= N || nx < 0) continue;
                if (visited[ny][nx]) continue;
                if (board[ny][nx] == 0) continue;

                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});
                cnt++;
            }
        }
        return cnt;
    }
}
