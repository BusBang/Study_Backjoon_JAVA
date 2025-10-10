import java.io.*;
import java.util.*;

public class Main {
    // BOJ 14226 – 이모티콘을 하면
    //👉 “1차원 BFS + 상태를 두 개 (화면, 클립보드)”로 확장하는 연습이 딱 됩니다.
    //화면에 이모티콘이 1개 있음.
    //
    //가능한 행동 3가지:
    //1️⃣ 복사 – 현재 화면의 이모티콘을 클립보드에 복사
    //2️⃣ 붙여넣기 – 클립보드 내용을 화면에 추가
    //3️⃣ 삭제 – 화면에서 이모티콘 1개 삭제
    //
    //목표: S 개의 이모티콘을 만드는 최소 시간 (각 행동 = 1초)
    //🧩 핵심 아이디어
    //
    //이건 단순 1차원이 아니라, 상태가 두 개 필요해요.
    //하나는 화면 이모티콘 개수(screen),
    //하나는 클립보드 이모티콘 개수(clip).
    //👉 즉 그래프의 한 노드는 (screen, clip) 쌍이에요.

    static int S;
    static boolean[][] visited;
    static int[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        System.out.println(bfs());

    }
    static int bfs() {
        visited = new boolean[2001][2001];
        dist = new int[2001][2001];

        // 시작 고정
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 0}); // 화면 1개, 클립보드 0
        visited[1][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int screen = cur[0];
            int clip = cur[1];

            // 목표 달성
            if (screen == S) return dist[screen][clip];

            // 1. 복사
            if (!visited[screen][screen]) {
                visited[screen][screen] = true;
                dist[screen][screen] = dist[screen][clip] + 1;
                q.add(new int[]{screen, screen});
            }
            // 2. 붙여넣기
            if (clip > 0 && screen + clip <= 2000 && !visited[screen+clip][clip]) {
                visited[screen + clip][clip] = true;
                dist[screen + clip][clip] = dist[screen][clip] + 1;
                q.add(new int[]{screen + clip, clip});
            }
            // 3. 삭제
            if (screen > 0 && !visited[screen - 1][clip]) {
                visited[screen - 1][clip] = true;
                dist[screen - 1][clip] = dist[screen][clip] + 1;
                q.add(new int[]{screen - 1, clip});
            }
        }
        return -1;
    }
}
