import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // push X: 정수 X를 스택에 넣는 연산이다.
        //pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        //size: 스택에 들어있는 정수의 개수를 출력한다.
        //empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
        //top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.

        // 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
        // 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
        // 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                int value = Integer.parseInt(command.split(" ")[1]);
                stack.push(value);
            } else if (command.equals("pop")) {
                sb.append(stack.isEmpty() ? -1 : stack.pop()).append('\n');

            } else if (command.equals("size")) {
                sb.append(stack.size()).append('\n');

            } else if (command.equals("empty")) {
                sb.append(stack.isEmpty() ? 1 : 0).append('\n');
            } else if (command.equals("top")) {
                sb.append(stack.isEmpty() ? -1 : stack.peek()).append('\n');
            }


        }
        System.out.println(sb);


    }

}
