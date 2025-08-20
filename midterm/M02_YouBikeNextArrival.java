
import java.util.Scanner;

public class M02_YouBikeNextArrival {
    public static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();  // 消耗掉換行符
        
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = timeToMinutes(scanner.nextLine());
        }

        String queryTime = scanner.nextLine();
        int query = timeToMinutes(queryTime);

        // 使用二分搜尋法
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (times[mid] <= query) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left < n) {
            int nextArrival = times[left];
            System.out.printf("%02d:%02d\n", nextArrival / 60, nextArrival % 60);
        } else {
            System.out.println("No bike");
        }
    }
}
