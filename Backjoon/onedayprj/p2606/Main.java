import java.util.*;
import java.io.*;

public class Main {
    // BOJ 2606 - virus

    // 입력
    // 첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
    // 둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
    // 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
    //
    // 출력
    // 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
    // 문제 요약
    //
    //1번 컴퓨터가 바이러스에 걸림.
    //네트워크 연결 정보가 주어질 때, 1번과 연결되어 감염되는 컴퓨터 수(1번 제외) 출력.
    //입력
    //첫 줄: 컴퓨터 수 N (1 ≤ N ≤ 100)
    //둘째 줄: 간선 수 M
    //다음 M줄: a b (양방향 연결)
    //✅ 개념 포인트
    //
    //그래프 표현: 인접 리스트 ArrayList<Integer>[]
    //탐색 방법: DFS(재귀) 또는 BFS(큐) — 둘 다 정답
    //방문 배열: boolean[] visited로 중복 방지
    //정답: 1번에서 시작해 도달 가능한 노드 수 − 1

    // 🧠 알아둘 함수/개념
    //
    //ArrayList<Integer>[] g : 인접 리스트 (메모리 효율↑)
    //visited[] : 중복 방문 방지 (무한루프 예방)
    //DFS: 깊이 우선 (재귀로 자연스럽게 구현)
    //BFS: 너비 우선 (큐 사용, 레벨 탐색에 강함)
    //
    //⚠️ 실수 방지
    //인덱스 1부터 사용 → 배열 크기 N+1
    //양방향 간선 → g[a].add(b), g[b].add(a) 둘 다
    //출력은 1번 제외한 개수임에 주의

    static ArrayList<Integer>[] g;
    static boolean[] visited;
    static int infected = 0;

    static void dfs(int u) {
        visited[u] = true;
        infected++;
        for (int v : g[u]) {
            if(!visited[v]) dfs(v);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b);
            g[b].add(a);
        }

        visited = new boolean[N + 1];
        dfs(1);

        System.out.println(infected - 1);   // 1번 제외
    }

}
