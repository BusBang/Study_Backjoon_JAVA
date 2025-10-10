import java.util.*;

// 17681 - 비밀지도
// 아이디어 (비트 OR + 출력 포맷)
//각 행 i에서 row = arr1[i] | arr2[i] (비트 OR).
//row의 이진 표현을 왼쪽부터 n자리로 읽으면서
//1 → '#',
//0 → ' '(공백)
//로 치환하면 그 줄 완성.
//복잡도: O(n).
public class Solution {

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(Arrays.toString(sol.solution(n, arr1, arr2)));

    }
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            int row = arr1[i] | arr2[i];
            StringBuilder sb = new StringBuilder(n);
            // 상위 비트부터 n자리 채우기
            for (int j = n - 1; j >= 0; j--) {
                sb.append(((row >> j) & 1) == 1 ? '#' : ' ');
            }

            ans[i] = sb.toString();
        }
        return ans;
    }
}
