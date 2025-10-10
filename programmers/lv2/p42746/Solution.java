import java.util.*;

// 아이디어
//숫자들을 문자열로 바꾼 뒤, 두 문자열 a, b의 순서를
//**(b+a) vs (a+b)**를 비교해서 더 큰 쪽이 앞에 오도록 정렬.
//모든 숫자가 0일 때는 "0" 반환(예: [0,0,0] → "0").
// 실수 포인트
// 정수 비교 금지: (b+a)가 int 범위를 넘을 수 있으니 문자열 비교로!
// 선행 0 처리: 정렬 후 첫 원소가 "0"이면 결과는 "0".
// Comparator는 내림차순으로 (b+a) vs (a+b) 비교해야 함.

public class Solution {

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {3,30, 34, 5, 9}));
    }

    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) arr[i] = String.valueOf(numbers[i]);

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));   // 핵심 정렬

        if (arr[0].equals("0")) return "0";   // 모두 0인 경우

        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);
        return sb.toString();
    }
}
