import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {3,3,3,2,2,4}));
    }
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        return Math.min(set.size(), nums.length/2);
    }
}
