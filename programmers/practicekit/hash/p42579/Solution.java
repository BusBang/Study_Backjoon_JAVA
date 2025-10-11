import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        Solution sol = new Solution();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(sol.solution(genres, plays)));
    }
    static class Song {
        int idx, plays;
        Song(int i, int p){ idx = i; plays = p; }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> sum = new HashMap<>();
        Map<String, List<Song>> by = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            sum.put(genres[i], sum.getOrDefault(genres[i], 0) + plays[i]);
            by.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }

        List<String> order = new ArrayList<>(sum.keySet());
        order.sort((a,b) -> sum.get(b) - sum.get(a));

        List<Integer> pick = new ArrayList<>();
        for (String g : order) {
            List<Song> list = by.get(g);
            list.sort((s1, s2) -> s1.plays == s2.plays ? s1.idx - s2.idx : s2.plays - s1.plays);

            for (int i=0; i < Math.min(2, list.size()); i++) pick.add(list.get(i).idx);
        }
        return pick.stream().mapToInt(i -> i).toArray();
    }
}