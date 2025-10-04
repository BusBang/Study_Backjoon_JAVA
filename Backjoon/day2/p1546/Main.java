import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] scores = new int[N];
        int max = 0;
        double sum = 0;

        for (int i = 0; i < N; i++) {
            // 만약 토큰이 부족하면 다음 줄에서 이어서 읽기
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            scores[i] = Integer.parseInt(st.nextToken());
            if (scores[i] > max) max = scores[i];
        }

        for (int i = 0; i < N; i++) {
            sum += (double) scores[i] / max * 100.0;
        }

        System.out.println(sum / N);
    }
}
