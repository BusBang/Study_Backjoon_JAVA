import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        String number = "1924";
        int k = 2;
        System.out.println(sol.solution(number, k));
    }

    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(); // stack

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            // 뒤에 더 큰 숫자가 오면, 앞의작은 숫자를 제거해 앞자리를 키운다
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(c);
        }
        // 끝까지 증가(내림차순)여서 못 지운 경우 -> 뒤에 남은 K개 제거
        if (k>0) sb.setLength(sb.length() - k);
        return sb.toString();
    }
}
