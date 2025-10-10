package lv3.p42884;

import java.util.*;
// 단속카메라 (42884) — 간격 그리디
//
//핵심: 진출 시점 기준 오름차순 정렬 후, 현재 카메라 위치 pos를 유지하다가 새 구간이 pos를 넘으면 카메라 추가.
public class Solution {

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};

        System.out.println(sol.solution(routes));
    }
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1])); // 진출 시점 오름차 순
        int cams = 0;
        int pos = Integer.MIN_VALUE;    // 마지막 카메라 위치

        for (int[] r : routes) {
            int in = r[0], out = r[1];
            if (in > pos) { // 현재 카메라로 못 잡음 -> 새 카메라 위치 조정
                cams++;
                pos = out;  // 구간의 끝에 설치
            }
        }
        return cams;
    }
}
