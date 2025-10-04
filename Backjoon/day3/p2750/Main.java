import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 2750 수 정렬하기 1
        // 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다.
        // 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다.
        // 수는 중복되지 않는다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);   // 오름차순 정렬

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append('\n');
        }

        System.out.println(sb);





    }
}
