import java.util.*;

// 엣지 케이스 커버
//빈 문자열, 이미 올바름, 최소 길이 "()", 완전 역순, 길이 1000 극한
//스택 없이 누적합으로 “올바름” 판정 → 빠르고 간결0
//시간복잡도: 각 재귀 단계 O(n), 총 O(n²) (n ≤ 1000 → 충분)

//문제 핵심 요약
//
//주어진 문자열 p를 “올바른 괄호 문자열”로 바꾸는 규칙:
//p를 균형잡힌 접두사 u와 나머지 v로 분리 (u는 '('와 ')' 개수가 같아지는 가장 앞 부분)
//u가 올바른 괄호 문자열이면 → 결과는 u + solve(v)
//
//아니라면 → 결과는
//"(" + solve(v) + ")" + reverse(u의 첫/끝 제거분)
//여기서 reverse는 '(' ↔ ')' 치환
//균형잡힌(balanced): '(' 수 == ')' 수
//올바른(correct): 왼쪽부터 누적할 때 한 번도 ')'가 '('보다 많아지지 않음 (마지막에 같아짐)

class Solution {
    public String solution(String p) {
        return solve(p);
    }

    // 재귀 변환 로직
    private String solve(String s) {
        // 0. 빈 문자열이면 그대로 반환
        if (s.isEmpty()) return s;

        // 1. s를 균형잡힌 u v로 분리
        int cut = splitBalancedIndex(s);
        String u = s.substring(0, cut + 1);
        String v = s.substring(cut + 1);

        // 2. u가 올바른 괄호면: u + solve(v)
        if (isCorrect(u)) return u + solve(v);

        // 3. u가 올바르지 않으면
        // "(" + solve(v) + ")" "u의 앞뒤 제거 후 뒤집기
        StringBuilder sb = new StringBuilder();
        sb.append('(').append(solve(v)).append(')');

        for (int i = 1; i < u.length() -1; i++) {
            sb.append(u.charAt(i) == '(' ? ')' : '('); // 뒤집기
        }
        return sb.toString();
    }

    // s를 앞에서 순회하며 ( )의 개수가 처음 같아지는 위치 반환
    private int splitBalancedIndex(String s) {
        int bal = 0;
        for (int i = 0; i < s.length(); i++) {
            bal += (s.charAt(i) == '(') ? 1 : -1;
            if (bal == 0) return i; // 최초 균형 지점이 u의 끝
        }
        return s.length() - 1; // 이론상 도달 X
    }
    // 올바른 괄호 판정 : 누적 합이 중간에 음수가 되면 false
    private boolean isCorrect(String s) {
        int bal = 0;
        for (int i = 0; i < s.length(); i++) {
            bal += (s.charAt(i) == '(') ? 1 : -1;
            if (bal < 0) return false;
        }
        return bal == 0; // 끝나고 균형이면 올바름
    }

}
