import java.util.Scanner;

public class searchnumberbinary {
    public static void main(String[] args) {
        int[] s = {1, 3, 5, 7, 9, 11, 13};
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入要查的數字:");
        int x = scanner.nextInt();

        int left = 0;
        int right = s.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("比對中: left = " + left + ", right = " + right + ", mid = " + mid + " → s[mid] = " + s[mid]);

            if (s[mid] == x) {
                found = true;
                break;
            } else if (s[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (found) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        scanner.close();
    }
}