import java.io.*;
import java.util.*;

public class Main_2 {
    // 🧭 STEP 5 — BOJ 10816 : 숫자 카드 2
    //
    //“내가 가진 숫자 카드 중 특정 숫자가 몇 장 있는지 구하는 문제”
    //
    //🎯 문제 요약
    //항목	내용
    //입력	N개의 카드 숫자 + M개의 쿼리 숫자
    //출력	각 쿼리 숫자가 카드에 몇 번 나왔는지
    //예시
    //입력	10
    //6 3 2 10 10 10 -10 -10 7 3
    //8
    //10 9 -5 2 3 4 5 -10
    //출력	3 0 0 1 2 0 0 2
    //🧠 문제 접근
    //① HashMap 카운팅 (코드 짧고 직관적)
    //② 이분탐색 (정렬 + upper/lower bound)

    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(upperBound(x) - lowerBound(x)).append(' ');
        }
        System.out.println(sb.toString().trim());

    }
    // 기존 이분 탐색
    //    static boolean binarySearch(int[] arr, int target) {
    //        int left = 0;
    //        int right = arr.length-1;
    //
    //        while (left <= right) {
    //            int mid = (left + right) / 2;
    //            if (arr[mid] == target) {
    //                return true;
    //            } else if (arr[mid] < target) {
    //                left = mid + 1;
    //            } else {
    //                right = mid - 1;
    //            }
    //        }
    //        return false;
    //    }
    static int lowerBound(int x) {
        int left = 0;
        int right = arr.length;
        while(left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= x) right = mid;
            else left = mid + 1;
        }
        return  left;
    }

    static int upperBound(int x) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return  left;
    }
}
