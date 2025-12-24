import java.util.*;

public class Solution {
    private static final StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        for (int i = 0; i < a.length(); i++) {
            int target = (int)a.charAt(i);
            if (65 <= target && target <= 90) {
                sb.append((char)(target + 32));
            } else if (97 <= target && target <= 122) {
                sb.append((char)(target - 32));
            }
        }
        System.out.println(sb.toString());
    }
}