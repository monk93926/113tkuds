import java.util.*;

public class Q5_CPBLPrefixWins {
    /*
     * Time Complexity: O(n)
     * 說明：建立 prefix sum 陣列走訪一次即可。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] games = new int[n];
        String[] parts = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) games[i] = Integer.parseInt(parts[i]);
        int k = Integer.parseInt(sc.nextLine());

        int[] ps = new int[n + 1];
        for (int i = 1; i <= n; i++) ps[i] = ps[i - 1] + games[i - 1];

        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) System.out.print(" " + ps[i]);
        System.out.println();
    }
}
