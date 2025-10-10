import java.util.*;

// k 번째 수
public class Solution {

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}};

        System.out.println(Arrays.toString(sol.solution(array, commands)));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int t = 0; t < commands.length; t++) {
            int i = commands[t][0], j = commands[t][1], k = commands[t][2];
            int[] cut = Arrays.copyOfRange(array, i - 1, j);    // i-1 ~ j 구간 복사
            Arrays.sort(cut);
            answer[t] = cut[k-1];
        }
        return answer;
    }
}
