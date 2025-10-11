import java.util.*;

// 2×n 타일링 (프로그래머스 12900)
//핵심 아이디어
//2×n 보드를 2×1 타일(세로) 또는 1×2 타일 2개(가로 두 칸)로 채운다.
//맨 오른쪽 열을 채우는 방식 기준:
//f[n] = f[n-1] (세로 하나) + f[n-2] (가로 두 개)
//
//상태/점화식
//f[1] = 1, f[2] = 2, f[n] = (f[n-1] + f[n-2]) % MOD
public class Solution {

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.solution(4));
    }
    static final int MOD = 1_000_000_007;

    public int solution(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2;   // f[1], f[2]
        for (int i = 3; i <= n; i++) {
            int c = (a+b) % MOD;
            a = b;
            b = c;
        }
        return b;
    }
}
