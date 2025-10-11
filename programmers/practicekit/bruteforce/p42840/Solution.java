import java.util.*;


public class Solution {

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1,3,2,4,2}));
    }
    public int[] solution(int[] answers) {
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};

        int[] score = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % p1.length]) score[0]++;
            if (answers[i] == p2[i % p2.length]) score[1]++;
            if (answers[i] == p3[i % p3.length]) score[2]++;
        }
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 3; i++) if(score[i] == max) res.add(i + 1);

        return res.stream().mapToInt(i->i).toArray();
    }

}
