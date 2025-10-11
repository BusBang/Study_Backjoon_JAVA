import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.MIN_VALUE;    // 최댓값을 저장
        int index = 0;  // index val

        for (int i = 1; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());

            if (max < num) {
                max = num;
                index = i;
            }
        }

        System.out.println(max);
        System.out.println(index);


    }
}
