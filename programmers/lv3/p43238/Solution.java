import java.util.*;

    // 입국 심사
    // 프로그래머스 43238 - 이분 탐색
    // 시간 t를 잡으면, 각 심사대가 처리 가능한 인원 수는 t / times[i].
    //모든 심사대 합 sum(t / times[i])가 N 이상이면 그 시간 t는 가능(충분), 아니면 불가능.
    //따라서 t를 이분 탐색: 가능한 최소 시간을 찾기.
public class Solution {

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.solution(6, new int[]{7,10})); // 28
        System.out.println(sol.solution(1, new int[]{1}));    // 1
        System.out.println(sol.solution(10, new int[]{6,8,10})); // 24
    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long left = 0L;  // 최소시간
        long right = (long) times[times.length - 1]*n;  // 최악 : 가장 느린 심사대 혼자 처리
        long ans = right;

        while (left <= right) {
            long mid = (left + right) >>> 1;    // 중간 시간(오버플로 예방)
            if (canProcess(n, times, mid)) {
                ans = mid;          // 가능하면 더 줄여보기
                right = mid - 1;
            } else {
                left = mid + 1;     // 불가능 하면 시간을 늘림
            }
        }
        return ans;
    }
    private boolean canProcess(int n, int[] times, long t) {
        long done = 0;
        for (int time : times) {
            done += t / time;
            if (done >= n) return true; // 미리 끊어 최적화
        }
        return false;
    }

}
