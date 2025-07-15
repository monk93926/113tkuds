import java.util.*;

public class Q2_NextTHSRDeparture {
    /*
     * Time Complexity: O(log n)
     * 說明：先將時間轉換為整數，再用二分搜尋找出下一班車。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] schedule = new String[n];
        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            schedule[i] = sc.nextLine();
            times[i] = toMinutes(schedule[i]);
        }

        String queryStr = sc.nextLine();
        int query = toMinutes(queryStr);

        int idx = binarySearchNext(times, query);
        System.out.println(idx == n ? "No train" : schedule[idx]);
    }

    static int toMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    static int binarySearchNext(int[] times, int target) {
        int left = 0, right = times.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (times[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
