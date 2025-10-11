import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception{
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[] {"119", "97674223", "1195524421"}));
    }
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        return true;
    }
}