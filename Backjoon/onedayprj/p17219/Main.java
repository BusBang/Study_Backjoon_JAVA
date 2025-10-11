import java.io.*;
import java.util.*;

public class Main {
    // BOJ 17219 – 비밀번호 찾기 (HashMap 기본기)
    //🧭 문제 요약
    //입력:
    //N (저장할 사이트 수), M (질의 수)
    //N줄: site password
    //M줄: site
    //출력: 각 질의 사이트의 비밀번호 한 줄씩
    //🧠 핵심 개념
    //개념	이유 / 포인트
    //HashMap<String,String>	사이트를 key로, 비밀번호를 value로 저장 → 평균 O(1) 조회
    //getOrDefault(key, default)	없는 키 조회 시 null 대신 기본값 반환 가능
    //입출력 최적화	BufferedReader + StringTokenizer + StringBuilder

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>(N * 2); // capacity 미리 부여
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String site =  st.nextToken();
            String pw = st.nextToken();
            map.put(site, pw);
        }
        for (int i = 0; i < M; i++) {
            String site = br.readLine();
            sb.append(map.get(site)).append('\n');
        }
        System.out.println(sb);
    }

}
