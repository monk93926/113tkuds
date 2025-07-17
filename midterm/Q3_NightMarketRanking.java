import java.util.*;

public class Q3_NightMarketRanking {
    /*
     * Time Complexity: O(n^2)
     * 說明：使用選擇排序，每回合找最大分數並交換位置，總比較次為 n(n-1)/2。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double[] scores = new double[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Double.parseDouble(sc.nextLine());
        }

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIdx]) maxIdx = j;
            }
            double temp = scores[i];
            scores[i] = scores[maxIdx];
            scores[maxIdx] = temp;
        }

        for (int i = 0; i < Math.min(5, n); i++) {
            System.out.printf("%.1f\n", scores[i]);
        }
    }
}
