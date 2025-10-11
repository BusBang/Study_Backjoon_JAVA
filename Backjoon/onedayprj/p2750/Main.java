import java.util.*;
import java.io.*;

public class Main {
    // 🩵 STEP 2 — 정렬
    //
    //📘 문제 : BOJ 2750 – 수 정렬하기
    //
    //🧩 문제 요약
    //
    //N개의 수를 오름차순으로 정렬해 출력하라.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        // Arrays.sort(arr, Collections.reverseOrder()); // 내림차순
        for (int n : arr) System.out.println(n);

    }
}
