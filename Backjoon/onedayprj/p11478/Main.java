
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        //이제 해시 마지막 단계 — BOJ 11478 – 서로 다른 부분 문자열의 개수
        //(HashSet으로 문자열 중복 제거하기)
        //
        //🧭 문제 요약
        //
        //문자열 S가 주어질 때,
        //서로 다른 부분 문자열(substring) 의 개수를 구하라.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> subs = new HashSet<>();
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < str.length(); j++) {
                sb.append(str.charAt(j));
                subs.add(sb.toString());    // 중복 자동 제거
            }
        }
        System.out.println(subs.size());
    }
}
