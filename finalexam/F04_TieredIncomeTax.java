import java.util.*;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] incomes = new int[n];
        for (int i = 0; i < n; i++) {
            incomes[i] = sc.nextInt();
        }
        double totalTax = 0;

        for (int i = 0; i < n; i++) {
            double tax = calcTax(incomes[i]);
            System.out.printf("Tax: $%.0f\n", tax);
            totalTax += tax;
        }
        System.out.printf("Average: $%.0f\n", totalTax / n);
        sc.close();
    }

    static double calcTax(int income) {
        int[] brackets = {540000, 1210000, 2420000, 4530000};
        double[] rates = {0.05, 0.12, 0.20, 0.30, 0.40};
        double tax = 0;
        int prev = 0;

        for (int i = 0; i < brackets.length; i++) {
            if (income <= brackets[i]) {
                tax += (income - prev) * rates[i];
                return tax;
            } else {
                tax += (brackets[i] - prev) * rates[i];
                prev = brackets[i];
            }
        }
        tax += (income - prev) * rates[rates.length - 1];
        return tax;
    }
}

/*
 * Time Complexity: O(n)
 * 說明：對每筆收入計算稅額時，以常數次段階稅率判斷，整體時間為 O(n)。
 */
