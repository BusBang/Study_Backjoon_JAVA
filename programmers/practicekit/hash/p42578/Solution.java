import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        Solution sol = new Solution();
        String[][] clothes = {
                {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}
        };
        System.out.println(sol.solution(clothes));
    }
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] c : clothes) {
            String type = c[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        long ways = 1;
        for (int v : map.values()) {
            ways *= (v+1);
        }
        return (int)(ways - 1);
    }
}