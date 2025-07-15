import java.util.*;

public class Q4_TieredElectricBill {
    /*
     * Time Complexity: O(n)
     * 說明：每筆電費計算常數時間，走訪一次輸入。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int total = 0;

        for (int i = 0; i < n; i++) {
            int kWh = Integer.parseInt(sc.nextLine());
            int bill = calc(kWh);
            System.out.println("Bill: $" + bill);
            total += bill;
        }

        int avg = Math.round((float) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + avg);
    }

    static int calc(int kWh) {
        double total = 0;
        int[] limits = {120, 210, 170, 200, 300, Integer.MAX_VALUE};
        double[] rates = {1.68, 2.45, 3.70, 5.04, 6.24, 8.46};

        for (int i = 0; i < limits.length && kWh > 0; i++) {
            int used = Math.min(kWh, limits[i]);
            total += used * rates[i];
            kWh -= used;
        }
        return (int) Math.round(total);
    }
}
