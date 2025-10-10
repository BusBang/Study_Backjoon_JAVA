import java.util.*;
// stay[i]: i번 스테이지에 멈춰 있는 인원 수.
// reach: i번 스테이지에 도달한 인원 수(처음엔 전체 인원, i를 지나며 감소).
// 실패율 fail[i] = stay[i] / reach (reach=0이면 0).
// 실패율 내림차순, 같으면 스테이지 번호 오름차순으로 정렬해 인덱스 반환.
public class Solution {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(5, new int[] {2,1,2,6,2,4,3,3})));
    }

    public int[] solution(int N, int[] stages) {
        int[] stay = new int[N+2];  // N+1 (모두 클리어)까지 들어올 수 있음.
        for (int s : stages) stay[s]++;

        int total = stages.length;      // reach 도달 인원
        double[] fail = new double[N+1];    // 1~N만 사용
        for (int i = 1; i <= N; i++) {
            fail[i] = (total == 0) ? 0.0 : (double) stay[i] / total;
            total -= stay[i];           // 다음 스테이지 reach 갱신
        }

        Integer[] order = new Integer[N];
        for (int i = 0; i < N; i++) order[i] = i + 1;

        Arrays.sort(order, (a, b) -> {
            if (fail[b] == fail[a]) return Integer.compare(a, b);   // 번호 오름차순
            return  Double.compare(fail[b], fail[a]);       // 실패율 내림차순
        });

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) ans[i] = order[i];
        return ans;
    }
}
