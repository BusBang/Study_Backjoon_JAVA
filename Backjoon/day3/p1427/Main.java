package day3.p1427;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
//        첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char[] arr = s.toCharArray();   // 문자 배열로 전환
        Arrays.sort(arr);   // 오름차순 정렬

        // char[] 를 String 으로 변환 후 StringBuilder 생성
        StringBuilder sb = new StringBuilder(new String(arr)).reverse();    // 내림차순 정렬

        System.out.println(sb);


    }
}
