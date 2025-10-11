import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        // 카드 숫자 카운팅
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 쿼리 숫자에 대한 카운트 출력
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(x, 0)).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}
