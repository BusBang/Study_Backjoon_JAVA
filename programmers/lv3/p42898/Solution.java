import java.util.*;

// 2) 등굣길 (프로그래머스 42898)
//핵심 아이디어
//오른쪽/아래로만 이동. 각 칸의 경로 수는 위 + 왼쪽 합.
//물웅덩이는 0으로 막는다. 좌표가 1-indexed 로 들어옴에 주의.
//
//상태/점화식
//dp[y][x]: (1,1)→(y,x) 최단경로 수
//dp[y][x] = (dp[y-1][x] + dp[y][x-1]) % MOD, 단 웅덩이는 0
public class Solution {

    public static void main(String[] args) throws Exception{
        Solution sol = new Solution();
        int m = 4, n = 3;
        int[][] puddles = {{2, 2}};
        System.out.println(sol.solution(m,n,puddles));
    }

    static final int MOD = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] block = new boolean[n+1][m+1];
        for (int[] p : puddles) block[p[1]][p[0]] = true;   // (y, x)

        int [][] dp = new int[n+1][m+1];
        dp[1][1] = 1;

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (y == 1 && x ==1) continue;
                if (block[y][x]) {
                    dp[y][x] = 0;
                    continue;
                }
                dp[y][x] = ((block[y-1][x] ? 0 : dp[y-1][x]) + (block[y][x-1] ? 0 :dp[y][x-1])) % MOD;
            }
        }
        return dp[n][m];
    }
}
