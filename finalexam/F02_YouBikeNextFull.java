import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] times = new int[n];

        // 將 HH:mm 時間轉換成分鐘表示
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(":");
            times[i] = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        }

        // 轉換查詢時間
        String[] queryParts = sc.nextLine().split(":");
        int query = Integer.parseInt(queryParts[0]) * 60 + Integer.parseInt(queryParts[1]);

        // 二分搜尋找第一個大於 query 的時間
        int left = 0, right = n - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > query) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 輸出結果
        if (ans == -1) {
            System.out.println("No bike");
        } else {
            int h = times[ans] / 60;
            int m = times[ans] % 60;
            System.out.printf("%02d:%02d\n", h, m);
        }
    }
}

/*
 * Time Complexity: O(log n)
 * 說明：使用二分搜尋在已排序的時間陣列中尋找第一個大於查詢時間的時間點，因此為對數階。
 */
