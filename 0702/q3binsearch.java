import java.util.Scanner;

public class q3binsearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int ops = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int low = 0, high = n - 1;
        int result = -1;
        while (low <= high) {
            ops++;
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                result = mid;
                break;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(result);
        System.out.println(ops);
    }
}
