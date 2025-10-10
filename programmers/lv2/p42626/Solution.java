package lv2.p42626;

import java.util.*;
// 더 맵게 (42626) — 최소 힙
// 핵심: 가장 안 매운 두 개를 뽑아 섞기 → new = a + 2*b → 다시 삽입. 가장 작은 값이 K 이상 될 때까지 반복.
public class Solution {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
    }
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : scoville) pq.add(x);

        int cnt = 0;
        while (!pq.isEmpty() && pq.peek() < K) {
            if (pq.size() < 2) return -1;   // 더 못 섞음
            int a = pq.poll(), b = pq.poll();
            pq.add(a + 2*b);
            cnt++;
        }
        return cnt;
    }
}
