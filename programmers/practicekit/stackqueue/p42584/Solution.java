import java.util.*;

public class Solution {

    public static void main(String[] args) throws  Exception{
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {1,2,3,2,3}));
    }

    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && prices[st.peek()] > prices[i]) {
                int j = st.pop();
                ans[j] = i - j;
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int j = st.pop();
            ans[j] = (n-1) - j;
        }
        return ans;
    }
}
