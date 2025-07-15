import java.util.*;

public class Q1_THSRStopCounter {
    /*
     * Time Complexity: O(n)
     * 說明：走訪陣列一次找出起點與終點索引，最多 2n 次比較。
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] stations = sc.nextLine().split(" ");
        String start = sc.next();
        String end = sc.next();

        int startIdx = -1, endIdx = -1;
        for (int i = 0; i < n; i++) {
            if (stations[i].equals(start)) startIdx = i;
            if (stations[i].equals(end)) endIdx = i;
        }

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(endIdx - startIdx) + 1);
        }
    }
}

