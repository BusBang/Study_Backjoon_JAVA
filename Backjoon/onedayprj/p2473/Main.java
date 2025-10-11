import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // BOJ 2473 – 세 용액 (Three Solutions)
        // 세 용액을 혼합했을 때 0에 가장 가까운 합을 만들어내는 세 수를 구하라.
        //
        //개념 설명
        //투 포인터 확장판	기준 하나 고정 + 나머지 두 개를 투포인터로 탐색
        //시간복잡도	O(N²) (N ≤ 5000 → 충분히 가능)
        //정렬 필수	오름차순 정렬 후 조합 찾기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];   // int를 초과할 수 있으니까.

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long minSum = Long.MAX_VALUE;
        long a = 0 , b = 0, c =0;

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];
                if (Math.abs(sum) < Math.abs(minSum)) {
                    minSum = sum;
                    a = arr[i];
                    b = arr[left];
                    c = arr[right];
                }
                if (sum > 0) right--;
                else left++;
            }
        }
        System.out.println(a + " " + b + " " + c);

    }
}
