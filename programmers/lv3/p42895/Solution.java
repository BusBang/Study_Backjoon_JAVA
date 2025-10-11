import java.util.*;

// N으로 표현 (프로그래머스 42895)
//핵심 아이디어
//dp[k]: 숫자 N을 정확히 k번 사용해 만들 수 있는 수들의 집합(Set).
//각 k에서 i + (k-i)로 분할, dp[i]와 dp[k-i]의 사칙연산 조합을 모두 합친다.
//매 단계 concat = N, NN, NNN, ...(k개 이어붙인 수)도 넣는다.
//k=1..8에서 목표 수가 나오면 k 반환.
//상태/점화식(집합 DP)
//dp[1] = {N}
//dp[k] = {concat(N,k)} ∪ (연산(dp[i], dp[k-i])의 모든 결과)

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.solution(5, 12));
    }
    public int solution(int N, int number) {
        if (N == number) return 1;
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i<=8; i++) dp.add(new HashSet<>());

        int concat = 0;
        for (int k = 1; k <= 8; k++) {
            concat = concat * 10 + N;   // N, NN, NNN ...
            Set<Integer> cur = dp.get(k);
            cur.add(concat);

            for (int i = 1; i < k; i++) {
                for (int a : dp.get(i)) {
                    for (int b : dp.get(k -  i)) {
                        cur.add(a + b);
                        cur.add(a - b);
                        cur.add(a * b);
                        if (b != 0) cur.add(a / b);
                    }
                }
            }
            if (cur.contains(number)) return k;
        }
        return -1;
    }
}
