import java.util.*;

public class Solution {
    // 거리두기 확인하기
    // ✅ 문제 요약
    //
    //5×5 크기의 대기실이 여러 개 있음.
    //각 칸은
    //P : 사람
    //O : 빈 자리
    //X : 파티션
    //
    //거리두기 규칙:
    //→ 모든 사람은 맨해튼 거리 2 이하에 다른 사람이 있으면 안 된다.
    //단, 중간에 X(파티션)이 있으면 괜찮음.
    //즉,“각 사람(P) 기준으로 BFS(깊이 2까지) 돌렸을 때, 다른 P를 만나면 위반.”
    //
    //✅ BFS 접근 요약
    //5×5 격자 전체 탐색
    //P(사람) 발견 시 → BFS 시작 (깊이 ≤ 2)
    //다른 P 만나면 → 바로 실패 (return 0)
    //모든 P에서 문제없으면 → 성공 (return 1)
    static final int[] dy = {-1, 1, 0, 0};
    static final int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        Solution sol = new Solution();
        int[] result = sol.solutions(places);
        System.out.println(Arrays.toString(result));
    }

    public int[] solutions(String[][] places) {
        int[] answer = new int[places.length];
        for (int t = 0; t < places.length; t++) {
            char[][] map = new char[5][5];
            for (int i = 0; i < 5; i++) {
                map[i] = places[t][i].toCharArray();
            }
            answer[t] = check(map) ? 1 : 0;
        }
        return answer;
    }

    static boolean check(char[][] map) {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (map[y][x] == 'P') {
                    if (!bfs(map, y, x)) return false;
                }
            }
        }
        return true;
    }
    static boolean bfs(char[][] map, int sy, int sx) {

        boolean[][] visited = new boolean[5][5];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sy, sx, 0});
        visited[sy][sx] = true;

        while(!q.isEmpty()) {
            int[] cur = q.removeFirst();
            int y = cur[0];
            int x = cur[1];
            int dist = cur[2];
            if (dist >= 2) continue;

            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (ny >= 5 || ny < 0 || nx < 0 || nx >= 5) continue;
                if (visited[ny][nx] || map[ny][nx] == 'X') continue;
                if (map[ny][nx] == 'P') return false; // 위반
                visited[ny][nx] = true;
                q.add(new int[]{ny, nx, dist + 1});
            }
        }
        return true;
    }
}
