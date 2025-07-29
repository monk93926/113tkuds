import java.util.*;

public class F07_AnagramPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') freq[c - 'a']++;
        }
        int oddCount = 0;
        for (int f : freq) {
            if (f % 2 != 0) oddCount++;
        }
        System.out.println(oddCount <= 1 ? "Possible" : "Impossible");
        sc.close();
    }
}
