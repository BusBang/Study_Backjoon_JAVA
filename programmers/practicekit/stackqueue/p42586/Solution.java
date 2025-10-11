import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int [] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1,1,1,1,1,1};
        System.out.println(Arrays.toString(sol.solution(progresses, speeds)));
    }
    public int[] solution(int[] progresses, int[] speeds) {

        int n = progresses.length;
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            int remain = 100 - progresses[i];
            days[i] = (remain - speeds[i] - 1) / speeds[i];
        }
        List<Integer> res = new ArrayList<>();

        int base = days[0], cnt = 1;
        for (int i = 1; i < n; i++) {
            if (days[i] <= base) cnt++;
            else {
                res.add(cnt);
                cnt = 1;
                base = days[i];
            }
        }
        res.add(cnt);
        return res.stream().mapToInt(i->i).toArray();
    }
}
