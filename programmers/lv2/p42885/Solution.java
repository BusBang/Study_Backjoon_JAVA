import java.util.*;

// p42885 구명보트
// 정렬 + 투 포인터

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        Solution sol = new Solution();
        System.out.println(sol.solution(people, limit));

    }
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1, boats = 0;
        while (l <= r) {
            if (people[l] + people[r] <= limit) l++;    // 같이 태움
            r--;    // 무거운 쪽은 반드시 나감
            boats++;
        }
        return boats;
    }
}
