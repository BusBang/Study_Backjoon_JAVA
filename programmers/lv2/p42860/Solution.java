import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.solution("JAZ"));
    }
    public int solution(String name) {
        int n = name.length();

        // 수직 이동 합
        int vertical = 0;
        for (int i = 0; i < n; i++) {
            int up = name.charAt(i) - 'A';
            int down = 'Z' - name.charAt(i) + 1;
            vertical += Math.min(up, down);
        }

        // 수평 이동 최소
        int horizontal = n - 1; // 직진 기준
        for (int i = 0; i < n; i++) {
            int next = i + 1;
            // i 다음부터 이어지는 'A' 덩어리의 끝을 찾는다
            while (next < n && name.charAt(next) == 'A') next++;

            // 케이스 1: i까지 오른쪽으로 갔다가 되돌아가서 끝으로 가기
            //  - 오른쪽 i까지 갔다가 되돌아옴( i ), 다시 끝까지 감( n - next )
            //  - 왕복이라 i를 두 번: 2*i + (n - next)
            horizontal = Math.min(horizontal, 2 * i + (n - next));

            // 케이스 2: 끝까지 갔다가 되돌아와서 i로 돌아오기
            //  - 끝까지 먼저 가는 비용(n-1)과 같은 효과를 식으로 표현한 형태
            //  - i + 2*(n - next)
            horizontal = Math.min(horizontal, i + 2 * (n - next));
        }
        return vertical + horizontal;
    }
}
