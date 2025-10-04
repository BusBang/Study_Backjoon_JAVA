import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int sum = 0;
            int combo = 0;

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'O') {
                    combo++;
                    sum += combo;
                }else {
                    combo = 0;
                }
            }
            System.out.println(sum);
        }




    }
}
