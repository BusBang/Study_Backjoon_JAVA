import java.io.*;
import java.util.*;

public class Main {
    // BOJ 1302 – 베스트셀러
    //🧭 문제 요약
    //입력
    //오늘 팔린 책 제목이 N개 주어짐 (중복 가능)
    //출력
    //가장 많이 팔린 책 제목
    //여러 개가 같다면 사전순으로 가장 앞선 제목 출력

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            map.put(title, map.getOrDefault(title, 0) + 1);
        }

        String best = "";
        int max = 0;

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String title = e.getKey();
            int count = e.getValue();

            if (count > max) {
                best = title;
                max = count;
            } else if (count == max && title.compareTo(best) < 0) {
                // 사전 순보다 앞인가 ?
                best = title;
            }
        }
        System.out.println(best);

    }

}
