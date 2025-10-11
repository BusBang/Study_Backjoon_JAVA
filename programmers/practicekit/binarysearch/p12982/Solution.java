import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int[] d = {1,3,2,5,4};
        int budget = 9;
        System.out.println(sol.solution(d, budget));
    }

    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0, sum = 0;
        for (int x : d) {
            if (sum + x > budget) break;
            sum += x;
            count++;
        }
        return count;
    }
}
