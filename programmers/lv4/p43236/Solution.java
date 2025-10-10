import java.util.*;
// 징검다리 p43236
// 아이디어
// 최소 간격 m을 정해 놓고, 그보다 좁은 간격의 돌은 제거해본다(연속 거리 누적). 제거 개수가 n 이하면 m은 가능 ⇒ 더 키워본다.
public class Solution {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.solution(25, new int[] {2, 14, 11, 21, 17}, 2));
    }

    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        // 도착점 추가
        int[] pts = Arrays.copyOf(rocks, rocks.length + 1);
        pts[pts.length - 1] = distance;

        int left = 1, right = distance, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;    // 시도할 최소 간격 m
            if (canKeep(pts, n, mid)) {
                ans = mid;      // 이 간격은 가능 > 더 키워보자
                left = mid + 1;
            } else {
                right = mid - 1;    // 불가능하면 줄이자
            }
        }
        return ans;
    }
    // 최소 간격 minGap 을 유지하려면 최소 몇개의 바위를 제거해야 하는가?
    // 제거 수 <= n이면 가능
    private boolean canKeep(int[] pts, int n, int minGap) {
        int removed = 0, prev = 0;
        for (int p : pts) {
            if (p - prev < minGap) {
                removed++;  // 이 돌은 유지하면 너무 좁음. 간격이.
                if (removed > n) return false;
            } else {
                prev = p;
            }
        }
        return true;
    }
}
