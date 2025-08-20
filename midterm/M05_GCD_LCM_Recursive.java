import java.util.Scanner;

public class M05_GCD_LCM_Recursive {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int gcd = gcd(a, b);
        int lcm = a / gcd * b;  // 防止溢位

        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);
    }
}
