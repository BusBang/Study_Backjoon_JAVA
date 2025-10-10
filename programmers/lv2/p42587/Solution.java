import java.util.*;
// 프로그래머스 42587 — 프린터
// 용어
//최대 힙(Max-Heap) 방식: 현재 큐에 남아 있는 문서들 중 가장 큰 우선순위를 O(log n)에 뽑아보는 구조야. 자바에선 PriorityQueue<>(reverseOrder()).
//힙: 각 인쇄마다 poll()로 O(log n)
//포인터: 카운팅 배열에서 cnt[9]..cnt[1]만 확인 → 갱신도 최악 9번만 아래로 이동
//→ 전체가 사실상 **O(n)**로 떨어짐. (회전은 ArrayDeque로 O(1))

//최대 힙 방식 추천:
//우선순위 값의 범위가 넓거나 가변적일 때 (예: 임의의 큰 정수들)
//카운팅 배열을 만들기 곤란하거나 범위가 불명확할 때
//구현을 더 직관적으로 하고 싶을 때(로직이 눈에 잘 보임)
public class Solution {

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        // 공식 예시
        System.out.println(sol.solution(new int[]{2,1,3,2}, 2)); // 1
        System.out.println(sol.solution(new int[]{1,1,9,1,1,1}, 0)); // 5
    }

    public int solution(int[] priorities, int location) {
        // 최대 힙 방식 O(n log n)
        ArrayDeque<int[]> q = new ArrayDeque<>();   // {index, priority}
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            q.addLast(new int[]{i, priorities[i]});
            maxHeap.add(priorities[i]);
        }
        int printed = 0;
        while (!q.isEmpty()) {
            int[] cur = q.removeFirst();    // {인덱스, 우선순위}
            int idx = cur[0], pri = cur[1];

            if (pri < maxHeap.peek()) {
                q.addLast(cur);
            } else {
                printed++;
                maxHeap.poll();
                if (idx == location) return printed;
            }
        }
        return printed;
    }

}
