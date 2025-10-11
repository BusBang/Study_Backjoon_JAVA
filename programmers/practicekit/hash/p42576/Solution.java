import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        Solution sol = new Solution();
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(sol.solution(participant, completion));
    }
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String p : participant) map.put(p, map.getOrDefault(p, 0) + 1);
        for (String c : completion) map.put(c, map.get(c) - 1);
        for (Map.Entry<String, Integer> e : map.entrySet())
            if (e.getValue() > 0) return e.getKey();
        return "";
    }
}
