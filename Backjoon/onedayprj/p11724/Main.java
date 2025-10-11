import java.io.*;
import java.util.*;

public class Main {
    // 11724 - 연결 요소의 개수
    // 문제
    //방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
    //입력
    //첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
    //
    //출력
    //첫째 줄에 연결 요소의 개수를 출력한다.

    // 🔎 포인트 & 자주 하는 실수
    //1-based 입력 → new ArrayList[N+1], visited = new boolean[N+1]
    //양방향 간선 → g[u].add(v)와 g[v].add(u) 둘 다
    //간선이 0개여도 각 정점은 자기 자신만의 요소 → 답은 N
    //(선택) 정렬: 출력과 무관하지만, 탐색 순서를 통일하려면 Collections.sort(g[i]) 가능
    //N이 커질 경우 재귀 DFS는 스택 제한 이슈가 있을 수 있으므로 BFS나 반복 DFS로 대체 가능
    //🧭 0-based vs 1-based 정리 한 번 더
    //문제에서 노드가 1~N이면 → 1-based로 선언하는 게 실수 적음
    //**격자/배열 문제(미로 등)**는 보통 0-based (new int[N][M])가 자연스러움

    static ArrayList<Integer>[] g;
    static boolean[] visited;

    static void dfs(int u) {
        visited[u] = true;
        for (int v : g[u]) {
            if (!visited[v]) dfs(v);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i <M ;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g[u].add(v);
            g[v].add(u);
        }

        visited = new boolean[N+1];
        int components = 0;

        for (int i = 1; i <= N; i++) {
           if(!visited[i]) {
               components++;
               dfs(i);
           }
        }
        System.out.println(components);
    }
}
