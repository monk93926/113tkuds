import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        
        String[] stops = sc.nextLine().split(" ");
        String start = sc.next();
        String end = sc.next();

        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) {
                startIndex = i;
            }
            if (stops[i].equals(end)) {
                endIndex = i;
            }
        }

        if (startIndex == -1 || endIndex == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(startIndex - endIndex) + 1);
        }
    }
    }


/*
 * Time Complexity: O(n)
 * 說明：單一 for 迴圈走訪 n 個站碼以尋找起訖站索引，為線性時間。
 */
