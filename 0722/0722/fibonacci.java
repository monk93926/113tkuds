public class fibonacci {

    public static int fibonacci(int n) {
        if (n == 0) return 0;         // 基底條件
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2); // 遞迴呼叫
    }

    public static void main(String[] args) {
        int n = 10;  // 要找第幾項
        System.out.println("費波納契數列第 " + n + " 項為: " + fibonacci(n));
    }
}