package lv1.p42862;

import java.util.*;

// 42862 - 체육복
// reverse로 +1, lost로 -1 상태표시.
// 자기 것 먼저 상쇄, 왼쪽 -> 오른쪽 순서로 빌려주기
public class Solution {

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1,3,5};
        System.out.println(sol.solution(n, lost, reserve));

    }
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        for (int x : lost) lostSet.add(x);
        for (int x : reserve) reserveSet.add(x);

        // 본인 것 먼저 상쇄
        Set<Integer> both = new HashSet<>(lostSet);
        both.retainAll(reserveSet);
        lostSet.removeAll(both);
        reserveSet.removeAll(both);

        // 분배 (왼쪽 우선, 안 되면 오른쪽)
        for (int r : new TreeSet<>(reserveSet)) { // 정렬은 선택
            if(lostSet.contains(r - 1)) lostSet.remove(r - 1);
            else if (lostSet.contains(r + 1)) lostSet.remove(r + 1);
        }
        return n - lostSet.size();
    }

}
