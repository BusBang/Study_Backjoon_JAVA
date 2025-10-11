import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 👉 BOJ 2470 – 두 용액 (투 포인터 알고리즘 기본기).
        //
        //🧭 문제 요약
        //산성 용액(양수)과 알칼리 용액(음수)이 섞였을 때
        //→ 두 용액을 섞은 값이 0에 가장 가까운 조합을 찾아라.
        // 개념	설명
        //투 포인터 (Two Pointers)	정렬된 배열의 양 끝에서 시작 → 합에 따라 포인터 이동
        //정렬이 전제 조건	오름차순 정렬 후, 양 끝 비교
        //시간복잡도	O(N log N) (정렬) + O(N) (탐색) = O(N log N)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);   // 오름차순 정렬

        int left = 0;
        int right = N - 1;
        int minSum = Integer.MAX_VALUE; // 최소 절댓값
        int ansL = 0;
        int ansR = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            int absSum = Math.abs(sum);

            if (absSum < minSum) {
                minSum = absSum;
                ansL = arr[left];
                ansR = arr[right];
            }

            if (sum > 0) right--;   // 합이 향수면 오른쪽 값을 줄여야 함
            else left++;            // 합이 음수면 왼쪽 값을 키워야 함.
        }
        System.out.println(ansL + " " + ansR);

    }
}
