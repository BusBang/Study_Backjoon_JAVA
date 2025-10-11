import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();

        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(sol.solution(bridge_length, weight, truck_weights));

    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Deque<Integer> bridge = new ArrayDeque<>();
        for(int i = 0; i < bridge_length; i++) bridge.addLast(0);

        int time = 0, sum = 0, idx = 0;

        while (idx < truck_weights.length) {
            time++;
            sum -= bridge.pollFirst();
            int next = truck_weights[idx];
            if (sum + next <= weight) {
                bridge.addLast(next);
                sum += next;
                idx++;
            } else {
                bridge.addLast(0);
            }
        }
        return time + bridge_length;
    }
}
