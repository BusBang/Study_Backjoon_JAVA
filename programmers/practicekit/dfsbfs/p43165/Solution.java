import java.util.*;
public class Solution {
    public static void main(String[] args) throws  Exception{
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {1,1,1,1,1}, 3));
    }

    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] a, int target, int idx, int sum) {
        if (idx == a.length) return (sum == target) ? 1 : 0;
        // 현재 숫자를 + 또는 -로 선택
        return dfs(a, target, idx + 1, sum + a[idx])
                + dfs(a, target, idx + 1, sum - a[idx]);
    }
}
