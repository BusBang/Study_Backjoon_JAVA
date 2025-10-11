import java.util.*;

// H-index

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{3, 0, 6, 1, 5}));
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;

        for (int i = 0; i < n; i++) {
            int cand = Math.min(citations[i], n-i);
            h = Math.max(h, cand);
        }
        return h;
    }
}
