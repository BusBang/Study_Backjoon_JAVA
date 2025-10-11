import java.io.*;
import java.util.*;

public class Main {
    // STEP 1 — 입출력 & 문자열 기초
    //📘 문제 : BOJ 11720 – 숫자의 합
    //🧩 문제 요약
    //정수 N 과 N자리 숫자가 주어질 때 각 자리 수의 합을 구하라.

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += str.charAt(i) - '0'; // 문자 -> 숫자 변환
        }
        System.out.println(sum);
    }
}
