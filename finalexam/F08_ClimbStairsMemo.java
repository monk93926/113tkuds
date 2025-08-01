import java.util.*;

public class F08_ClimbStairsMemo {
    static long[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        memo = new long[n + 1];
        Arrays.fill(memo, -1);
        System.out.println("Ways: " + ways(n));
        sc.close();
    }

    static long ways(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (memo[n] != -1) return memo[n];
        memo[n] = ways(n - 1) + ways(n - 2) + ways(n - 3);
        return memo[n];
    }
}
