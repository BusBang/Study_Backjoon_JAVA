import java.util.*;

public class Solution {

    public static void main (String[] args) throws Exception {
        Solution sol = new Solution();
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println(Arrays.toString(sol.solution(tickets)));
    }
    private final Map<String, PriorityQueue<String>> graph = new HashMap<>();
    private final LinkedList<String> route = new LinkedList<>();

    public String[] solution(String[][] tickets) {
        for (String[] t : tickets) {
            graph.computeIfAbsent(t[0], k -> new PriorityQueue<>()).offer(t[1]);
        }
        dfs("ICN");
        return route.toArray(new String[0]);
    }

    private void dfs(String airport) {
        PriorityQueue<String> dests = graph.get(airport);
        while (dests != null && !dests.isEmpty()) {
            dfs(dests.poll());
        }
        route.addFirst(airport);
    }
}
