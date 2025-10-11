import java.util.*;

// DP : DP는 “상태 정의 → 점화식(전이) → 초기값/경계 → 구현” 순서
// 1) 정수 삼각형 (프로그래머스 43105)
//핵심 아이디어
//삼각형 위에서 아래로 내려가며, 각 칸까지 올 수 있는 최대 합을 누적.
//현재 칸 (y,x)는 윗줄의 왼쪽 위(x-1) 또는 윗줄의 바로 위(x) 에서만 올 수 있음.
//
//상태/점화식
//dp[y][x]: (y,x)까지의 최대 합
//dp[y][x] = triangle[y][x] + max(dp[y-1][x-1], dp[y-1][x])
//모서리: dp[y][0] = dp[y-1][0] + triangle[y][0], dp[y][y] = dp[y-1][y-1] + triangle[y][y]

public class Solution {
    public static void main(String[] args) throws Exception{
        Solution sol = new Solution();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(sol.solution(triangle));
    }
    public int solution(int[][] triangle) {

        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];

        for (int y = 1; y < n; y++) {
            dp[y][0] = dp[y-1][0] + triangle[y][0];
            for (int x = 1; x < y; x++) {
                dp[y][x] = Math.max(dp[y-1][x-1], dp[y-1][x]) + triangle[y][x];
            }
            dp[y][y] = dp[y-1][y-1] + triangle[y][y];
        }
        int ans = 0;
        for (int v : dp[n-1]) ans = Math.max(ans, v);
        return ans;
    }
}
