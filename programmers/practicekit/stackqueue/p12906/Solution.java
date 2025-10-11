package practicekit.stackqueue.p12906;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int []{1,1,3,3,0,1,1})));
    }

    public int[] solution(int []arr) {
        List<Integer> res = new ArrayList<>();
        Integer prev = null;

        for (int v : arr) {
            if (prev == null || prev != v) res.add(v);
            prev = v;
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
