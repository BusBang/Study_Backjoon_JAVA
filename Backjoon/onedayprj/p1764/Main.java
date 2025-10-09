import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 듣못사
        Set<String> unheard = new HashSet<>(N * 2);
        while (N-- >0) {
            unheard.add(br.readLine());
        }
        // 보못사, 공통은 교집합에 추가
        List<String> both = new ArrayList<>();
        while (M-- > 0) {
            String name = br.readLine();
            if (unheard.contains(name)) both.add(name);
        }

        // 정렬
        Collections.sort(both);
        // 출력
        sb.append(both.size()).append('\n');
        for (String name : both) {
            sb.append(name).append('\n');
        }
        System.out.println(sb);
    }
}
