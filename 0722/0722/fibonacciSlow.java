public class fibonacciSlow {

    
    public static int fibonacciSlow(int n) {
        if (n <= 1) return n;
        return fibonacciSlow(n - 1) + fibonacciSlow(n - 2);
    }
    // 時間複雜度：O(2^n)
    // 空間複雜度：O(n)

    // 記憶化版本 - 效率很好
    public static int fibonacciFast(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
        return memo[n];
    }
    // 時間複雜度：O(n)
    // 空間複雜度：O(n)

    public static void main(String[] args) {
        int n = 40;  // 你可以改成其他數字觀察差異

        // 測試慢版本
        long startSlow = System.currentTimeMillis();
        int resultSlow = fibonacciSlow(n);
        long endSlow = System.currentTimeMillis();
        System.out.println("fibonacciSlow(" + n + ") = " + resultSlow);
        System.out.println("耗時: " + (endSlow - startSlow) + " ms");

        // 測試快版本
        int[] memo = new int[n + 1];
        long startFast = System.currentTimeMillis();
        int resultFast = fibonacciFast(n, memo);
        long endFast = System.currentTimeMillis();
        System.out.println("fibonacciFast(" + n + ") = " + resultFast);
        System.out.println("耗時: " + (endFast - startFast) + " ms");
    }
}