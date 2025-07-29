import java.util.*;

public class F05_LCMRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = gcd(a, b);
        int lcm = a / gcd * b;
        System.out.println("LCM: " + lcm);
        sc.close();
    }

    static int gcd(int a, int b) {
        if (a == b) return a;
        if (a > b) return gcd(a - b, b);
        else return gcd(a, b - a);
    }
}

/*
 * Time Complexity: O(max(a,b))  (較差)
 * 說明：輾轉相減法在最壞情況下，兩數差距逐步縮小，複雜度接近 O(max(a,b))，比除法法較慢。
 */
