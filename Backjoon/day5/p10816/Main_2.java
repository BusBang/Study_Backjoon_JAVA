import java.util.*;
import java.io.*;

public class Main_2 {
    // 이진 탐색을 위한 함수 lower, upper bound 함수를 만든다. 그러기 위해 main 함수 내 static 변수를 선언한다
    static int[] arr;

    public static void main(String[] args) throws Exception {
        // 문제
        //숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
        //
        //입력
        //첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
        //
        //셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
        //
        //출력
        //첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i< M; i++) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(upperBound(x) - lowerBound(x)).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
    // 이진 탐색을 위한 Upperbound, LowerBound를 직접 구현한다.
    // arr에서 x 이상이 처음 나오는 인덱스
    static int lowerBound(int x) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr[m] >= x) r = m;
            else l = m + 1;
        }
        return l;
    }

    // arr에서 x 초과가 처음 나오는 인덱스
    static int upperBound(int x){
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr[m] > x) r = m;
            else l = m + 1;
        }
        return l;
    }
}
