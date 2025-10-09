import java.util.*;
import java.io.*;

public class Main {
    // STEP 4 : BOJ 1920 : 수찾기
    // 정렬 + 이분탐색
    // 🎯 문제 요약
    //
    //N개의 정수가 주어졌을 때,
    //M개의 정수가 각각 배열 안에 존재하는지 확인하라.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);   // 이분 탐색을 위한 정렬

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(arr, target) ? 1 : 0).append('\n');
        }
        System.out.println(sb);



    }
    // 이분 탐색 함수
    static boolean binarySearch(int [] arr, int target) {
        int left = 0;
        int right = arr.length-1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return true;
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
