import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 수 정렬하기 3
        // N(≤10,000,000)개의 수가 주어진다.
        // 모든 수는 10,000 이하의 자연수.
        // 오름차순으로 정렬해서 출력.
        // 메모리와 속도 제한이 매우 빡빡 (정렬 알고리즘 사용 시 메모리 초과)
        //→ 계수 정렬(Counting Sort) 로 풀어야 함.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] count = new int[10001];   // 값의 범위 1~10000에 맞춰 배열 생성.

        for (int i = 0; i < N; i++) {
            int num  = Integer.parseInt(br.readLine());
            count[num]++; // 등장 횟수 카운트
        }

        for (int i = 1; i <= 10000; i++) {
            while (count[i]-- > 0) {
                sb.append(i).append('\n');
            }
        }

        System.out.println(sb);




    }
}
