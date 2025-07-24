public class digitSum {

    // 遞迴計算數字的各位總和
    public static int digitSum(int n) {
        if (n < 10) {
            return n; // 個位數直接回傳
        }
        return (n % 10) + digitSum(n / 10);
    }

    public static void main(String[] args) {
        int n1 = 1234;
        int n2 = 56789;
        int n3 = 9;

        System.out.println("1234 的各位數總和: " + digitSum(n1));  // 1+2+3+4 = 10
        System.out.println("56789 的各位數總和: " + digitSum(n2)); // 5+6+7+8+9 = 35
        System.out.println("9 的各位數總和: " + digitSum(n3));     // 9
    }
}